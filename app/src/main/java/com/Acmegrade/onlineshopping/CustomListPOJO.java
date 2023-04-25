package com.Acmegrade.onlineshopping;

public class CustomListPOJO {
    int image;
    String company, item, price;

    public CustomListPOJO(int image, String company, String item, String price) {
        this.image = image;
        this.company = company;
        this.item = item;
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
