package com.kon.cloud.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Lin Kun
 * @create 2020/3/12
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String serial;

}