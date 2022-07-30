package com.example.studySpring.Service;

import com.example.studySpring.domain.Member;
import com.example.studySpring.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//command + shift +t 자동으로 테스트 케이스 생성
// 스프링이 알아차리게 해준다.

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    //스프링 컨베이너 에 있는거 자동 주입
    @Autowired
    public MemberService(MemberRepository memberRepository) { //외부에서 넣어주게 변경 하도록(DI)
        this.memberRepository = memberRepository;
    }

    /**
     * 회원가입
     */
    public Long join(Member member) {
        //같은 이름이 있는 중복회원 가입 불가능
        //command + option + v return 자동 해줌
        //control + t 메소드로 쉽게 변환 가능

        /*
        Optional<Member> result = memberRepository.findbyName(member.getName());
        result.ifPresent( m -> {
            throw new IllegalArgumentException("이미 존재하는 회원 입니다.");
        });
        */

        //optional 사용시 null 을 감싸서 보내준다.

        validateDuplicateMember(member); //중복 회원 검증 memberRepository.save(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findbyName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findbyId(memberId);
    }
}
