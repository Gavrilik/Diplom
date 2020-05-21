package com.gavrilik.ads.model;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {
    private long id;
    private String imageUrl;
    private String name;
    private String secondName;
    private String description;
    private String location;
    private String email;
    private String number;

    public User(long id, String imageUrl, String name, String secondName, String description, String location, String email, String number) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.name = name;
        this.secondName = secondName;
        this.description = description;
        this.location = location;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                imageUrl.equals(user.imageUrl) &&
                Objects.equals(name, user.name) &&
                Objects.equals(secondName, user.secondName) &&
                description.equals(user.description) &&
                location.equals(user.location) &&
                Objects.equals(email, user.email) &&
                Objects.equals(number, user.number);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {
        return Objects.hash(id, imageUrl, name, secondName, description, location, email, number);
    }
}
