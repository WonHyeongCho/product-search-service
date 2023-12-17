package my.assignment.productsearchservice.exception

import org.springframework.http.HttpStatus

enum class ErrorEnum(val errorCode: String, val errorMessage: String, val httpStatus: HttpStatus) {
    
    BAD_REQUEST("000", "잘못된 요청입니다.", HttpStatus.BAD_REQUEST),
    RESOURCE_NOT_FOUND("001", "요청하신 데이터를 찾을 수 없습니다.", HttpStatus.NOT_FOUND),
    RESOURCE_ALREADY_EXISTS("002", "이미 존재하는 데이터입니다.", HttpStatus.BAD_REQUEST),
    UNDEFINED("999", "알 수 없는 오류가 발생했습니다.", HttpStatus.INTERNAL_SERVER_ERROR),
}
