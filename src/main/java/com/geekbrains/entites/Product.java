package com.geekbrains.entites;

public class Product {
    private int id;
    private String title;
    private int cost;

    public Product(int id, String title, int cost) {
        this.id = id;
        this.title = title;
        this.cost = cost;
    }

    public Product() {
        this.id = -1;
        this.title = "";
        this.cost = 0;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle(){
        return this.title;
    }

    public int getId(){
        return this.id;
    }

    public int getCost(){
        return this.cost;
    }
}
