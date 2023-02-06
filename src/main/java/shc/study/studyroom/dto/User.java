package shc.study.studyroom.dto;

import lombok.*;
import shc.study.studyroom.enums.Expired;
import shc.study.studyroom.enums.Role;

@Getter
@Setter

@AllArgsConstructor
public class User {
    private int userIdx;
    private String userName;
    private String userId;
    private String userPwd;
    private String userPhone;
    private Role userRole;
    private Expired userExpired;

    @Builder
    public User(String userName, String userId, String userPwd, String userPhone, Role userRole) {
        this.userName = userName;
        this.userId = userId;
        this.userPwd = userPwd;
        this.userPhone = userPhone;
        this.userRole = userRole;
    }

}
