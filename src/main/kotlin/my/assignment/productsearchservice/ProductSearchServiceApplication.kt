package my.assignment.productsearchservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ProductSearchServiceApplication

fun main(args: Array<String>) {
    runApplication<ProductSearchServiceApplication>(*args)
}
