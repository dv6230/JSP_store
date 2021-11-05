package com.example.pojo;

public class Product {

    private Integer id;
    private String name;
    private String note;
    private Integer price;
    private Integer sales;
    private Integer stock;
    private String imgPath = "";

    public Product(Integer id, String name, String note, Integer price, Integer sales, Integer stock, String imgPath) {
        this.id = id;
        this.name = name;
        this.note = note;
        this.price = price;
        this.sales = sales;
        this.stock = stock;
//        this.imgPath = imgPath;
        if (imgPath != null && imgPath.length() > 0) {
            this.imgPath = imgPath;
        }
    }

    public Product() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getimgPath() {
        return imgPath;
    }

    public void setimgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", note='" + note + '\'' +
                ", price=" + price +
                ", sales=" + sales +
                ", stock=" + stock +
                ", imgPath='" + imgPath + '\'' +
                '}';
    }
}
