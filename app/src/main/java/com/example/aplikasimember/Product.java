package com.example.aplikasimember;

public class Product {

    String name;
    double normalPrice;
    double promoPrice;
    int titleImage;

    public Product(String name, double normalPrice, double promoPrice, int titleImage) {
        this.name = name;
        this.normalPrice = normalPrice;
        this.promoPrice = promoPrice;
        this.titleImage = titleImage;
    }
}
