package shc.study.studyroom.controller;

import lombok.RequiredArgsConstructor;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import shc.study.studyroom.dto.User;
import shc.study.studyroom.dto.UserListResponseDTO;
import shc.study.studyroom.service.UserService;



import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/user")
//@CrossOrigin
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final UserService userService;

    //회원가입


    //전체 목록 조회
    @GetMapping(value = "/list")
    public ResponseEntity<UserListResponseDTO> getAll() {
        final UserListResponseDTO userListResponseDTO = UserListResponseDTO.builder()
                .userList(userService.getAllUser()).build();

        return ResponseEntity.ok(userListResponseDTO);
    }

    @GetMapping
    public ResponseEntity<List<LinkedHashMap<Object, Object>>> findAll() {
        logger.debug("ResponseEntity<List<LinkedHashMap<Object, Object>>> findAll() 호출");
        return ResponseEntity.ok().body(userService.selectAllUser());

    }

    @GetMapping("/{userIdx}")
    public ResponseEntity<User> getUserIdx(@PathVariable int userIdx) {
        return ResponseEntity.ok().body(userService.selectOneUser(userIdx));
    }

    @GetMapping("/login/{userId}")
    public ResponseEntity<User> getUserId(@PathVariable String userId) {
        Optional<User> user = userService.loginOneUser(userId);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.noContent().build());
    }

    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User user) {
        return ResponseEntity.ok().body(userService.addUser(user));
    }

    @PutMapping
    public ResponseEntity<User> update(@RequestBody User user) {
        return ResponseEntity.ok().body(userService.modUser(user));
    }

    @PatchMapping("/{userIdx}")
    public ResponseEntity<User> delete(@PathVariable int userIdx) {
        return ResponseEntity.ok().body(userService.delUser(userIdx));
    }
}
