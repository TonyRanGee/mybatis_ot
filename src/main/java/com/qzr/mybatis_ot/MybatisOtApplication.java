package com.qzr.mybatis_ot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//不加也可以展示数据，不知道原因
@MapperScan(basePackages = {"com.qzr.mybatis_ot.dao"})
public class MybatisOtApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisOtApplication.class, args);
    }

}
