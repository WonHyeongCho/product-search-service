package my.assignment.productsearchservice.dto.request

// TODO validate 구현
data class ProductRequestDto(
    val price: Double,
    val brandId: Long,
    val categoryId: Long,
)
