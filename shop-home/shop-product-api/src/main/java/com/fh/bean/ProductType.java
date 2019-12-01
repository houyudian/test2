package com.fh.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("s_productType")
public class ProductType {
    @TableId(value = "id", type = IdType.AUTO)

    private Integer id;
    @TableField("categroyId")
    private Integer categroyId;
    @TableField("productId")
    private Integer productId;



}
