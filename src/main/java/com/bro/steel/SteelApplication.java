package com.bro.steel;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhanghonglin
 * @date 2020/12/14 19:30
 * @class SteelApplication
 * @description SteelApplication
 */
@SpringBootApplication
@MapperScan({ "com.bro.steel.dao"})
public class SteelApplication {
    public static void main(String[] args) {
        SpringApplication.run(SteelApplication.class, args);
    }
}
