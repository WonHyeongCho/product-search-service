package my.assignment.productsearchservice.repository

import my.assignment.productsearchservice.entity.Brand
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BrandRepository : JpaRepository<Brand, Long> {
    
    fun existsByName(name: String): Boolean
}
