package com.myself.crm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.myself.crm.mapper")
public class CrmSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrmSpringbootApplication.class, args);
    }

}
