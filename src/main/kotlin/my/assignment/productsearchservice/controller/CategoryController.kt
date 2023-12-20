package my.assignment.productsearchservice.controller

import my.assignment.productsearchservice.dto.CategoryWiseMinPriceDto
import my.assignment.productsearchservice.service.CategoryService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/categories")
class CategoryController(
    private val categoryService: CategoryService,
) {

    @GetMapping("/wise/minimum-prices")
    fun getCategoryWiseMinimumPricesAndTotal(): ResponseEntity<CategoryWiseMinPriceDto> {
        val categoryWiseMinPriceItems = categoryService.getCategoryWiseMinPrice()
        return ResponseEntity.ok(CategoryWiseMinPriceDto((categoryWiseMinPriceItems)))
    }
}
