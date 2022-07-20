package Service;

import com.example.studySpring.domain.Member;
import com.example.studySpring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;
    //여기서 new 로 선언하면 다른 인스턴스 이므로 그냥 두고 외분에서 넣어주게 바꿔주기


    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    public void 회원가입() throws Exception {


        //Given
        Member member = new Member();
        member.setName("hello");

        //When
        Long saveId = memberService.join(member);

        //Then
        Member findMember = memberRepository.findbyId(saveId).get();
        //assertThat(member.getName()).isEqualTo(findMember.getName());
        assertEquals(member.getName(), findMember.getName());
        //option  + enter static import 로 변경 가능
    }

    @Test
    public void 중복_회원_예외() throws Exception {
        //Given
        Member member1 = new Member();
        member1.setName("spring");
        Member member2 = new Member();
        member2.setName("spring");

        //When
        // try catch로도 예외를 잡을수 있으나 throws excetption으로도 가능
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class,
                () -> memberService.join(member2));//예외가 발생해야 한다.


        /* option + command + / 블록 주석 처리
        memberService.join(member1);
        try {
            memberService.join(member2);
            fail();
        }catch (IllegalStateException ep){
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다. ");
        }
        */
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }
}
