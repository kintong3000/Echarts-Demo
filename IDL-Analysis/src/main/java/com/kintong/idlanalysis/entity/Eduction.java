package com.kintong.idlanalysis.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author kintong
 */

@Data
@TableName("education")
public class Eduction {

    @TableField("education")
    String eduction;

    @TableField("ratio")
    BigDecimal ratio;
}
