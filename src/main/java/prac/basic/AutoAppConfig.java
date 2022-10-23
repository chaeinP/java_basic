package prac.basic;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        // basePackages = "prac.basic.member" 해당하는 패키지 패스 아래에 있는 클래스만 빈으로 등록
        // basePackageClasses = AutoAppConfig.class 해당 클래스가 위치한 패키지에 속한 클래스만 빈으로 등록
        // default는 ComponentScan이 붙은 설정 파일의 클래스 패키지가 시작 위치가 된다.
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {
}
