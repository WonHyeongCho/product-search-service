package my.assignment.productsearchservice.exception

import jakarta.validation.ValidationException
import my.assignment.productsearchservice.constant.logger
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(Exception::class)
    fun handleException(e: Exception): ResponseEntity<ErrorResponse> {
        logger().error("Exception occurred", e)
        val errorResponse = ErrorResponse(ErrorEnum.UNDEFINED)
        return ResponseEntity.status(ErrorEnum.UNDEFINED.httpStatus).body(errorResponse)
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