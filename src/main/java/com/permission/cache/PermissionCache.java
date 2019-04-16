package com.permission.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.permission.context.Context;
import com.permission.service.ResultMsg;
import com.permission.service.ValidateService;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author fushipeng@hnic.com
 * @date 2019-04-08
 */
public class PermissionCache {


    private static Cache<String, ResultMsg> cache = CacheBuilder.newBuilder().maximumSize(100).expireAfterAccess(5, TimeUnit.SECONDS).build();

    public static ResultMsg get(final ValidateService validateService, final Context context, final String userPin, final String[] permissions)
        throws ExecutionException {
        ResultMsg resultMsg = null;
        resultMsg = cache.get(userPin, new Callable<ResultMsg>() {
            @Override
            public ResultMsg call() throws Exception {
                /**
                 * 此处实现查询服务，查询实际有没有权限
                 */
                //  return validateService.hasPermission(context, userPin, permissions);

                if ("fushipeng".equals(userPin)) {
                    return new ResultMsg(true, "yes");
                } else {
                    return new ResultMsg(false, "no");
                }
            }
        });

        return resultMsg;
    }

}
