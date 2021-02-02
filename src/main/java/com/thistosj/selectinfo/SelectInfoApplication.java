package com.thistosj.selectinfo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.thistosj.selectinfo.business.dao")
public class SelectInfoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SelectInfoApplication.class, args);
    }

}
