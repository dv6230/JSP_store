import com.example.dao.OrderDao;
import com.example.dao.imp.OrderDaoImp;
import com.example.pojo.Order;
import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class OrderDaoImpTest {

    OrderDao orderDao = new OrderDaoImp();

    @Test
    void saveOrder() {
        Order order = new Order();
        order.setOrderId("Test-001");
        order.setCreateTime(new Date());
        order.setPrice(150);
        order.setStatus(1);
        order.setUserId(150);
        System.out.println(orderDao.saveOrder(order));
    }
}