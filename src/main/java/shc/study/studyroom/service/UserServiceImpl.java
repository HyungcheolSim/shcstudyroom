package shc.study.studyroom.service;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import shc.study.studyroom.dao.UserMapper;
import shc.study.studyroom.dto.User;
import shc.study.studyroom.enums.Role;

import java.util.*;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final UserMapper userMapper;

    @Override
    public List<LinkedHashMap<Object, Object>> selectAllUser() {
        logger.info("List<LinkedHashMap<Object, Object>> selectAllUser()");
        return userMapper.showAllUser();
    }

    @Override
    public List<User> getAllUser() {
        logger.info("public List<User> getAllUser()");
        return userMapper.getAllUser();
    }

    @Override
    public User selectOneUser(int userIdx) {
        logger.info("User selectOneUser(int userIdx)" + userIdx);
        return userMapper.selectUserByIdx(userIdx);
    }

    @Override
    public Optional<User> loginOneUser(String userId) {
        logger.info("User loginOneUser(String userId)" + userId);

        return userMapper.selectUserById(userId);
    }

    @Override
    public User addUser(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setUserPwd(passwordEncoder.encode(user.getUserPwd()));
        logger.info("User addUser(User user)" + user);
        userMapper.insertUser(user);
        return userMapper.selectUserByIdx(user.getUserIdx());
    }

    //회원가입
    @Override
    //public User signUp(SignUpDTO signUpDTO) {
    public User signUp(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
/*        User user = User.builder()
                .userId(signUpDTO.getUserId())
                .userName(signUpDTO.getUserName())
                .userPwd(passwordEncoder.encode(signUpDTO.getUserPwd()))

                .userPhone(signUpDTO.getUserPhone())
                .userRole(Role.USER)
                .build();*/
        String encodePwd= passwordEncoder.encode(user.getUserPwd());
        user.setUserPwd(encodePwd);
        user.setUserRole(Role.USER);

        logger.info("User signup(User user)" + user.getUserId());
        logger.info("User signup(User user)" + user.getUserRole());
        logger.info("User signup(User user)" + user.getUserPwd());
        logger.info("User signup(User user)" + encodePwd);
        userMapper.insertUser(user);
        return userMapper.selectUserByIdx(user.getUserIdx());
    }

    @Override
    public User modUser(User user) {
        logger.info("User modUser(User user)" + user);
        userMapper.updateUser(user);
        return user;
    }

    @Override
    public User delUser(int userIdx) {
        logger.info("User delUser(int userIdx)" + userIdx);
        userMapper.deleteUser(userIdx);
        return userMapper.selectUserByIdx(userIdx);
    }

    @Override
    public UserDetails loadUserByUsername(String userId) {
        //return userMapper.selectUserById(username).map(u -> new MyUserDetails(u, Collections.singleton(new SimpleGrantedAuthority(u.getUserRole().toString())))).orElseThrow(() -> new UserNotFoundException(username));
        Optional<User> optionalUser = userMapper.selectUserById(userId);
        User user = optionalUser.orElse(null);
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(Role.USER.toString()));

        assert user != null;
        return new org.springframework.security.core.userdetails.User(user.getUserId(), user.getUserPwd(), authorities);
    }
}
