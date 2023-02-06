package shc.study.studyroom.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import shc.study.studyroom.dao.UserMapper;
import shc.study.studyroom.util.UserNotFoundException;

import java.util.Collections;

@RequiredArgsConstructor

public class UserDetailServiceImpl implements UserDetailsService {
    private final UserMapper userMapper;
//not using now
    @Override
    public UserDetails loadUserByUsername(String username){
        return userMapper.selectUserById(username).map(u -> new MyUserDetails(u, Collections.singleton(new SimpleGrantedAuthority(u.getUserRole().toString())))).orElseThrow(() -> new UserNotFoundException(username));
    }
}
