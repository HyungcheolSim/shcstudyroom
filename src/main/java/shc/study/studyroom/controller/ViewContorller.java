package shc.study.studyroom.controller;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import shc.study.studyroom.dto.SignUpDTO;
import shc.study.studyroom.service.UserService;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/")
public class ViewContorller {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final UserService userService;

    @PostMapping(value = "/signup")
    public String signUp(SignUpDTO signUpDTO) {
        logger.info(signUpDTO + "맞나?");
        userService.signUp(signUpDTO);
        return "redirect:/loginV";
    }

    @GetMapping("/loginV")
    public String login(){
        logger.info("로그인View 로그인 실행");
        return "content/login";
    }

    @GetMapping("/")
    public String home(){
        logger.info("홈화면으로");
        return "content/home";
        
    }
    
    @GetMapping("/signup")
    public String SignUp(){
        return "content/signup";
        
    }
    @GetMapping("/member/info")
    public String userInfoView(){
        return "content/user_info";
    }

    @GetMapping("/admin")
    public String adminView() {
        return "content/admin";
    }

    @GetMapping("/denied")
    public String deniedView() {
        return "content/denied";
    }
}
