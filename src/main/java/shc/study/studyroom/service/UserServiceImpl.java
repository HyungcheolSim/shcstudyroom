package shc.study.studyroom.service;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import shc.study.studyroom.dao.UserMapper;
import shc.study.studyroom.dto.User;

import java.util.LinkedHashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final Logger logger= LoggerFactory.getLogger(this.getClass());
    private final UserMapper userMapper;

    @Override
    public List<LinkedHashMap<Object, Object>> selectAllUser() {
        logger.info("List<LinkedHashMap<Object, Object>> selectAllUser()");
        return userMapper.showAllUser();
    }

    @Override
    public User selectOneUser(int userIdx) {
        logger.info("User selectOneUser(int userIdx)"+ userIdx);
        return userMapper.selectUserByIdx(userIdx);
    }

    @Override
    public User loginOneUser(String userId) {
        logger.info("User loginOneUser(String userId)"+ userId);
        return userMapper.selectUserById(userId);
    }

    @Override
    public User addUser(User user) {
        logger.info("User addUser(User user)"+ user);
        userMapper.insertUser(user);
        return userMapper.selectUserByIdx(user.getUserIdx());
    }

    @Override
    public User modUser(User user) {
        logger.info("User modUser(User user)"+ user);
        userMapper.updateUser(user);
        return user;
    }

    @Override
    public User delUser(int userIdx) {
        logger.info("User delUser(int userIdx)"+ userIdx);
        userMapper.deleteUser(userIdx);
        return userMapper.selectUserByIdx(userIdx);
    }
}
