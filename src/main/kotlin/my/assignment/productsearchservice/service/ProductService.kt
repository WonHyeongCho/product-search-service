package my.assignment.productsearchservice.service

import my.assignment.productsearchservice.dto.request.ProductRequestDto
import my.assignment.productsearchservice.entity.Product
import my.assignment.productsearchservice.exception.ErrorEnum
import my.assignment.productsearchservice.exception.ProductSearchServiceException
import my.assignment.productsearchservice.repository.ProductRepository
import org.springframework.stereotype.Service

@Service
class ProductService(
    private val productRepository: ProductRepository,
    private val brandService: BrandService,
    private val categoryService: CategoryService,
) {

    fun getProductList(): List<Product> {
        return productRepository.findAll()
    }

    fun getProduct(id: Long): Product {
        return findProduct(id)
    }

    fun createProduct(productRequestDto: ProductRequestDto): Product {
        // 브랜드 조회 & 카테고리 조회
        val brand = brandService.getBrand(productRequestDto.brandId)
        val category = categoryService.getCategory(productRequestDto.categoryId)

        // 상품 생성
        val product = Product().apply {
            price = productRequestDto.price
            this.brand = brand
            this.category = category
        }

        return saveProduct(product)
    }

    fun updateProduct(id: Long, productRequestDto: ProductRequestDto): Product {
        // 상품 조회하여 업데이트
        val product = findProduct(id).apply {
            price = productRequestDto.price
            this.brand = brandService.getBrand(productRequestDto.brandId)
            this.category = categoryService.getCategory(productRequestDto.categoryId)
        }

        return saveProduct(product)
    }

    fun deleteProduct(id: Long) {
        productRepository.deleteById(id)
    }

    private fun findProduct(id: Long): Product {
        return productRepository.findById(id)
            .orElseThrow { throw ProductSearchServiceException(ErrorEnum.RESOURCE_NOT_FOUND) }
    }

    private fun saveProduct(product: Product): Product {
        return productRepository.save(product)
    }
}
