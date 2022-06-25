package com.example.htc.entity;

public class Dish {
    private int id;

    private String dishName;

    private String rame;

    private String cal;

    private String oper;

    private String addcon;

    private String type;

    private String img;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getRame() {
        return rame;
    }

    public void setRame(String rame) {
        this.rame = rame;
    }

    public String getCal() {
        return cal;
    }

    public void setCal(String cal) {
        this.cal = cal;
    }

    public String getOper() {
        return oper;
    }

    public void setOper(String oper) {
        this.oper = oper;
    }

    public String getAddcon() {
        return addcon;
    }

    public void setAddcon(String addcon) {
        this.addcon = addcon;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", dishName='" + dishName + '\'' +
                ", rame='" + rame + '\'' +
                ", cal='" + cal + '\'' +
                ", oper='" + oper + '\'' +
                ", addcon='" + addcon + '\'' +
                ", type='" + type + '\'' +
                ", img='" + img + '\'' +
                '}';
    }
}
