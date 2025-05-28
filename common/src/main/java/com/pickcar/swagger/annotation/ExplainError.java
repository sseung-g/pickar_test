package com.pickcar.swagger.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.stereotype.Component;

@Target({ElementType.FIELD})        //어노테이션의 대상을 "필드" 로 지정 (상수, 클래스에 X)
@Retention(RetentionPolicy.RUNTIME)     //실행 중(런타임) 에도 유지됨
@Documented                         // Java Doc에 표시됨
@Component
public @interface ExplainError {
    String value() default "";
}
