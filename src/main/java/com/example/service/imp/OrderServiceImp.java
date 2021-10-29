package com.example.service.imp;

import com.example.dao.OrderDao;
import com.example.dao.OrderItemDao;
import com.example.dao.ProductDao;
import com.example.dao.imp.OrderDaoImp;
import com.example.dao.imp.OrderItemDaoImp;
import com.example.dao.imp.ProductDaoImp;
import com.example.pojo.*;
import com.example.service.OrderService;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class OrderServiceImp implements OrderService {

    private OrderDao orderDao = new OrderDaoImp();
    private OrderItemDao orderItemDao = new OrderItemDaoImp();

    @Override
    public String createOrder(Cart cart, int userId) {

        String orderId = System.currentTimeMillis() + "" + userId;
        Order order = new Order(orderId, new Date(), cart.getTotalPrice(), 0, userId);
        orderDao.saveOrder(order);

        ProductDao productDao = new ProductDaoImp();

        for (CartItem item : cart.getCartList().values()) {
            OrderItem orderItem = new OrderItem(null, item.getName(), item.getCount(), item.getPrice(), item.getTotal(), orderId);
            orderItemDao.saveOrderItem(orderItem);
            Product product = productDao.queryProductById(item.getId());
            product.setSales(product.getSales()+item.getCount());
            product.setStock(product.getStock()-item.getCount());
            productDao.updateProduct(product);
        }

        cart.clear();

        return orderId;
    }

}
