package com.example.cuoi_ki.Model;

public class Police {
    private int id;
    private String name;
    private String adrress;
    private String country;
    private int image;
    private int rate;
    private String level;

    public Police() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdrress() {
        return adrress;
    }

    public void setAdrress(String adrress) {
        this.adrress = adrress;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public Police(int id, String name, String adrress, String country, int rate, int image, String level) {
        this.id = id;
        this.name = name;
        this.adrress = adrress;
        this.country = country;
        this.image = image;
        this.rate = rate;
        this.level = level;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
