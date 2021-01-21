package com.example.demo2.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@ConfigurationProperties(prefix = "application")
public class DatasourceProps {


    public List<DbDetail> getDatasourceProps() {
        return datasourceProps;
    }

    public void setDatasourceProps(List<DbDetail> datasource) {
        this.datasourceProps = datasource;
    }

    private List<DbDetail> datasourceProps;
    public static class DbDetail{
        private String url;
        private String password;
        private String username;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        private String name;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }
}
