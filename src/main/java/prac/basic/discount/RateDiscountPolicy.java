package prac.basic.discount;

import org.springframework.stereotype.Component;
import prac.basic.annotation.MainDiscountPolicy;
import prac.basic.member.Grade;
import prac.basic.member.Member;

@Component
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy {
    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        } else {
            return 0;
        }
    }
}
