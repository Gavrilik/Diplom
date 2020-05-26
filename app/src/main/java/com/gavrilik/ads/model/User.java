package com.gavrilik.ads.model;

import java.io.Serializable;

public class User implements Serializable {
    private long id;
    private String imageUrl;
    private String name;
    private String secondName;
    private String description;
    private String country;
    private String city;
    private String email;
    private String number;

    public User(long id, String imageUrl, String name, String secondName, String description, String country, String city, String email, String number) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.name = name;
        this.secondName = secondName;
        this.description = description;
        this.country = country;
        this.city = city;
        this.email = email;
        this.number = number;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
