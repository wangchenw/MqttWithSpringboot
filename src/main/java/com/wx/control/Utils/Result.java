package com.wx.control.Utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.wx.control.Exception.BaseException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result implements Serializable {
    private static final long serialVersionUID = 4307394367499737201L;

    private static final int OK = 0;

    private static final int FAILED = 500;

    private boolean success;

    private int statusCode;

    private String msg = "";

    private String data;

    public static Result ok() {
        return restResult(true, OK, null, null);
    }

    public static Result ok(String data) {
        return restResult(true, OK, null, data);
    }

    public static Result yan(String data){
        return restResult(true ,200,null,data);
    }

    public static <T> Result ok(T obj) {
        return ok(JSON.toJSONString(obj, SerializerFeature.WriteMapNullValue));
    }

    public static Result okMsg(String msg) {
        return restResult(true, OK, msg, null);
    }

    public static Result failed(String msg) {
        return restResult(false, FAILED, msg, null);
    }

    public static <BE extends BaseException> Result failed(BE be) {
        return restResult(false, be.getCode(), be.getMessage(), null);
    }

    public static Result failed(int statusCode, String msg) {
        return restResult(false, statusCode, msg, null);
    }

    private static Result restResult(boolean success, int statusCode, String msg, String data) {
        return new Result(success, statusCode, msg, data);
    }
}
