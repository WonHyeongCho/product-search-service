package my.assignment.productsearchservice.dto

import my.assignment.productsearchservice.entity.Brand

data class BrandResponseDto(
    val id: Long? = null,
    val name: String? = null
) {

    companion object {

        fun fromBrand(brand: Brand): BrandResponseDto {
            return BrandResponseDto(
                id = brand.id,
                name = brand.name
            )
        }
    }
}
