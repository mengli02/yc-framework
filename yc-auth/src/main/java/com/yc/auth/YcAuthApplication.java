package com.yc.auth;

import com.yc.common.core.base.constant.ApplicationConst;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @description:
 * @author: youcong
 * @time: 2021/8/24 21:49
 */
@SpringCloudApplication
@EnableFeignClients(basePackages = ApplicationConst.FEIGN_PACKAGE_SCANNER)
@MapperScan(ApplicationConst.MAPPER_AUTH)
public class YcAuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(YcAuthApplication.class, args);
        System.out.println("======认证启动成功======");
    }
}
