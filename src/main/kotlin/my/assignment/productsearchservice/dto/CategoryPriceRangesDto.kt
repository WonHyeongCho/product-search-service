package my.assignment.productsearchservice.dto

class CategoryPriceRangesDto(
    val category: String,
    lowestPrice: Pair<String, Double>,
    highestPrice: Pair<String, Double>,
) {

    var lowestPrice: PriceRange = PriceRange(lowestPrice.first, lowestPrice.second)
    var highestPrice: PriceRange = PriceRange(highestPrice.first, highestPrice.second)
}

data class PriceRange(
    val brand: String,
    val price: Double,
)
