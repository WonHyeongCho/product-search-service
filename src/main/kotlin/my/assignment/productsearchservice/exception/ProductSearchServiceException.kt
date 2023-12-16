package my.assignment.productsearchservice.exception

import java.lang.RuntimeException

class ProductSearchServiceException : RuntimeException {

    var errorEnum: ErrorEnum = ErrorEnum.UNDEFINED

    constructor(message: String) : super(message)

    constructor(message: String, cause: Throwable) : super(message, cause)

    constructor(errorEnum: ErrorEnum) : super(errorEnum.errorMessage) {
        this.errorEnum = errorEnum
    }

    constructor(errorEnum: ErrorEnum, cause: Throwable) : super(errorEnum.errorMessage, cause) {
        this.errorEnum = errorEnum
    }
}