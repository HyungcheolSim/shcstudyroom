package shc.study.studyroom.util;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum StatusCode implements ErrorCode{
    INVALID_PARAMETER(HttpStatus.BAD_REQUEST,"Invalid parameter included"),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR,"Internal Server Error"),
    REQUEST_TIMEOUT(HttpStatus.REQUEST_TIMEOUT,"Request Timeout"),
    SERVICE_UNAVAILABLE(HttpStatus.SERVICE_UNAVAILABLE,"Service Unavailable"),
    METHOD_NOT_ALLOWED(HttpStatus.METHOD_NOT_ALLOWED,"Method is not allowed, Check Methods"),
    OK(HttpStatus.OK,"OK"),
    ;

    private final HttpStatus httpStatus;
    private final String message;
}
