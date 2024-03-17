package com.salihcanhiz.finalcase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class FinalCaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinalCaseApplication.class, args);
    }

}
