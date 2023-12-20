package my.assignment.productsearchservice.controller

import my.assignment.productsearchservice.dto.ProductDto
import my.assignment.productsearchservice.dto.request.ProductRequestDto
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
    fun getProductList(): ResponseEntity<List<ProductDto>> {
        return ResponseEntity.ok(
            productService.getProductList().map { ProductDto.fromProduct(it) })
    }

    @GetMapping("/{id}")
    fun getProduct(@PathVariable id: Long): ResponseEntity<ProductDto> {
        return ResponseEntity.ok(ProductDto.fromProduct(productService.getProduct(id)))
    }

    @PostMapping
    fun createProduct(@RequestBody productRequestDto: ProductRequestDto): ResponseEntity<ProductDto> {
        return ResponseEntity.ok(
            ProductDto.fromProduct(
                productService.createProduct(productRequestDto)
            )
        )
    }

    @PutMapping("/{id}")
    fun updateProduct(
        @PathVariable id: Long,
        @RequestBody productRequestDto: ProductRequestDto
    ): ResponseEntity<ProductDto> {
        return ResponseEntity.ok(
            ProductDto.fromProduct(
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
