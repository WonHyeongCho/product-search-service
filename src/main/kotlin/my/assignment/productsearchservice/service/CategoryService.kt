package my.assignment.productsearchservice.service

import my.assignment.productsearchservice.entity.Category
import my.assignment.productsearchservice.exception.ErrorEnum
import my.assignment.productsearchservice.exception.ProductSearchServiceException
import my.assignment.productsearchservice.repository.CategoryRepository
import org.springframework.stereotype.Service

@Service
class CategoryService(
    private val categoryRepository: CategoryRepository
) {

    fun getCategory(id: Long): Category {
        return categoryRepository.findById(id).orElseThrow {
            throw ProductSearchServiceException(
                ErrorEnum.RESOURCE_NOT_FOUND
            )
        }
    }

    fun getCategoryWiseMinPrice(): List<Category> {
        var categoryWiseMinPriceItems = categoryRepository.findCategoryWiseMinimumPrices()

        // 중복으로 조회된 카테고리가 있을 수 있으므로 distinct 처리
        categoryWiseMinPriceItems = categoryWiseMinPriceItems.distinct()
        // 카테고리별 최저가 상품이 2개 이상일 경우 마지막 1개만 남기고 삭제
        categoryWiseMinPriceItems.forEach {
            if (it.products?.size!! > 1) {
                it.products = it.products?.takeLast(1)
            }
        }

        return categoryWiseMinPriceItems
    }
}
