package com.example.demo2.config;

import com.example.demo2.entity.Employee;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.example.demo2.repo",
        transactionManagerRef = "transcationManager",
        entityManagerFactoryRef = "entityManager")
@EnableTransactionManagement
public class DataSourceConfig {
    @Autowired
    private DatasourceProps datasourceProps;
//    @Autowired
//    private ApplicationProps applicationProps;

    @Bean
    @Primary
    @Autowired
    public DataSource dataSource() {
        DataSourceRouting routingDataSource = new DataSourceRouting();
        List<LemonDriverManagerDataSource> dataSourceList = new ArrayList<LemonDriverManagerDataSource>();
        LemonDriverManagerDataSource dataSource = null;
        for(DatasourceProps.DbDetail dbDetail : datasourceProps.getDatasourceProps()){
            dataSource = new LemonDriverManagerDataSource();
            dataSource.setDbname(dbDetail.getName());
            dataSource.setUrl(dbDetail.getUrl());
            dataSource.setUsername(dbDetail.getUsername());
            dataSource.setPassword(dbDetail.getPassword());
            dataSourceList.add(dataSource);
        }

        routingDataSource.initDatasources(dataSourceList);
        return routingDataSource;
    }

    @Bean(name = "entityManager")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(
            EntityManagerFactoryBuilder builder) {
        return builder.dataSource(dataSource()).packages(Employee.class)
                .build();
    }

    @Bean(name = "transcationManager")
    public JpaTransactionManager transactionManager(
            @Autowired @Qualifier("entityManager") LocalContainerEntityManagerFactoryBean entityManagerFactoryBean) {
        return new JpaTransactionManager(entityManagerFactoryBean.getObject());
    }
}
