package com.kon.cloud.seata.storage.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author Lin Kun
 * @create 2020/3/29
 */
@Data
@TableName(value = "t_storage")
public class Storage {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 产品id
     */
    @TableField(value = "product_id")
    private Long productId;

    /**
     * 总库存
     */
    @TableField(value = "total")
    private Integer total;

    /**
     * 已用库存
     */
    @TableField(value = "used")
    private Integer used;

    /**
     * 剩余库存
     */
    @TableField(value = "residue")
    private Integer residue;
}
