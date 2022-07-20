package com.example.studySpring.repository;

import com.example.studySpring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        //테스트는 의존 관계없이 설계되어야 한다.
        //순서가 보장이 안되는데 이전정보롤 인한 에러발생 가능성이 있음 이를 해결하기 위해 각코드가 끝난후 모든 메모리 삭제 기능 추가
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);
        Member result = repository.findbyId(member.getId()).get();

        //Assertions.assertEquals(result,null);
        //Assertions.assertEquals(result,member);
        assertThat(member).isEqualTo(result);

    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);


        //shit+f6 (이름 자동으로 바뀌게 할 수 있음)
        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);


        Member result = repository.findbyName("spring1").get();
        assertThat(result).isEqualTo(member1);

    }


    @Test
    public void findAll() {
        //given
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);
        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);



        //when
        List<Member> result = repository.findAll();
        //then
        assertThat(result.size()).isEqualTo(2);
    }
}
