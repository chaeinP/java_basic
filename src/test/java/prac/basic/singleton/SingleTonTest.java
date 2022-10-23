package prac.basic.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import prac.basic.AppConfig;
import prac.basic.member.MemberService;

public class SingleTonTest {
    @Test
    void pureContainer() {
        AppConfig appConfig = new AppConfig();
        MemberService memberService1 = appConfig.memberService();
        MemberService memberService2 = appConfig.memberService();

        // 호출할 때마다 주소값이 달라짐
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        Assertions.assertThat(memberService1).isNotSameAs(memberService2);
    }

    @Test
    @DisplayName("싱글톤 패턴을 사용한 객체 생성")
    void singleToneServiceTest() {
        SingleTonService singleTonService1 = SingleTonService.getInstance();
        SingleTonService singleTonService2 = SingleTonService.getInstance();
        Assertions.assertThat(singleTonService1).isSameAs(singleTonService2);
    }

    @Test
    @DisplayName("스프링 컨테이너 싱글톤 확인")
    void springContainerSingleTon() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService1 = ac.getBean("memberService", MemberService.class);
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);
        Assertions.assertThat(memberService1).isSameAs(memberService2);
    }
}
