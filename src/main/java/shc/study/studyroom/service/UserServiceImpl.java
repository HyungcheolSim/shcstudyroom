package shc.study.studyroom.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shc.study.studyroom.dao.UserMapper;
import shc.study.studyroom.dto.User;

import java.util.LinkedHashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    @Override
    public List<LinkedHashMap<Object, Object>> selectAllUser() {
        return userMapper.showAllUser();
    }

    @Override
    public User selectOneUser(int userIdx) {
        return userMapper.selectUserByIdx(userIdx);
    }

    @Override
    public User addUser(User user) {
        userMapper.insertUser(user);
        return userMapper.selectUserByIdx(user.getUserIdx());
    }

    @Override
    public User modUser(User user) {
        userMapper.updateUser(user);
        return user;
    }

    @Override
    public User delUser(int userIdx) {

        userMapper.deleteUser(userIdx);
        return userMapper.selectUserByIdx(userIdx);
    }
}
