package com.permission.service;

import com.permission.context.Context;

/**
 * @author fushipeng@meituan.com
 * @date 2019-04-08
 *
 * 权限认证
 */
public interface ValidateService {

    ResultMsg hasPermission(Context context, String userPin, String[] permissions);
}
