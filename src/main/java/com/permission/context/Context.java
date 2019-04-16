package com.permission.context;

import java.io.Serializable;
import lombok.Data;

/**
 * @author fushipeng@meituan.com
 * @date 2019-04-08
 *
 * 用户请求上下文，主要方便获取应用配置信息
 */

@Data
public class Context implements Serializable {

    private static final long serialVersionUID = -4608736881457941251L;

    /**
     * 应用编号
     */
    private String appCode;

    /**
     * 应用请求Token
     */
    private String appToken;


    @Override
    public String toString() {
        return "Context{" +
            "appCode='" + appCode + '\'' +
            ", appToken='" + appToken + '\'' +
            '}';
    }
}
