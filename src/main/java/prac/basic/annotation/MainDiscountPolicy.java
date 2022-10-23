package prac.basic.annotation;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@Qualifier("mainDiscountPolicy")
// Qualifier의 문자열은 컴파일 타임에 체크가 되지 않기 때문에 어노테이션으로 만들어 사용하는 것이 좋다.
public @interface MainDiscountPolicy {
}
