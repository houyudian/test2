package com.fh.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("s_login")
public class Login implements Serializable {
    @TableId(value = "customerId",type = IdType.AUTO)
    private Integer customerId;
    @TableField("loginName")
    private String loginName;
    @TableField("phone")
    private String  phone ;
    @TableField("userStatus")
    private Integer userStatus;
    @TableField("modifiedTime")
    private Date modifiedTime;
    @TableField("password")
    private String password;
    @TableField("cartId")
    private String cartId;
}
