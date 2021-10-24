package pojo;

import com.example.pojo.Cart;
import com.example.pojo.CartItem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {

    Cart cart = new Cart();

    @Test
    void addItem() {
        cart.addItem(new CartItem(10,"圖書館",200,0,0));
        cart.addItem(new CartItem(11,"圖書館",200,0,0));
        System.out.println(cart);
    }

    @Test
    void deleteItem() {
        cart.addItem(new CartItem(10,"圖書84",15,70,0));
        cart.addItem(new CartItem(11,"圖書12",3,20,0));
        cart.deleteItem(11);
        System.out.println(cart);
    }

    @Test
    void clear() {
        cart.addItem(new CartItem(14,"圖書",7,30,0));
        cart.addItem(new CartItem(10,"圖書",1,164,0));
        cart.clear();
        System.out.println(cart);
    }

    @Test
    void updateCount() {
        cart.addItem(new CartItem(14,"圖書",7,30,0));
        cart.addItem(new CartItem(10,"圖書",1,164,0));
        cart.updateCount(10,3);
        System.out.println(cart);
        System.out.println(cart.getTotalPrice());
    }

}