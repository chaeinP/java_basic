package prac.basic.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class StatefulServiceTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(Temp.class);

    @Test
    void statefulTest() {
        StatefulService statefulService = ac.getBean(StatefulService.class);
        statefulService.order("userA", 10000);
        statefulService.order("userA", 20000);

        Assertions.assertThat(statefulService.getPrice()).isEqualTo(20000);
    }

    @Configuration
    static class Temp {
        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }
}
