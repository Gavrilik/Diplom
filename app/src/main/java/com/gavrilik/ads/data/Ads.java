package com.gavrilik.ads.data;


public class Ads {


    private Integer id;
    private String sellerName;
    private String description;
    //private Date ads_date;
    private Double rating;
    private int image;



    public Ads(Integer id, String sellerName, String description, Double rating, int image) {
        this.id = id;
        this.sellerName = sellerName;
        this.description = description;
        this.rating = rating;
        this.image = image;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
