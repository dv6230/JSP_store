package com.example.service.imp;

import com.example.dao.ProductDao;
import com.example.dao.imp.ProductDaoImp;
import com.example.pojo.Page;
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

    @Override
    public Page<Product> page(int pageNo, int pageSize) {
        Page<Product> page = new Page<Product>();

        page.setPageSize(pageSize);
        //總共有少筆資料
        Integer pageTotalCount = productDao.queryForPageTotalCount();
        page.setDataTotalCount(pageTotalCount);
        Integer pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize > 0) {
            pageTotal += 1;
        }
        //設定總共有幾頁
        page.setPageCount(pageTotal);
        if (pageNo > page.getPageCount()) {
            pageNo = page.getPageCount();
        }
        page.setPageNo(pageNo);
        int begin = (page.getPageNo() - 1) * pageSize;

        List<Product> items = productDao.queryForItem(begin, pageSize);
        page.setItems(items);
        return page;
    }


}
