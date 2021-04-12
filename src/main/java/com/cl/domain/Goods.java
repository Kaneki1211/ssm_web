package com.cl.domain;

import java.io.Serializable;

public class Goods implements Serializable {
    private Integer id;
    private Integer gcount;
    private String gName;
    private Integer gPrice;

    public Integer getgId() {
        return id;
    }

    public void setgId(Integer gId) {
        this.id = gId;
    }

    public Integer getCount() {
        return gcount;
    }

    public void setCount(Integer gcount) {
        this.gcount = gcount;
    }

    public String getgName() {
        return gName;
    }

    public void setgName(String gName) {
        this.gName = gName;
    }

    public Integer getGprice() {
        return gPrice;
    }

    public void setGprice(Integer gPrice) {
        this.gPrice = gPrice;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", gcount=" + gcount +
                ", gName='" + gName + '\'' +
                ", gPrice=" + gPrice +
                '}';
    }
}
