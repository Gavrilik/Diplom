package com.gavrilik.ads.data;

import java.io.Serializable;

public class Profile implements Serializable {
    private String name,secondName,city,email,number,about;

    public Profile(String name, String secondName, String city, String email, String number, String about) {
        this.name = name;
        this.secondName = secondName;
        this.city = city;
        this.email = email;
        this.number = number;
        this.about = about;
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

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}
