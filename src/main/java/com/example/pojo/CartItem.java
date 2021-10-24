package com.example.pojo;

public class CartItem {

    private Integer id;
    private String name;
    private Integer count;
    private Integer price;
    private Integer total;

    public CartItem(Integer id, String name, Integer count, Integer price, Integer total) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.price = price;
        this.total = total;
    }

    public CartItem() {

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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", price=" + price +
                ", total=" + total +
                '}';
    }
}
