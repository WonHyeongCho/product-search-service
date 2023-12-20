package my.assignment.productsearchservice.dto

import my.assignment.productsearchservice.entity.Category

data class CategoryDto(
    val id: Long? = null,
    val name: String? = null
) {

    companion object {

        fun fromCategory(category: Category): CategoryDto {
            return CategoryDto(
                id = category.id,
                name = category.name
            )
        }
    }
}
