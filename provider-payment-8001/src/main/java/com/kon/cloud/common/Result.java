package com.kon.cloud.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Lin Kun
 * @create 2020/3/12
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {

    private Integer code;

    private String message;

    private T data;

    public Result(Integer code, String message) {
        this(code, message, null);
    }

}
