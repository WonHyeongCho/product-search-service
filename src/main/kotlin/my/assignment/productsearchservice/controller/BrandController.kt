package my.assignment.productsearchservice.controller

import my.assignment.productsearchservice.dto.BrandRequestDto
import my.assignment.productsearchservice.dto.BrandResponseDto
import my.assignment.productsearchservice.service.BrandService
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
@RequestMapping("/brands")
class BrandController(
    private val brandService: BrandService
) {

    @GetMapping
    fun getBrandList(): ResponseEntity<List<BrandResponseDto>> {
        return ResponseEntity.ok(brandService.getBrandList().map { it.toBrandResponseDto() })
    }

    @GetMapping("/{id}")
    fun getBrand(@PathVariable id: Long): ResponseEntity<BrandResponseDto> {
        return ResponseEntity.ok(brandService.getBrand(id).toBrandResponseDto())
    }

    @PostMapping
    fun createBrand(@RequestBody brandRequestDto: BrandRequestDto): ResponseEntity<BrandResponseDto> {
        return ResponseEntity.ok(
            brandService.createBrand(brandRequestDto).toBrandResponseDto()
        )
    }

    @PutMapping("/{id}")
    fun updateBrand(
        @PathVariable id: Long,
        @RequestBody brandRequestDto: BrandRequestDto
    ): ResponseEntity<BrandResponseDto> {
        return ResponseEntity.ok(
            brandService.updateBrand(id, brandRequestDto).toBrandResponseDto()
        )
    }

    @DeleteMapping("/{id}")
    fun deleteBrand(@PathVariable id: Long): ResponseEntity<Void> {
        brandService.deleteBrand(id)
        return ResponseEntity.ok().build()
    }
}
