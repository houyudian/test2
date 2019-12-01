package com.fh.utils;

import java.util.List;

public class PageBean<T> {

    private Integer start;
    private Integer length;
    private Integer draw = 1;//绘制次数；
    private long recordsTotal;//总长度
    private long recordsFiltered;//过滤后的长度
    private List<T> data;//包含的数据
    private int code; // 状态码, 0表示成功
    /*private Integer cpage;
    private Integer pageSize;
    private Integer start;
    private Long count;
    private List<T> data;
    private int code; // 状态码, 0表示成功
*/

    public PageBean(Integer draw, Integer length) {
        super();
        if (draw <= 0) {
            draw = 1;
        }
        if (length <= 0) {
            length = 3;
        }
        this.draw = draw;
        this.length = length;
        this.start = (this.draw - 1) * this.length;
        this.code = 0;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getDraw() {
        return draw;
    }

    public void setDraw(Integer draw) {
        this.draw = draw;
    }

    public long getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(long recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public long getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(long recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
