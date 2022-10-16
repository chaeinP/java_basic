package prac.basic;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import prac.basic.member.Grade;
import prac.basic.member.Member;
import prac.basic.member.MemberService;
import prac.basic.member.MemberServiceImpl;

public class MemberServiceTest {
    MemberService memberService;
    @BeforeEach
    public void beforeEach(){
        memberService = new AppConfig().memberService();
    }

    @Test
    void join(){
        Member member= new Member(1L, "memberA", Grade.VIP);

        memberService.join(member);
        Member findMember = memberService.findMember(member.getId());

        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
