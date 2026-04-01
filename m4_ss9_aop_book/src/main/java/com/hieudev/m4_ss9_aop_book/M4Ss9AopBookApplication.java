package com.hieudev.m4_ss9_aop_book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class M4Ss9AopBookApplication {

    public static void main(String[] args) {
        SpringApplication.run(M4Ss9AopBookApplication.class, args);
    }

}
