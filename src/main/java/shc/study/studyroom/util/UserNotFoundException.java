package shc.study.studyroom.util;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String userId){
        super(userId+" NotFoundException");
    }
}
