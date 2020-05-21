package com.gavrilik.ads.model;


public class Ads {

    private User user;
    private Long id;
    private String creationDate;
    private String description;
    private int rating;
    private String imageUrl;

    public Ads() {
    }

    public Ads(User user, Long id, String creationDate, String description, int rating, String imageUrl) {
        this.user = user;
        this.id = id;
        this.creationDate = creationDate;
        this.description = description;
        this.rating = rating;
        this.imageUrl = imageUrl;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}
