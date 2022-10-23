package prac.basic.beanfind;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import prac.basic.discount.DiscountPolicy;
import prac.basic.discount.FixDiscountPolicy;
import prac.basic.discount.RateDiscountPolicy;

import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextExtendsFindTest {
    // 등록된 빈을 부모타입으로 조회 시 자식 타입의 빈도 함께 조회된다.

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

    @Test
    @DisplayName("부모 타입으로 조회 시 자식이 둘 이상이면 중복 오류가 발생한다.")
    void findBeanByParentDuplicate() {
        assertThrows(NoUniqueBeanDefinitionException.class, () -> ac.getBean(DiscountPolicy.class));
    }

    @Test
    @DisplayName("부모 타입으로 조회 시 이름을 지정해 조회한다.")
    void findBeanByChildName() {
        DiscountPolicy fixDiscountPolicy = ac.getBean("fixDiscountPolicy", DiscountPolicy.class);
        assertThat(fixDiscountPolicy).isInstanceOf(DiscountPolicy.class);
    }

    @Test
    @DisplayName("서브타입으로 조회한다.")
    void findBeanBySubType() {
        DiscountPolicy fixDiscountPolicy = ac.getBean(FixDiscountPolicy.class);
        assertThat(fixDiscountPolicy).isInstanceOf(FixDiscountPolicy.class);
    }

    @Test
    @DisplayName("부모타입으로 모두 조회한다.")
    void findAllBeanByType() {
        Map<String, DiscountPolicy> beansOfType = ac.getBeansOfType(DiscountPolicy.class);
        assertThat(beansOfType.size()).isEqualTo(2);
    }

    @Configuration
    static class TestConfig {
        @Bean
        DiscountPolicy rateDiscountPolicy() {
            return new RateDiscountPolicy();
        }

        @Bean
        DiscountPolicy fixDiscountPolicy() {
            return new FixDiscountPolicy();
        }
    }
}
