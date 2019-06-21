package com.example.genericmed.model;

public class Med {

    private String name ;
    private String Description;
    private String rating;
    private int nb_episode;
    private String company;
    private String price ;
    private String image_url;

    public Med(){

    }

    public Med(String name, String description, String rating, int nb_episode, String company, String price, String image_url) {
        this.name = name;
        Description = description;
        this.rating = rating;
        this.nb_episode = nb_episode;
        this.company = company;
        this.price = price;
        this.image_url = image_url;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return Description;
    }

    public String getRating() {
        return rating;
    }

    public int getNb_episode() {
        return nb_episode;
    }

    public String getCompany() {
        return company;
    }

    public String getPrice() {
        return price;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setNb_episode(int nb_episode) {
        this.nb_episode = nb_episode;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

}