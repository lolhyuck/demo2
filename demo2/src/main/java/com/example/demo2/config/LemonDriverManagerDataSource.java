package com.example.demo2.config;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class LemonDriverManagerDataSource extends DriverManagerDataSource {
    private String dbname;
    public String getDbname(){
        return this.dbname;
    }
    public void setDbname(String dbname){
        this.dbname = dbname;
    }
}
