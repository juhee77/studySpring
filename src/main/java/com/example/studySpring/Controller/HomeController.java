package com.example.studySpring.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/") //기본 호출 //이게 없으면 static의 index가 호출된다
    public String home() {
        return "home";
    }
}
