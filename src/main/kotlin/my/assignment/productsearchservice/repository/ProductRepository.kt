package my.assignment.productsearchservice.repository

import my.assignment.productsearchservice.entity.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface ProductRepository : JpaRepository<Product, Long> {
    
    @Query("SELECT p FROM Product p JOIN FETCH p.brand JOIN FETCH p.category")
    override fun findAll(): List<Product>
}
