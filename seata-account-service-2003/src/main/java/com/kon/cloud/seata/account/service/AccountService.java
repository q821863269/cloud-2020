package com.kon.cloud.seata.account.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kon.cloud.seata.account.mapper.AccountMapper;
import com.kon.cloud.seata.account.entity.Account;

/**
 * @author Lin Kun
 * @create 2020/3/29
 */
@Slf4j
@Service
public class AccountService extends ServiceImpl<AccountMapper, Account> {

    public void decrease(Long userId, BigDecimal money) {
        log.info("------->account-service中扣减账户余额开始");
        int i = new Random().nextInt(10) + 1;
        if (i > 5) {
            throw new RuntimeException("随机报错");
        }

        Account account = this.baseMapper.selectOne(new QueryWrapper<Account>().lambda()
            .eq(Account::getUserId, userId));
        account.setUsed(account.getUsed().add(money));
        account.setResidue(account.getResidue().subtract(money));
        this.baseMapper.update(account, new UpdateWrapper<Account>().lambda()
            .eq(Account::getUserId, userId));
        log.info("------->account-service中扣减账户余额结束");
    }

}
