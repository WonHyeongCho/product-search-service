package my.assignment.productsearchservice.dto

import com.fasterxml.jackson.annotation.JsonProperty
import my.assignment.productsearchservice.entity.Brand

data class BrandRequestDto(
    @JsonProperty("name") val name: String
) {

    fun toBrand(): Brand {
        val brand = Brand()
        brand.name = this.name
        return brand
    }
}
