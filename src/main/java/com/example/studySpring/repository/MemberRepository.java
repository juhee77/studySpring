package com.example.studySpring.repository;

import com.example.studySpring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findbyId(Long Id); //null처리를 하는 방법 null을 감싸서 리턴하는 방법을 선호
    Optional<Member> findbyName(String Name);
    List<Member> findAll(); //저장된 모든것 반화


}
