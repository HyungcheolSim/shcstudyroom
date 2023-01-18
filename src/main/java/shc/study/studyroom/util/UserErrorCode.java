package shc.study.studyroom.util;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;


@Getter
@RequiredArgsConstructor
//spring security 적용 후 사용예정
public enum UserErrorCode implements ErrorCode{
    INACTIVE_USER(HttpStatus.FORBIDDEN,"User is inactive");
    private final HttpStatus httpStatus;
    private final String message;
}
