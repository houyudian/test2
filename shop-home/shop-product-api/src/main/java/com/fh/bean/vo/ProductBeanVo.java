package com.fh.bean.vo;

import com.fh.utils.ExcelAnno;

import java.util.Date;

/**
 * @author shangfeng
 * @Title: ProductBeanVo
 * @Package com.fh.beanvo
 * @Description: ${todo}
 * @date 2019/7/17  15:09
 */
@ExcelAnno(title = "商品信息展示",sheetName = "商品信息",mkdir = "shop/product/excel")
public class ProductBeanVo {


    @ExcelAnno("商品名称")
    private String name;

    @ExcelAnno("商品标题")
    private String subtitle;


    @ExcelAnno("商品价格")
    private Long price;
    @ExcelAnno("商品库存")
    private Integer stock;
    @ExcelAnno("商品状态")
    private String status;

    @ExcelAnno("创建时间")
    private Date createTime;
    @ExcelAnno("修改时间")
    private Date updateTime;


    //展示品牌名称使用
    @ExcelAnno("品牌名称")
    private String brandName;
    //展示商品类型名称
    @ExcelAnno("类型名称")
    private String categroyName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getCategroyName() {
        return categroyName;
    }

    public void setCategroyName(String categroyName) {
        this.categroyName = categroyName;
    }
}
