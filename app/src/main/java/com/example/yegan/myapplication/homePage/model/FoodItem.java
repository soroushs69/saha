package com.example.yegan.myapplication.homePage.model;

public class FoodItem {

    String foodName, restuarantName, price, salePrice;
    int timeRemain, howMany, imageId;


    public FoodItem(String foodName, String restuarantName, String price, String salePrice, int timeRemain, int howMany, int imageId) {

        this.foodName = foodName;
        this.restuarantName = restuarantName;
        this.price = price;
        this.salePrice = salePrice;
        this.timeRemain = timeRemain;
        this.howMany = howMany;
        this.imageId = imageId;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getRestuarantName() {
        return restuarantName;
    }

    public void setRestuarantName(String restuarantName) {
        this.restuarantName = restuarantName;
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

    public int getTimeRemain() {
        return timeRemain;
    }

    public void setTimeRemain(int timeRemain) {
        this.timeRemain = timeRemain;
    }

    public int getHowMany() {
        return howMany;
    }

    public void setHowMany(int howMany) {
        this.howMany = howMany;
    }

}
