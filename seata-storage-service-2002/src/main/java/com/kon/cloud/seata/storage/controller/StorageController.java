package com.kon.cloud.seata.storage.controller;

import com.kon.cloud.common.vo.R;
import com.kon.cloud.common.vo.Result;
import com.kon.cloud.seata.storage.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Lin Kun
 * @create 2020/3/29
 */
@RestController
public class StorageController {

    @Autowired
    private StorageService storageService;


    //扣减库存
    @RequestMapping("/storage/decrease")
    public Result decrease(Long productId, Integer count) {
        storageService.decrease(productId, count);
        return R.ok("扣减库存成功！");
    }

}
