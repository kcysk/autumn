package com.autumn.boot;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author shenke
 * @since 2022/11/6 16:17
 */
@Configuration
@ConditionalOnClass(AutumnBootstrap.class)
@ConditionalOnMissingBean(AutumnBootstrap.class)
@Import(AutumnBootstrap.class)
public class AutumnAutoConfiguration {


}
