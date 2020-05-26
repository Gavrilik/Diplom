package com.gavrilik.ads.model;


public class Ads {

    //private User user;

    private String creationDate;
    private String name;
    private String description;
    private float price;
    private String imageUrl;
    //private String category;

    public Ads() {
    }

    public Ads(String creationDate, String name, String description, float price) {
        this.creationDate = creationDate;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Ads(String creationDate, String name, String description, float price, String imageUrl) {

        this.creationDate = creationDate;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
