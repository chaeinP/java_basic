package prac.basic;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import prac.basic.member.Grade;
import prac.basic.member.Member;
import prac.basic.member.MemberService;
import prac.basic.member.MemberServiceImpl;
import prac.basic.order.Order;
import prac.basic.order.OrderService;
import prac.basic.order.OrderServiceImpl;

public class OrderServiceTest {

    AppConfig appConfig = new AppConfig();
    MemberService memberService = appConfig.memberService();
    OrderService orderService = appConfig.orderService();

    @Test
    void createOrder(){
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);
        Order order = orderService.createOrder(member.getId(), "itemA", 10000);

        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
