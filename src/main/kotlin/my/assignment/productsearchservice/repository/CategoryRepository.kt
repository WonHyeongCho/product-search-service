package my.assignment.productsearchservice.repository

import my.assignment.productsearchservice.entity.Category
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface CategoryRepository : JpaRepository<Category, Long> {

    @Query(
        """
            SELECT 
                c,
                p
            FROM Category c
            JOIN FETCH c.products p
            WHERE 
                p.price = (SELECT MIN(p2.price) FROM Product p2 WHERE p2.category.id = c.id)
        """
    )
    fun findCategoryWiseMinimumPrice(): List<Category>
}
