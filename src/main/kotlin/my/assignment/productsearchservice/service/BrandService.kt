package my.assignment.productsearchservice.service

import my.assignment.productsearchservice.dto.request.BrandRequestDto
import my.assignment.productsearchservice.entity.Brand
import my.assignment.productsearchservice.exception.ErrorEnum
import my.assignment.productsearchservice.exception.ProductSearchServiceException
import my.assignment.productsearchservice.repository.BrandRepository
import org.springframework.stereotype.Service

@Service
class BrandService(
    private val brandRepository: BrandRepository
) {

    fun getBrandList(): List<Brand> {
        return brandRepository.findAll()
    }

    fun getBrand(id: Long): Brand {
        return brandRepository.findById(id)
            .orElseThrow { throw ProductSearchServiceException(ErrorEnum.RESOURCE_NOT_FOUND) }
    }

    fun createBrand(brandRequestDto: BrandRequestDto): Brand {
        val brand = brandRequestDto.toBrand()

        // 이름으로 중복 검사
        if (brandRepository.existsByName(brand.name)) {
            throw ProductSearchServiceException(ErrorEnum.RESOURCE_ALREADY_EXISTS)
        }

        return saveBrand(brand)
    }

    fun updateBrand(id: Long, brandRequestDto: BrandRequestDto): Brand {
        // 아이디로 데이터가 존재하는지 검사
        if (!brandRepository.existsById(id)) {
            throw ProductSearchServiceException(ErrorEnum.RESOURCE_NOT_FOUND)
        }

        val brand = brandRequestDto.toBrand().apply { this.id = id }

        return saveBrand(brand)
    }

    fun deleteBrand(id: Long) {
        brandRepository.deleteById(id)
    }

    fun getBrandWithLowestTotalPrice(): Brand {
        val brandWithTotalPrice: List<Map<String, Any>> = brandRepository.findBrandWitTotalPrice()
        val brandWithLowestTotalPriceInfo = brandWithTotalPrice.firstOrNull()
        val brandWithLowestTotalPrice =
            brandRepository.findById(brandWithLowestTotalPriceInfo?.get("brand_id") as Long)
        return getBrand(brandWithLowestTotalPrice.get().id)
    }

    private fun saveBrand(brand: Brand): Brand {
        return brandRepository.save(brand)
    }
}
