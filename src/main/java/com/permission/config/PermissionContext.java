package com.permission.config;

import com.permission.context.Context;
import java.util.UUID;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author fushipeng@hnic.com
 * @date 2019-04-08
 *
 * 权限配置类
 */

@Configuration
public class PermissionContext {

    @Bean(name = "context")
    public Context getContext() {
        Context context = new Context();
        context.setAppCode("001");
        context.setAppToken(UUID.randomUUID().toString().replaceAll("-", ""));
        return context;
    }


    public static void main(String[] args) {
        System.out.println(UUID.randomUUID().toString().replaceAll("-", "").length());
    }
}
