import com.example.dao.OrderItemDao;
import com.example.dao.imp.OrderItemDaoImp;
import com.example.pojo.OrderItem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderItemDaoImpTest {

    OrderItemDao orderItemDao = new OrderItemDaoImp();

    @Test
    void saveOrderItem() {
        OrderItem item = new OrderItem();
        item.setName("番茄熱狗");
        item.setPrice(60);
        item.setCount(1);
        item.setTotalPrice(60);
        item.setOrderId("Test-001");
        System.out.println(orderItemDao.saveOrderItem(item));
    }
}