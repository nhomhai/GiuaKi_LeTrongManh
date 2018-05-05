package com.letrongmanh.letrongmanh;

public class Coin {
    private String name;
    private String price;
    private String id;
    public Coin(){}
    public Coin(String name, String price, String id)
    {
        this.name=name;
        this.price=price;
        this.id=id;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
