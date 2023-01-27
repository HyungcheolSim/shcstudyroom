package shc.study.studyroom.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import shc.study.studyroom.dto.User;

import java.util.LinkedHashMap;
import java.util.List;

@Repository
@Mapper
public interface UserMapper {
    //select
    List<LinkedHashMap<Object, Object>> showAllUser();

    //select one
    User selectUserByIdx(int userIdx);

    //insert
    void insertUser(User user);

    //update
    void updateUser(User user);

    //delete
    void deleteUser(int userIdx);

    //select one by userid for login
    User selectUserById(String userId);


}
