package com.politics.chn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.politics.chn.mapper")
public class ChnApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChnApplication.class, args);
    }

}
