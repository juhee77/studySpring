package com.example.studySpring.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","hello!!");
        return "hello";
    }
}
//string boot devtools이용시 html만 컴파일 하고 사용할 수 있는 기능도 있다.
//터미널에서 스프링 서버 죽일때 command+c

//https://velog.io/@seona-jung/%ED%84%B0%EB%AF%B8%EB%84%90-%EA%BE%B8%EB%AF%B8%EA%B8%B0-oh-my-zsh
//터미널 꾸미기
