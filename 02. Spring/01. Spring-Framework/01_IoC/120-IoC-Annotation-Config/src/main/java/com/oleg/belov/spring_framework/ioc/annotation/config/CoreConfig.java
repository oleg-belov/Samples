package com.oleg.belov.spring_framework.ioc.annotation.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.oleg.belov.spring_framework.ioc.annotation.beans.SimpleBean1;

@Configuration
@ImportResource("springContext.xml")
public class CoreConfig {

    private
    @Value("${jdbc.url}")
    String url;
    private
    @Value("${jdbc.username}")
    String username;
    private
    @Value("${jdbc.password}")
    String password;

    public
    @Bean(name = "datasourse")
    DataSource dataSource() {
        return new DriverManagerDataSource(url, username, password);
    }

    @Bean
    public SimpleBean1 getSimpleBean1() {
        return new SimpleBean1();
    }


}
