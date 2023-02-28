package shc.study.studyroom.controller;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import shc.study.studyroom.dto.User;
import shc.study.studyroom.service.UserService;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/")
public class ViewContorller {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final UserService userService;


    @GetMapping("/login")
    public String login() {
        logger.info("로그인View 로그인 실행");
        return "content/login";
    }

    @GetMapping("/")
    public String home() {
        logger.info("홈화면으로");
        return "content/index";
    }

    @GetMapping("/signup")
    public String SignUp() {
        return "content/signup";
    }

    @PostMapping(value = "/signup")
    public String signUp(User user) {
        logger.info(user + "맞나?");
        userService.signUp(user);
        return "redirect:/login";
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/member/info")
    public String userInfoView() {
        return "content/user_info";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    public String adminView() {
        return "content/admin";
    }

    @GetMapping("/denied")
    public String deniedView() {
        return "content/denied";
    }
}
