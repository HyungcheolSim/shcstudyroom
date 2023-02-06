package shc.study.studyroom.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import shc.study.studyroom.dto.SignUpDTO;
import shc.study.studyroom.dto.User;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;

public interface UserService extends UserDetailsService {
    List<LinkedHashMap<Object, Object>> selectAllUser();
    List<User> getAllUser();

    User selectOneUser(int userIdx);

    Optional<User> loginOneUser(String userId);

    User addUser(User user);

    //회원가입
    User signUp(SignUpDTO signUpDTO);

    User modUser(User user);
    User delUser(int userIdx);

}
