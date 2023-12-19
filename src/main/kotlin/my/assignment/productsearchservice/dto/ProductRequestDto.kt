package my.assignment.productsearchservice.dto

data class ProductRequestDto(
    val price: Double,
    val brandId: Long,
    val categoryId: Long,
)
