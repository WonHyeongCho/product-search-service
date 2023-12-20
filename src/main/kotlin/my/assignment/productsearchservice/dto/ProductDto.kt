package my.assignment.productsearchservice.dto

import my.assignment.productsearchservice.entity.Product

data class ProductDto(
    val id: Long? = null,
    val price: Double? = null,
    val brand: BrandDto? = null,
    val category: CategoryDto? = null
) {

    companion object {

        fun fromProduct(product: Product): ProductDto {
            return ProductDto(
                id = product.id,
                price = product.price,
                brand = product.brand?.let { BrandDto.fromBrand(it) },
                category = product.category?.let { CategoryDto.fromCategory(it) },
            )
        }
    }
}
