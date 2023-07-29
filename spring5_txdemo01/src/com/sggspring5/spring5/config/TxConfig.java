package com.sggspring5.spring5.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * ClassName: TxConfig
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/7/29 15:48
 * @Version 1.0
 */
@Configuration  //配置类
@ComponentScan(basePackages = "com.sggspring5.spring5") //组件扫描
@EnableTransactionManagement    //开启事务
public class TxConfig {

    //创建数据库连接池, 代替xml里的连接池配置
    @Bean
    public DruidDataSource getDruidDataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        druidDataSource.setUrl("jdbc:mysql:///userdb");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("abc123");

        return druidDataSource;
    }

    //创建JdbcTemplate对象
    @Bean
    public JdbcTemplate getJdbcTemplate(DataSource dataSource){
        //到ioc容器中根据类型找到dataSource
        JdbcTemplate jdbcTemplate = new JdbcTemplate();

        //注入dataSource
        jdbcTemplate.setDataSource(dataSource);

        return jdbcTemplate;
    }

    //创建事务管理器
//    @Bean
//    public DataSourceTransactionManager getDataSourceTransactionManager(DataSource dataSource){
//        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
//
//        transactionManager.setDataSource(dataSource);
//
//        return transactionManager;
//    }
}
