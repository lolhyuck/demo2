package com.example.demo2.service;

import org.springframework.stereotype.Component;

@Component("T2")
public class DemoImpl2 implements Demo {
    @Override
    public String getNameById(String name) {
        return name + "2";
    }
}
