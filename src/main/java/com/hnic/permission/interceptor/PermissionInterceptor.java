package com.hnic.permission.interceptor;

import com.hnic.permission.annotation.RequiresPermissions;
import com.hnic.permission.cache.PermissionCache;
import com.hnic.permission.context.Context;
import com.hnic.permission.service.ResultMsg;
import com.hnic.permission.service.ValidateService;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Method;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * @author fushipeng@hnic.com
 * @date 2019-04-08
 */

@Configuration
public class PermissionInterceptor extends HandlerInterceptorAdapter {

    @Resource(name = "validateService")
    private ValidateService validateService;

    @Resource(name = "context")
    private Context context;

    long start = System.currentTimeMillis();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        start = System.currentTimeMillis();
        if (o instanceof HandlerMethod) {
            HandlerMethod hm = (HandlerMethod) o;
            Method method = hm.getMethod();
            boolean isRequiresPermissionMethod = method.isAnnotationPresent(RequiresPermissions.class);
            if (isRequiresPermissionMethod) {
                RequiresPermissions permissions = method.getAnnotation(RequiresPermissions.class);

                String userPin = getUserPin();
                if (StringUtils.isEmpty(userPin)) {
                    returnError(response, "login first");
                    return false;
                }
                ResultMsg resultMsg = PermissionCache.get(validateService, context, userPin, permissions.values());
                if (!resultMsg.isSuccess()) {
                    returnError(response, "has no permission");
                    return false;
                }
                System.out.println("permission code is :" + arrayToString(permissions.values()));
            }
        }
        return true;
    }

    private String arrayToString(String[] array) {
        StringBuffer sb = new StringBuffer();
        for (String str : array) {
            sb.append(str).append(",");
        }
        return sb.toString();
    }

    private int i = 0;

    private String getUserPin() {
        if (i % 2 == 0) {
            i++;
            return "fushipeng";
        } else {
            i++;
            return "fushipeng";
        }
    }

    protected void returnError(HttpServletResponse response, String msg) throws IOException {
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        Writer writer = response.getWriter();
        writer.write("<center><font color='red' size=5>" + msg + "</font></center>");
        writer.close();
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView)
        throws Exception {
        System.out.println("Interceptor cost=" + (System.currentTimeMillis() - start));
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }

}
