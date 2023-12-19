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
}
