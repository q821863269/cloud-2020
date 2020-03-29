package com.kon.cloud.sentinel.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.kon.cloud.common.vo.R;
import com.kon.cloud.common.vo.Result;

/**
 * @author Lin Kun
 * @create 2020/3/29
 */
public class CustomerBlockHandler {

    public static Result handlerException(BlockException exception) {
        return R.no("按客户自定义的全局异常处理");
    }

}
