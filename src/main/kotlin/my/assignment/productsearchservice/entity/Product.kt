package my.assignment.productsearchservice.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne

@Entity
class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0
    var price: Double = 0.0

    @ManyToOne
    @JoinColumn(name = "brand_id")
    var brand: Brand? = null

    @ManyToOne
    @JoinColumn(name = "category_id")
    var category: Category? = null
}
