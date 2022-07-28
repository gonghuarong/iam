package com.sso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

//com.sso.* 是本模块的包路径，com.core.*是核心模块core的包路径
@SpringBootApplication(scanBasePackages = {"com.sso.*","com.core.*"})
@EnableDiscoveryClient
public class SsoApplication {
    public static void main(String[] args) {
        SpringApplication.run(SsoApplication.class, args);
    }
}
