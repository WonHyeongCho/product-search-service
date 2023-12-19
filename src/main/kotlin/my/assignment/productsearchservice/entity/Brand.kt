package my.assignment.productsearchservice.entity

import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import my.assignment.productsearchservice.dto.BrandResponseDto

@Entity
class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0
    var name: String = ""

    @OneToMany(cascade = [CascadeType.REMOVE], mappedBy = "brand")
    var products: List<Product>? = null

    fun toBrandResponseDto(): BrandResponseDto {
        return BrandResponseDto(
            id = this.id,
            name = this.name
        )
    }
}
