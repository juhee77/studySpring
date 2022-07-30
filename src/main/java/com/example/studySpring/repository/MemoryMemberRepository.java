package com.example.studySpring.repository;

import com.example.studySpring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;


//스프링에서 처리하는 정형화된 패텅 (스프링이 알아서 잡아줌)
@Repository
public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(),member);
        return member;
    }

    @Override
    public Optional<Member> findbyId(Long Id) {
        return  Optional.ofNullable(store.get(Id));
    }

    @Override
    public Optional<Member> findbyName(String Name) {
        return store.values().stream().filter(member -> member.getName().equals(Name))
                .findAny(); //map에서 돌려서 반환 된다.
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }


    public void clearStore(){
        store.clear();
    }
}
