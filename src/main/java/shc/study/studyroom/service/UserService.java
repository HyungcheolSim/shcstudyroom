package shc.study.studyroom.service;

import shc.study.studyroom.dto.User;

import java.util.LinkedHashMap;
import java.util.List;

public interface UserService {
    List<LinkedHashMap<Object, Object>> selectAllUser();

    User selectOneUser(int userIdx);

    User loginOneUser(String userId);

    User addUser(User user);
    User modUser(User user);
    User delUser(int userIdx);

}
