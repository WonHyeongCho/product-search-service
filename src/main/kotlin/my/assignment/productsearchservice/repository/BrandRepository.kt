package my.assignment.productsearchservice.repository

import my.assignment.productsearchservice.entity.Brand
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface BrandRepository : JpaRepository<Brand, Long> {

    fun existsByName(name: String): Boolean

    @Query(
        """
            SELECT 
                b.id AS brand_id,
                SUM(p.price) AS total_price
            FROM 
                Brand b 
            JOIN b.products p 
            GROUP BY 
                b.id 
            ORDER BY 
                total_price ASC
        """
    )
    fun findBrandWitTotalPrice(): List<Map<String, Any>>
}
