package com.wx.control.Exception;

import lombok.Getter;


@Getter
public class BaseException extends RuntimeException {

    private int code = 500;

    public BaseException() {
    }

    public BaseException(String message) {
        super(message);
    }

    public BaseException(int code, String message) {
        super(message);
        this.code = code;
    }
}
