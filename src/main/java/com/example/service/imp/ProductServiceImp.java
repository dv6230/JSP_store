package com.example.service.imp;

import com.example.dao.ProductDao;
import com.example.dao.imp.ProductDaoImp;
import com.example.pojo.Product;
import com.example.service.ProductService;

import java.util.List;

public class ProductServiceImp implements ProductService {

    private ProductDao productDao = new ProductDaoImp();

    @Override
    public void addProduct(Product product) {
        productDao.addProduct(product);
    }

    @Override
    public void deleteProduct(int id) {
        productDao.deleteProduct(id);
    }

    @Override
    public void updateProduct(Product product) {
        productDao.updateProduct(product);
    }

    @Override
    public Product queryProductById(int id) {
        return productDao.queryProductById(id);
    }

    @Override
    public List<Product> queryProduct() {
        return productDao.queryProducts();
    }

    public List<Product> page(int pageNo,int pageSize){
        return null;
    }

}
