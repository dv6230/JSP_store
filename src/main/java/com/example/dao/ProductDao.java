package com.example.dao;

import com.example.pojo.Product;

import java.util.List;

public interface ProductDao {
    public int addProduct(Product product);

    public int deleteProduct(int id);

    public int updateProduct(Product product);

    public Product queryProductById(int id);

    public List<Product> queryProducts();

    public Integer queryForPageTotalCount();

    List<Product> queryForItem(int begin, int pageSize);
}
