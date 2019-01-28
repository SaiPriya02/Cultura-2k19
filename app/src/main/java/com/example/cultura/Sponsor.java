package com.example.cultura;

public class Sponsor {
    private String name;
    private int image;

    public Sponsor(String name, int image) {

        this.name = name;
        this.image = image;
    }



    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }
}