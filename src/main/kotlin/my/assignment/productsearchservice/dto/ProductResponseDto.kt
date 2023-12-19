package my.assignment.productsearchservice.dto

import my.assignment.productsearchservice.entity.Product

data class ProductResponseDto(
    val id: Long? = null,
    val price: Double? = null,
    val brand: BrandResponseDto? = null,
    val category: CategoryResponseDto? = null
) {

    companion object {

        fun fromProduct(product: Product): ProductResponseDto {
            return ProductResponseDto(
                id = product.id,
                price = product.price,
                brand = product.brand?.let { BrandResponseDto.fromBrand(it) },
                category = product.category?.let { CategoryResponseDto.fromCategory(it) },
            )
        }
    }
}
