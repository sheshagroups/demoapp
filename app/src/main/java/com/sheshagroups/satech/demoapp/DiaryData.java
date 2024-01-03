package com.sheshagroups.satech.demoapp;

public class DiaryData {

    public String imageURL, caption;

    public DiaryData(){

    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public DiaryData(String imageURL, String caption) {
        this.imageURL = imageURL;
        this.caption = caption;
    }
}
