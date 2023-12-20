package my.assignment.productsearchservice.dto

import my.assignment.productsearchservice.entity.Category

class CategoryWiseMinPriceDto(
    categories: List<Category>
) {

    var productInfoList: List<ProductInfo> = mutableListOf()
    var sumOfMinPrices: Double? = null

    init {
        // 카테고리들의 프로덕트 정보로 DTO 초기화
        categories.map { category ->
            category.products?.let { products ->
                products.map { product ->
                    productInfoList = productInfoList.plus(
                        ProductInfo(
                            price = product.price,
                            brandName = product.brand?.name ?: "",
                            categoryName = product.category?.name ?: ""
                        )
                    )
                }
            }
        }
        sumOfMinPrices = productInfoList.sumOf { it.price }
    }
}

data class ProductInfo(
    var price: Double,
    var brandName: String,
    var categoryName: String,
)
