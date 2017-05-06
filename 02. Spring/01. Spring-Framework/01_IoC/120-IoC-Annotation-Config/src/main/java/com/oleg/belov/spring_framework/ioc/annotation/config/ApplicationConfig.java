package com.oleg.belov.spring_framework.ioc.annotation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.oleg.belov.spring_framework.ioc.annotation.beans.SimpleBean2;
import com.oleg.belov.spring_framework.ioc.annotation.beans.SimpleImpl;
import com.oleg.belov.spring_framework.ioc.annotation.beans.SimpleInterface;

@Configuration
@Import(CoreConfig.class)
public class ApplicationConfig {

    @Bean
    public SimpleBean2 getSimpleBean2() {
        return new SimpleBean2();
    }

    @Bean
    public SimpleInterface getSimpleInterface() {
        return new SimpleImpl();
    }


}
