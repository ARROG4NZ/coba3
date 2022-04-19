package com.example.praktikum_6;

public class contact_model {
    private String nama;
    private String nomor;
    private int image;

    public contact_model(String nama, String nomor) {
        this.nama = nama;
        this.nomor = nomor;
    }

    public contact_model (String nama, String nomor, int image){
        this.image = image;
        this.nomor = nomor;
        this.nama = nama;
    }

    public int getImage() {
        return image;
    }

    public String getNama() {
        return nama;
    }

    public String getNomor() {
        return nomor;
    }
}
