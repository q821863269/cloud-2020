package com.kon.cloud.seata.storage.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kon.cloud.seata.storage.mapper.StorageMapper;
import com.kon.cloud.seata.storage.entity.Storage;

/**
 * @author Lin Kun
 * @create 2020/3/29
 */
@Slf4j
@Service
public class StorageService extends ServiceImpl<StorageMapper, Storage> {

    public void decrease(Long productId, Integer count) {
        log.info("------->storage-service中扣减库存开始");
        Storage storage = this.baseMapper.selectOne(new QueryWrapper<Storage>().lambda()
            .eq(Storage::getProductId, productId));
        storage.setUsed(storage.getUsed() + count);
        storage.setResidue(storage.getResidue() - count);
        this.baseMapper.update(storage, new UpdateWrapper<Storage>().lambda()
            .eq(Storage::getProductId, productId));
        log.info("------->storage-service中扣减库存结束");
    }

}
