package com.fh.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("s_type")
public class Type {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    @TableField("pid")
    private Integer pid;
    @TableField("name")
    private String name;
    @TableField("status")
    private Short status;
    @TableField("sortOrder")
    private Integer sortOrder;


}
