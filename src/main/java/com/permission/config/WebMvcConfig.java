package com.permission.config;

import com.permission.interceptor.PermissionInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author fushipeng@hnic.com
 * @date 2019-04-08
 */

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * add custom interceptor
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new PermissionInterceptor());
    }
}
