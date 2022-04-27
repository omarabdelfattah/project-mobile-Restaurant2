package com.example.project;

import java.io.Serializable;

class Meil implements Serializable {
    private  String dis;
    private int img;
    private String name;
    private String price;




    public Meil() {

    }
    public Meil(int img, String name, String dis, String price){
        this.img=img;
        this.name=name;
        this.dis=dis;
        this.price=price;
    }

    public int getImg() {
        return img;
    }

    public String getDis() {
        return dis;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setDis(String dis) {
        this.dis = dis;
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
}
