import com.example.dao.imp.ProductDaoImp;
import com.example.pojo.Cart;
import com.example.pojo.CartItem;
import com.example.pojo.Product;
import com.example.pojo.User;
import com.example.service.OrderService;
import com.example.service.imp.OrderServiceImp;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

    OrderService orderService = new OrderServiceImp();

    @Test
    void createOrder() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(44, "Lightning 對 USB 連接線 (1 公尺)", 1, 590, 590));
        Product product = new ProductDaoImp().queryProductById(35);
        int count = 2;
        CartItem item = new CartItem(product.getId(), product.getName(), count, product.getPrice(), product.getPrice() * count);
        cart.addItem(item);
        System.out.println(orderService.createOrder(cart, 2));
    }
}