package com.yc.example.knife4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @description:
 * @author: youcong
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class YcExampleKnife4jApplication {
    public static void main(String[] args) {
        SpringApplication.run(YcExampleKnife4jApplication.class, args);
    }
}
