package com.example.ordy.Models;

public class Category {

    private String image, name;

    public Category(String image, String name) {
        this.image = image;
        this.name = name;
    }

    public Category() {}

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
