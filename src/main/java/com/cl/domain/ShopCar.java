package com.cl.domain;

import java.util.ArrayList;
import java.util.List;

public class ShopCar {

    private int price;
    private List<Items> goodsList = new ArrayList<Items>();

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public List<Items> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Items> goodsList) {
        this.goodsList = goodsList;
    }

    public void addItem(Items items) {
        goodsList.add(items);
    }

    public int find(Items items) {

        for (int i = 0; i < goodsList.size(); i++) {
            if (goodsList.get(i).getName().equals(items.getName())) {
                return i;
            }
        }
        return -1;
    }

    public void delItem(Items items) {
        if(find(items) != -1) {
            goodsList.remove(find(items));
        }
    }

    public void clearItem() {
        goodsList.clear();
    }
    @Override
    public String toString() {
        return "ShopCar{" +
                "price=" + price +
                ", goodsList=" + goodsList +
                '}';
    }
}
