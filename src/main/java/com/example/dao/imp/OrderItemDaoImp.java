package com.example.dao.imp;

import com.example.dao.OrderItemDao;
import com.example.pojo.OrderItem;

public class OrderItemDaoImp extends BaseDao implements OrderItemDao {
    @Override
    public int saveOrderItem(OrderItem orderItem) {
        String sql = "INSERT INTO `t_order_item` (`name`, `count`, `price`, `total_price`, `order_id`) VALUES (?,?,?,?,?)";
        return Update(sql, orderItem.getName(), orderItem.getCount(), orderItem.getPrice(), orderItem.getTotalPrice(), orderItem.getOrderId());
    }
}
