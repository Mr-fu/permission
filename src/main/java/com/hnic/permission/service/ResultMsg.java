package com.hnic.permission.service;

import java.util.List;
import lombok.Data;

/**
 * @author fushipeng@hnic.com
 * @date 2019-04-08
 */

@Data
public class ResultMsg {

    private boolean success;
    private String msg;
    private List data;

    public ResultMsg(boolean success, String msg) {
        this.success = success;
        this.msg = msg;
    }
}
