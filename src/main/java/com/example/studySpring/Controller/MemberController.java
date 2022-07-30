package com.example.studySpring.Controller;


import com.example.studySpring.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    private final MemberService memberService;

    // 자동 연결 시켜준다. (스프링 컨데이너 에서 가져옴)//스프링이 memberService를 알 방법이 없다.
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

}
