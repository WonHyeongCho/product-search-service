package my.assignment.productsearchservice.dto

import my.assignment.productsearchservice.entity.Brand

class BrandWithLowestPriceDto(
    brand: Brand
) {

    var lowestPrice: LowestPrice? = null

    init {
        val brandName = brand.name
        val categories = brand.products?.map {
            CategoryWithPrice(
                category = it.category?.name ?: "",
                price = it.price
            )
        }
        val totalPrice = brand.products?.sumOf { it.price } ?: 0.0
        lowestPrice = LowestPrice(
            brand = brandName,
            categories = categories ?: listOf(),
            totalPrice = totalPrice
        )
    }
}

class LowestPrice(
    val brand: String,
    val categories: List<CategoryWithPrice>,
    val totalPrice: Double,
)

class CategoryWithPrice(
    val category: String,
    val price: Double,
)
