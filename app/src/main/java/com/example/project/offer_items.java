package com.example.project;

import java.io.Serializable;
public class offer_items implements Serializable {
    private  String dis;
    private int img;
    private String name;
    private String old_price;
    private String new_price;

    public offer_items(){

    }
    public offer_items(int img,String dis ,String name, String old_price, String new_price) {
        this.img = img;
        this.dis = dis;

        this.name = name;
        this.old_price = old_price;
        this.new_price = new_price;
    }

    public String getDis() {
        return dis;
    }

    public void setDis(String dis) {
        this.dis = dis;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOld_price() {
        return old_price;
    }

    public void setOld_price(String old_price) {
        this.old_price = old_price;
    }

    public String getNew_price() {
        return new_price;
    }

    public void setNew_price(String new_price) {
        this.new_price = new_price;
    }
}
