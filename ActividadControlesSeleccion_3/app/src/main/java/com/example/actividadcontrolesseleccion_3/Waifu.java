package com.example.actividadcontrolesseleccion_3;

public class Waifu {
    private int img;
    private String nom, serie, infoLink;

    public Waifu(int img, String nom, String serie, String infoLink) {
        this.img = img;
        this.nom = nom;
        this.serie = serie;
        this.infoLink = infoLink;
    }

    public int getImg() {
        return img;
    }

    public Waifu setImg(int img) {
        this.img = img;
        return this;
    }

    public String getNom() {
        return nom;
    }

    public Waifu setNom(String nom) {
        this.nom = nom;
        return this;
    }

    public String getSerie() {
        return serie;
    }

    public Waifu setSerie(String serie) {
        this.serie = serie;
        return this;
    }

    public String getInfoLink() {
        return infoLink;
    }

    public Waifu setInfoLink(String infoLink) {
        this.infoLink = infoLink;
        return this;
    }
}
