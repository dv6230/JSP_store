package com.example.dao.imp;

import com.example.dao.ProductDao;
import com.example.pojo.Product;
import org.apache.commons.dbutils.QueryRunner;

import java.util.List;

public class ProductDaoImp extends BaseDao implements ProductDao {
    @Override
    public int addProduct(Product product) {
        String sql = "INSERT INTO `t_product` " +
                "(`name`,`price`,`note`,`sales`,`stock`,`image_path`)" +
                " VALUES (?,?,?,?,?,?);";

        return Update(sql, product.getName(), product.getPrice(),
                product.getNote(), product.getSales(), product.getStock(),
                product.getimgPath());
    }

    @Override
    public int deleteProduct(int id) {
        String sql = "DELETE FROM `t_product` WHERE `t_product`.`id` = ?";
        return Update(sql, id);
    }

    @Override
    public int updateProduct(Product val) {
        String sql = "UPDATE `t_product` SET `name`=?,`price`=?,`note`=?,`sales`=?," +
                "`stock`=?,`image_path`=? WHERE `id` = ? ";
        return Update(sql, val.getName(), val.getPrice(), val.getNote(), val.getSales(),
                val.getStock(), val.getimgPath(), val.getId());
    }

    @Override
    public Product queryProductById(int id) {
        String sql = "SELECT `id`,`name`,`price`,`note`,`sales`,`stock` FROM `t_product` WHERE `id` = ? ";
        return QueryForOne(Product.class, sql, id);
    }

    @Override
    public List<Product> queryProducts() {
        String sql = "SELECT `id`,`name`,`price`,`note`,`sales`,`stock`,`image_path` imgPath FROM `t_product` WHERE 1=1 ";
        return QueryForList(Product.class, sql);
    }
}
