package com.example.demo2.config;

import com.example.demo2.service.GrantServiceProvider;
import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfiguration {
    @Bean
    public ServiceLocatorFactoryBean grantServiceProviderBean() {
        ServiceLocatorFactoryBean bean = new ServiceLocatorFactoryBean();
        bean.setServiceLocatorInterface(GrantServiceProvider.class);

        return bean;
    }
}
