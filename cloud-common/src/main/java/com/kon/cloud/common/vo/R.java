package com.kon.cloud.common.vo;


/**
 * @author Lin Kun
 * @create 2020/3/12
 */
public class R {

    private static final int OK = 200;

    private static final int NO = 444;

    public static <T> Result<T> ok() {
        return new Result<>(OK, null, null);
    }

    public static <T> Result<T> ok(String message) {
        return new Result<>(OK, message, null);
    }

    public static <T> Result<T> ok(T data) {
        return new Result<>(OK, null, data);
    }

    public static <T> Result<T> ok(String message, T data) {
        return new Result<>(OK, message, data);
    }

    public static <T> Result<T> no() {
        return new Result<>(NO, null, null);
    }

    public static <T> Result<T> no(String message) {
        return new Result<>(NO, message, null);
    }

}
