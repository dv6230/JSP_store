package com.example.dao.imp;

import com.example.dao.OrderDao;
import com.example.pojo.Order;

public class OrderDaoImp extends BaseDao implements OrderDao {
    @Override
    public int saveOrder(Order order) {
        String sql = "INSERT INTO `t_order`(`order_id`,`create_time`,`price`," +
                "`status`,`user_id`) " +
                "VALUES (?,?,?,?,?)";
        return Update(sql, order.getOrderId(), order.getCreateTime(),
                order.getPrice(), order.getStatus(), order.getUserId());
    }
}
