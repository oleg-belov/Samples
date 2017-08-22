package com.oleg.belov.spring.data.jpa.config;


import java.util.Properties;

import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = {"com.oleg.belov.spring.data.jpa.repository"})
@EnableTransactionManagement
@ComponentScan(basePackages = {"com.oleg.belov.spring.data.jpa"})
@PropertySource("classpath:application.properties")
public class DataConfiguration {
	@Resource
	private Environment env;

	@Bean
	public DataSource dataSource(){
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setDriverClassName(env.getRequiredProperty("jdbc.driverClassName"));
	    datasource.setUrl(env.getRequiredProperty("jdbc.url"));
	    datasource.setUsername(env.getRequiredProperty("jdbc.username"));
	    datasource.setPassword(env.getRequiredProperty("jdbc.password"));
	    
	    return datasource;
	}
	
	@Bean
	public EntityManagerFactory entityManagerFactory(){
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(true);

		Properties jpaProperties = new Properties();
		jpaProperties.put("hibernate.hbm2ddl.auto", env.getRequiredProperty("hibernate.hbm2ddl.auto"));
		jpaProperties.put("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
		jpaProperties.put("hibernate.show_sql", env.getRequiredProperty("hibernate.show_sql"));
		jpaProperties.put("hibernate.max_fetch_depth", env.getRequiredProperty("hibernate.max_fetch_depth"));
		jpaProperties.put("hibernate.jdbc.fetch_size", env.getRequiredProperty("hibernate.jdbc.fetch_size"));
		jpaProperties.put("hibernate.jdbc.batch_size", env.getRequiredProperty("hibernate.jdbc.batch_size"));

		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setDataSource(dataSource());
		factory.setPackagesToScan("com.oleg.belov.spring.data.jpa.entity");
		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setJpaProperties(jpaProperties);
		factory.afterPropertiesSet();
		factory.setLoadTimeWeaver(new InstrumentationLoadTimeWeaver());
		return factory.getObject();
	}
	
	@Bean
	public PlatformTransactionManager transactionManager(){
		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(entityManagerFactory());
		return txManager;
	}	
}
