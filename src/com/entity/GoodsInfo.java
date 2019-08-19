package com.entity;

import java.io.Serializable;
import java.util.Date;

public class GoodsInfo implements Serializable {
    private int  id ;
    private String goodsInfoName ;
    private String goodsInfoPic ;
    private double goodsInfoPrice ;
    private String goodsInfoDescription;
    private int goodsStock ;
    private int flag ;
    private String created;
    private Date createdDate;

    public GoodsInfo() {
    }

    public GoodsInfo(int id, String goodsInfoName, String goodsInfoPic, double goodsInfoPrice, String goodsInfoDescription, int goodsStock, int flag, String created, Date createdDate) {
        this.id = id;
        this.goodsInfoName = goodsInfoName;
        this.goodsInfoPic = goodsInfoPic;
        this.goodsInfoPrice = goodsInfoPrice;
        this.goodsInfoDescription = goodsInfoDescription;
        this.goodsStock = goodsStock;
        this.flag = flag;
        this.created = created;
        this.createdDate = createdDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGoodsInfoName() {
        return goodsInfoName;
    }

    public void setGoodsInfoName(String goodsInfoName) {
        this.goodsInfoName = goodsInfoName;
    }

    public String getGoodsInfoPic() {
        return goodsInfoPic;
    }

    public void setGoodsInfoPic(String goodsInfoPic) {
        this.goodsInfoPic = goodsInfoPic;
    }

    public double getGoodsInfoPrice() {
        return goodsInfoPrice;
    }

    public void setGoodsInfoPrice(double goodsInfoPrice) {
        this.goodsInfoPrice = goodsInfoPrice;
    }

    public String getGoodsInfoDescription() {
        return goodsInfoDescription;
    }

    public void setGoodsInfoDescription(String goodsInfoDescription) {
        this.goodsInfoDescription = goodsInfoDescription;
    }

    public int getGoodsStock() {
        return goodsStock;
    }

    public void setGoodsStock(int goodsStock) {
        this.goodsStock = goodsStock;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "GoodsInfo{" +
                "id=" + id +
                ", goodsInfoName='" + goodsInfoName + '\'' +
                ", goodsInfoPic='" + goodsInfoPic + '\'' +
                ", goodsInfoPrice=" + goodsInfoPrice +
                ", goodsInfoDescription='" + goodsInfoDescription + '\'' +
                ", goodsStock=" + goodsStock +
                ", flag=" + flag +
                ", created='" + created + '\'' +
                ", createdDate=" + createdDate +
                '}';
    }
}
