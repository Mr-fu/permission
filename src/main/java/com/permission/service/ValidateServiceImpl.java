package com.permission.service;

import com.permission.context.Context;
import org.springframework.stereotype.Component;

/**
 * @author fushipeng@hnic.com
 * @date 2019-04-08
 */

@Component("validateService")
public class ValidateServiceImpl implements ValidateService {

    @Override
    public ResultMsg hasPermission(Context context, String userPin, String[] permissions) {
        if ("fushipeng".equals(userPin)) {
            return new ResultMsg(true, "yes");
        } else {
            return new ResultMsg(false, "no");
        }
    }
}
