package com.example.aplikasimember;

public class Promo {

    String nama;
    double hargaNormal;
    double hargaPromo;
    int titleImg;

    public Promo(String name, double hargaNormal, double hargaPromo, int titleImg) {
        this.nama = name;
        this.hargaNormal = hargaNormal;
        this.hargaPromo = hargaPromo;
        this.titleImg = titleImg;
    }
}

