package my.assignment.productsearchservice.repository

import my.assignment.productsearchservice.entity.Category
import org.springframework.data.jpa.repository.JpaRepository

interface CategoryRepository : JpaRepository<Category, Long> {
}
