package com.example.yegan.myapplication.homePage.model;

public class CategoryMenuItem {

    String foodName, ingredient, price, salePrice;
    int time, num;

    public CategoryMenuItem(String foodName, String ingredient, String price, String salePrice, int time, int num) {
        this.foodName = foodName;
        this.ingredient = ingredient;
        this.price = price;
        this.salePrice = salePrice;
        this.time = time;
        this.num = num;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(String salePrice) {
        this.salePrice = salePrice;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getFoodName() {

        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }
}
