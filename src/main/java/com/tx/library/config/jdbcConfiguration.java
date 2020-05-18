package com.tx.library.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
public class jdbcConfiguration {

    @Bean
    @ConfigurationProperties(prefix = "jdbc")
    public DataSource getDataSourse(){
        DruidDataSource sourse = new DruidDataSource();
        return sourse;
    }

}
