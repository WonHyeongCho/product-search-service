package my.assignment.productsearchservice.exception

import jakarta.validation.ValidationException
import my.assignment.productsearchservice.constant.logger
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.servlet.resource.NoResourceFoundException

@RestControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(Exception::class)
    fun handleException(e: Exception): ResponseEntity<ErrorResponse> {
        logger().error("Exception occurred", e)
        val errorResponse = ErrorResponse(ErrorEnum.UNDEFINED)
        return ResponseEntity.status(ErrorEnum.UNDEFINED.httpStatus).body(errorResponse)
    }

    @ExceptionHandler(NoResourceFoundException::class)
    fun handleNoResourceFoundException(e: NoResourceFoundException): ResponseEntity<ErrorResponse> {
        logger().error("NoResourceFoundException occurred", e)
        return ResponseEntity.notFound().build()
    }

    @ExceptionHandler(ValidationException::class, MethodArgumentNotValidException::class)
    fun handleValidationException(e: ValidationException): ResponseEntity<ErrorResponse> {
        logger().error("ValidationException occurred", e)
        val errorResponse = ErrorResponse(ErrorEnum.BAD_REQUEST)
        return ResponseEntity.status(ErrorEnum.BAD_REQUEST.httpStatus).body(errorResponse)
    }

    @ExceptionHandler(ProductSearchServiceException::class)
    fun handleProductSearchServiceException(e: ProductSearchServiceException): ResponseEntity<ErrorResponse> {
        logger().error("ProductSearchServiceException occurred", e)
        val errorResponse = ErrorResponse(e.errorEnum)
        return ResponseEntity.status(e.errorEnum.httpStatus).body(errorResponse)
    }
}
