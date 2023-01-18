package shc.study.studyroom.util;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class RestApiException extends RuntimeException{
    //언체크 예외(런타임 예외)를 상속받은 이유: 일반 비즈니스 로직들은 catch해서 처리하지 않지만
    private final ErrorCode errorCode;
}
