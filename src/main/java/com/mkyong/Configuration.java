package com.mkyong;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@org.springframework.context.annotation.Configuration
public class Configuration {

    private static final Logger logger = LoggerFactory.getLogger(Configuration.class);

    @Bean
    public DataSource dataSource(@Value("${spring.datasource.driver-class-name}") String driverClass,
                                 @Value("${spring.datasource.url}") String url, @Value("${spring.datasource.username}") String username, @Value("${spring.datasource.password}") String password){

        logger.info("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$${}", driverClass);
        logger.info("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$${}", url);
        logger.info("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$${}", username);
        logger.info("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$${}", password);
        DriverManagerDataSource source = new DriverManagerDataSource();
        source.setDriverClassName(driverClass);
        source.setUrl(url);
        source.setUsername(username);
        source.setPassword(password);
        return source;
    }

}
