package com.example.springbootdemo.config.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.beans.PropertyVetoException;

/**
 * @Configuration
 * springBoot使用代码来代替xml的配置，使用springBoot的尽量少用xml的配置文件
 * 在springBoot启动的是时候自动扫描@configuration的下的配置文件
 * @MapperScan
 * 配置mybatis  mapper扫描的配置文件
 */
@Configuration
@MapperScan("com.example.springbootdemo.dao")
public class DataSourceConfiguration {
    /**
     * 在application.properties配置相关属性的值
     */
    @Value("${jdbc.driver}")
    private String jdbcDriver;
    @Value("${jdbc.url}")
    private String jdbcUrl;
    @Value("${jdbc.userName}")
    private String jdbcUsername;
    @Value("${jdbc.passWord}")
    private String jdbcPassword;

    @Bean(name = "dataSource")
    public ComboPooledDataSource createDataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(jdbcDriver);
        dataSource.setJdbcUrl(jdbcUrl);
        dataSource.setUser(jdbcUsername);
        dataSource.setPassword(jdbcPassword);
        // 关闭连接不自动commit
        dataSource.setAutoCommitOnClose(false);
        return dataSource;
    }
}
