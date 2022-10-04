package com.autumn.core.annotations;

import org.springframework.stereotype.Component;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * extension
 *
 * @author momo
 * @since 2022/9/19 23:08
 */
@Component
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface Extension {

    /**
     * suitable coordinate array
     */
    Grid[] coordinates() default {};

}
