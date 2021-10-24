package com.example.pojo;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Cart {

    private Map<Integer, CartItem> cartList = new HashMap<Integer, CartItem>();

    public void addItem(CartItem cartItem) {
        CartItem item = cartList.get(cartItem.getId());
        if (item == null) {
            cartList.put(cartItem.getId(), cartItem);

        } else {
            item.setCount(item.getCount() + 1);
            item.setTotal(item.getCount() * item.getPrice());
        }
    }

    public void deleteItem(Integer id) {
        cartList.remove(id);
    }

    public void clear() {
        cartList.clear();
    }

    public void updateCount(int id, int count) {
        CartItem item = cartList.get(id);
        if (item != null) {
            item.setCount(count);
            item.setTotal(item.getCount() * item.getPrice());
        }
    }

    public Cart() {
    }

    public Cart(Map<Integer, CartItem> cartList) {
        this.cartList = cartList;
    }

    public Map<Integer, CartItem> getCartList() {
        return cartList;
    }

    public void setCartList(Map<Integer, CartItem> cartList) {
        this.cartList = cartList;
    }

    public Integer getProductCount() {
        int totalCount = 0;
        for (Map.Entry<Integer, CartItem> entry : this.cartList.entrySet()) {
            totalCount += entry.getValue().getCount();
        }
        return totalCount;
    }

    public Integer getTotalPrice() {
        int totalPrice = 0;
        for (CartItem item : this.cartList.values()) {
            totalPrice += item.getCount() * item.getPrice();
        }
        return totalPrice;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartList=" + cartList +
                '}';
    }
}
