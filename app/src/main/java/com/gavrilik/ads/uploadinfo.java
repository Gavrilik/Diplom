package com.gavrilik.ads;

public class uploadinfo {


    private String imageURL;

    public uploadinfo() {
    }

    public uploadinfo(String url) {
        this.imageURL = url;
    }

    public String getImageURL() {
        return imageURL;
    }
}