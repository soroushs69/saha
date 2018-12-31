
//کلاس آیتم های اسلایدر صفحه اصلی

package com.example.yegan.myapplication.homePage.model;

public class RestaurantSliderItem {

    int imageId;
    String title;

    public RestaurantSliderItem(int imageId,String title) {
        this.imageId = imageId;
        this.title=title;
    }

    public int getImageId() {
        return imageId;
    }
    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
