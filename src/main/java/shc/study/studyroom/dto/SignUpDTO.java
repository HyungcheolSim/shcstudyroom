package shc.study.studyroom.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import shc.study.studyroom.enums.Role;

@Getter
public class SignUpDTO {
    private String userId;
    private String userPwd;
    private String userName;
    private String userPhone;
    private Role userRole;

}
