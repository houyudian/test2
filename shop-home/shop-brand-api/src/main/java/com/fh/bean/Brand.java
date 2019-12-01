package com.fh.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Data
@TableName("s_brand")
public class Brand {
@TableId(value = "id",type = IdType.AUTO)
    private Short brandId;
@TableField("brandName")
    private String brandName;
    @TableField("telephone")
    private String telephone;
    @TableField("brandWeb")
    private String brandWeb;
    @TableField("brandLogo")
    private String brandLogo;
    @TableField("brandDesc")
    private String brandDesc;
    @TableField("brandStatus")
    private Byte brandStatus;
    @TableField("brandOrder")
    private Byte brandOrder;
@TableField("modifiedTime")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date modifiedTime;
    @TableField("categroyId")
    private Integer categroyId;
    @TableField("cateName")
    private String cateName;



}
