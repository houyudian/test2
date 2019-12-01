package com.fh.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@TableName("s_product")
@Data
public class Product {
@TableId(value="id",type= IdType.AUTO)
    private Integer id;
@TableField("brandId")
    private Integer brandId;
    @TableField("name")
    private String name;
    @TableField("subtitle")
    private String subtitle;
    @TableField("mainImg")
    private String mainImg;
    @TableField("price")
    private Integer price;
    @TableField("stock")
    private Integer stock;
    @TableField("status")
    private Integer status;
    @TableField("createTime")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @TableField("updateTime")
    private Date updateTime;



}
