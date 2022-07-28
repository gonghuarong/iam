package com.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;

//com.admin.* 是本模块的包路径，com.core.*是核心模块core的包路径
@SpringBootApplication(scanBasePackages = {"com.admin.*","com.core.*"})
@EnableDiscoveryClient
public class AdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class, args);
    }
}
