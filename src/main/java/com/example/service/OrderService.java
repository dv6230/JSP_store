package com.example.service;

import com.example.pojo.Cart;
import com.example.pojo.User;

public interface OrderService {
    String createOrder(Cart cart, int user);
}
