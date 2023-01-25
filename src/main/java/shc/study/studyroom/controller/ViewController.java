package shc.study.studyroom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class ViewController {

    @RequestMapping("/home")
    public String responseView(Model model){
        model.addAttribute("data","hello");

        return "content/home";
    }
}
