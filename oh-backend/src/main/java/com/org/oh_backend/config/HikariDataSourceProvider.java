package com.org.oh_backend.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@PropertySource(value = { "classpath:application.properties" })
public class HikariDataSourceProvider {
	
	@Bean
	@ConfigurationProperties("spring.datasource")
	public HikariDataSource dataSource() {
		return (HikariDataSource) DataSourceBuilder.create().type(HikariDataSource.class).build();
	}
	
	
}
