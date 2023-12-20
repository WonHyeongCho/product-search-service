package my.assignment.productsearchservice.controller

import my.assignment.productsearchservice.dto.CategoryPriceRangesDto
import my.assignment.productsearchservice.dto.CategoryWiseMinPriceDto
import my.assignment.productsearchservice.service.CategoryService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/categories")
class CategoryController(
    private val categoryService: CategoryService,
) {

    @GetMapping("/lowest-price-brands")
    fun getCategoryWiseMinimumPricesAndTotal(): ResponseEntity<CategoryWiseMinPriceDto> {
        val categoryWiseMinPriceItems = categoryService.getCategoryWiseMinPrice()
        return ResponseEntity.ok(CategoryWiseMinPriceDto((categoryWiseMinPriceItems)))
    }

    @GetMapping("/{categoryName}/price-ranges")
    fun getCategoryPriceRanges(@PathVariable categoryName: String): ResponseEntity<CategoryPriceRangesDto> {
        return ResponseEntity.ok(categoryService.getCategoryPriceRange(categoryName))
    }
}
