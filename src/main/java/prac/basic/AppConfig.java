package prac.basic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import prac.basic.discount.DiscountPolicy;
import prac.basic.discount.RateDiscountPolicy;
import prac.basic.member.MemberRepository;
import prac.basic.member.MemberService;
import prac.basic.member.MemberServiceImpl;
import prac.basic.member.MemoryMemberRepository;
import prac.basic.order.OrderService;
import prac.basic.order.OrderServiceImpl;

// @Configuration은 등록된 Bean들이 싱글톤 패턴으로 등록될 수 있도록 관리한다.
@Configuration
public class AppConfig {
    @Bean
    public MemberService memberService() {

        return new MemberServiceImpl(MemberRepository());
    }

    @Bean
    public MemberRepository MemberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(MemberRepository(), DiscountPolicy());
    }

    @Bean
    public static DiscountPolicy DiscountPolicy() {
        return new RateDiscountPolicy();
    }
}
