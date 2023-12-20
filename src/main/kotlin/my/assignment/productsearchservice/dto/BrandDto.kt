package my.assignment.productsearchservice.dto

import my.assignment.productsearchservice.entity.Brand

data class BrandDto(
    val id: Long? = null,
    val name: String? = null
) {

    companion object {

        fun fromBrand(brand: Brand): BrandDto {
            return BrandDto(
                id = brand.id,
                name = brand.name
            )
        }
    }
}
