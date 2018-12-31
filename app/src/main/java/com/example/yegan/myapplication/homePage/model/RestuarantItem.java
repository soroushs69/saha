package com.example.yegan.myapplication.homePage.model;

public class RestuarantItem {


    String name, type;
    int rate, logoId, backgroundId;

    public RestuarantItem(String name, String type, int rate, int logoId, int backgroundId) {
        this.name = name;
        this.type = type;
        this.rate = rate;
        this.logoId = logoId;
        this.backgroundId = backgroundId;
    }

    public int getBackgroundId() {
        return backgroundId;
    }

    public void setBackgroundId(int backgroundId) {
        this.backgroundId = backgroundId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getLogoId() {
        return logoId;
    }

    public void setLogoId(int logoId) {
        this.logoId = logoId;
    }
}
