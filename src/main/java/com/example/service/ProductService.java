package com.example.service;

import com.example.pojo.Product;

import java.util.List;

public interface ProductService {
    void addProduct(Product product);

    void deleteProduct(int id);

    void updateProduct(Product product);

    Product queryProductById(int id);

    List<Product> queryProduct();
}
