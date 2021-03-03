package com.example.demo2.service;

import org.springframework.stereotype.Component;

@Component("T1")
public class DemoImpl1 implements Demo{
    @Override
    public String getNameById(String name) {
        return name + "1";
    }
}
