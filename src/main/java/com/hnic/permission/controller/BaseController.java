package com.hnic.permission.controller;

import com.hnic.permission.context.Context;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author fushipeng@hnic.com
 * @date 2019-04-08
 */

@Controller
@RequestMapping(value = {"/base"})
public class BaseController {

    @Resource
    private Context context;


    @RequestMapping(value = "/main")
    //@RequiresPermissions(values = {"test1", "test2"})
    public String main(Map<String, Object> model) {
        model.put("name", "fushipeng");
        System.out.println(context.getAppCode() + "===" + context.getAppToken());
        return "main";
    }


    @RequestMapping(value = "/main1")
    //@RequiresPermissions(values = {"test1", "test2"})
    public String main1(Map<String, Object> model) {
        model.put("name", "fushipeng");
        System.out.println(context.getAppCode() + "===" + context.getAppToken());
        return "main1";
    }

    @RequestMapping(value = "/test1")
    public @ResponseBody
    String test1(Map<String, Object> model, HttpServletRequest request) {
        request.getHeader("");
        return "this is test1";
    }

    @RequestMapping(value = "/test2")
    public @ResponseBody
    String test2(Map<String, Object> model, HttpServletRequest request) {
        model.put("name", "fushipeng");
        System.out.println(context.getAppCode() + "===" + context.getAppToken());
        return "this is test2";
    }


    public static void main(String[] args) {
        CopyOnWriteArrayList copy =new CopyOnWriteArrayList();

        Iterator iterator =copy.iterator();
    }
}
