package my.assignment.productsearchservice.controller

import my.assignment.productsearchservice.dto.ProductRequestDto
import my.assignment.productsearchservice.dto.ProductResponseDto
import my.assignment.productsearchservice.service.ProductService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/products")
class ProductController(
    private val productService: ProductService
) {

    @GetMapping
    fun getProductList(): ResponseEntity<List<ProductResponseDto>> {
        return ResponseEntity.ok(
            productService.getProductList().map { ProductResponseDto.fromProduct(it) })
    }

    @GetMapping("/{id}")
    fun getProduct(@PathVariable id: Long): ResponseEntity<ProductResponseDto> {
        return ResponseEntity.ok(ProductResponseDto.fromProduct(productService.getProduct(id)))
    }

    @PostMapping
    fun createProduct(@RequestBody productRequestDto: ProductRequestDto): ResponseEntity<ProductResponseDto> {
        return ResponseEntity.ok(
            ProductResponseDto.fromProduct(
                productService.createProduct(productRequestDto)
            )
        )
    }

    @PutMapping("/{id}")
    fun updateProduct(
        @PathVariable id: Long,
        @RequestBody productRequestDto: ProductRequestDto
    ): ResponseEntity<ProductResponseDto> {
        return ResponseEntity.ok(
            ProductResponseDto.fromProduct(
                productService.updateProduct(id, productRequestDto)
            )
        )
    }

    @DeleteMapping("/{id}")
    fun deleteProduct(@PathVariable id: Long): ResponseEntity<Void> {
        productService.deleteProduct(id)
        return ResponseEntity.ok().build()
    }
}
