package com.kon.cloud.seata.account.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author Lin Kun
 * @create 2020/3/29
 */
@Data
@TableName(value = "t_account")
public class Account {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户id
     */
    @TableField(value = "user_id")
    private Long userId;

    /**
     * 总额度
     */
    @TableField(value = "total")
    private BigDecimal total;

    /**
     * 已用额度
     */
    @TableField(value = "used")
    private BigDecimal used;

    /**
     * 剩余可用额度
     */
    @TableField(value = "residue")
    private BigDecimal residue;
}
