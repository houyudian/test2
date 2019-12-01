package com.fh.bean;

import lombok.Data;

@Data
public class Pro extends Product {

    private String subImgs;

    private String detail;

    private String attributeList;

    public String getSubImgs() {
        return subImgs;
    }

    public void setSubImgs(String subImgs) {
        this.subImgs = subImgs;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getAttributeList() {
        return attributeList;
    }

    public void setAttributeList(String attributeList) {
        this.attributeList = attributeList;
    }
}
