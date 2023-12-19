package my.assignment.productsearchservice.dto

import my.assignment.productsearchservice.entity.Category

data class CategoryResponseDto(
    val id: Long? = null,
    val name: String? = null
) {

    companion object {

        fun fromCategory(category: Category): CategoryResponseDto {
            return CategoryResponseDto(
                id = category.id,
                name = category.name
            )
        }
    }
}
