package my.assignment.productsearchservice.service

import my.assignment.productsearchservice.dto.BrandResponseDto
import my.assignment.productsearchservice.entity.Brand
import my.assignment.productsearchservice.exception.ErrorEnum
import my.assignment.productsearchservice.exception.ProductSearchServiceException
import my.assignment.productsearchservice.repository.BrandRepository
import org.springframework.stereotype.Service

@Service
class BrandService(
    private val brandRepository: BrandRepository
) {

    fun getBrandList(): List<BrandResponseDto> {
        return brandRepository.findAll().map { BrandResponseDto.fromBrand(it) }
    }

    fun getBrand(id: Long): BrandResponseDto {
        return brandRepository.findById(id).map { BrandResponseDto.fromBrand(it) }
            .orElseThrow { throw ProductSearchServiceException(ErrorEnum.RESOURCE_NOT_FOUND) }
    }

    fun createBrand(brand: Brand): BrandResponseDto {
        // 이름으로 중복 검사
        if (brandRepository.existsByName(brand.name)) {
            throw ProductSearchServiceException(ErrorEnum.RESOURCE_ALREADY_EXISTS)
        }

        return saveBrand(brand).let { BrandResponseDto.fromBrand(it) }
    }

    fun updateBrand(id: Long, brand: Brand): BrandResponseDto {
        // 아이디로 데이터가 존재하는지 검사
        if (!brandRepository.existsById(id)) {
            throw ProductSearchServiceException(ErrorEnum.RESOURCE_NOT_FOUND)
        }

        brand.id = id

        return saveBrand(brand).let { BrandResponseDto.fromBrand(it) }
    }

    fun deleteBrand(id: Long) {
        brandRepository.deleteById(id)
    }

    private fun saveBrand(brand: Brand): Brand {
        return brandRepository.save(brand)
    }
}
