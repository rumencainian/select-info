package com.thistosj.selectinfo.config;


import com.alibaba.druid.pool.DruidDataSource;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.autoconfigure.quartz.QuartzDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;


/**
 * 数据源配置
 *
 * @author lgq
 */
@Configuration
public class DataSourceConfiguration {
    /**
     * 创建user数据源的配置对象
     * 读取spring.datasource.user配置到DataSourceProperties对象
     */
    @Primary
    @Bean(name = "userDataSourceProperties")
    @ConfigurationProperties(prefix = "spring.datasource.druid.user")
    public DataSourceProperties userDataSourceProperties() {
        return new DataSourceProperties();
    }

    /**
     * 创建user数据源
     * 读取 spring.datasource.user 配置到 HikariDataSource 对象
     */
    @Primary
    @Bean(name = "userDataSource")
    @ConfigurationProperties("spring.datasource.druid.user.hikari")
    public DataSource userDataSource() {
        // 获得 DataSourceProperties 对象
        DataSourceProperties properties = this.userDataSourceProperties();
        // 创建 HikariDataSource 对象
        return createHikariDataSource(properties);
    }

    /**
     * 创建 quartz 数据源的配置对象
     * 读取 spring.datasource.quartz 配置到 DataSourceProperties 对象
     */
    @Bean(name = "quartzDataSourceProperties")
    @ConfigurationProperties(prefix = "spring.datasource.druid.quartz")
    public DataSourceProperties quartzDataSourceProperties() {
        return new DataSourceProperties();
    }

    /**
     * 创建 quartz 数据源
     *
     */
    @Bean(name = "quartzDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.druid.quartz.hikari")
    @QuartzDataSource
    public DataSource quartzDataSource() {
        // 获得 DataSourceProperties 对象
        DataSourceProperties properties = this.quartzDataSourceProperties();
        // 创建 HikariDataSource 对象
        return createHikariDataSource(properties);
    }


    private static DruidDataSource createHikariDataSource(DataSourceProperties properties) {
        // 创建 HikariDataSource 对象
        DruidDataSource dataSource = properties.initializeDataSourceBuilder().type(DruidDataSource.class).build();
        // 设置名称
        if (StringUtils.hasText(properties.getName())) {
            dataSource.setName(properties.getName());
        }
        return dataSource;
    }

}
