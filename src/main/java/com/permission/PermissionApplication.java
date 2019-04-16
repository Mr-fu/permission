package com.permission;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@Slf4j
public class PermissionApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(PermissionApplication.class, args);
        String[] beanNames = ctx.getBeanDefinitionNames();
        log.info("bean count:" + ctx.getBeanDefinitionCount());
        for (String name : beanNames) {
            log.info(name);
        }
        System.out.println("====Start Successful====");
    }

}
