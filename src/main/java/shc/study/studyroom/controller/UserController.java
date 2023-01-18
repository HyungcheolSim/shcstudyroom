package shc.study.studyroom.controller;

import lombok.RequiredArgsConstructor;

import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shc.study.studyroom.dto.User;
import shc.study.studyroom.service.UserService;

import java.util.LinkedHashMap;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final UserService userService;

    @GetMapping("/hello")
    public String test() {

        throw new IllegalArgumentException("hello");
        
    }

    @GetMapping

    public ResponseEntity<List<LinkedHashMap<Object, Object>>> findAll() {
    /*
        public ResponseEntity<CommonStatusCode> findAll() {
        HttpHeaders header =new HttpHeaders();
        header.setContentType(new MediaType("application","json", Charset.forName("UTF-8")));
        header.set("studyroomManager",userService.selectOneUser(2).getUserName());
        return ResponseEntity.ok(data);
    */
        return ResponseEntity.ok().body(userService.selectAllUser());

    }

    @GetMapping("/{userIdx}")
    public ResponseEntity<User> getUserId(@PathVariable int userIdx) {
        return ResponseEntity.ok().body(userService.selectOneUser(userIdx));
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
