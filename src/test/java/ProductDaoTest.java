import com.example.dao.ProductDao;
import com.example.dao.imp.ProductDaoImp;
import com.example.pojo.Product;
import org.junit.Test;

import java.util.List;

public class ProductDaoTest {

    ProductDaoImp PD = new ProductDaoImp();
    Product product = new Product(null, "希苓雞湯", "好吃多汁", 50, 0, 100, "path");

    @Test
    public void addProduct() {
        Object obj = PD.addProduct(product);
    }

    @Test
    public void deleteProduct() {
        Object obj = PD.deleteProduct(10);
    }

    @Test
    public void updateProduct() {
        product.setSales(product.getSales() + 1);
        product.setStock(product.getStock() - 1);
        product.setId(11);
        Object obj = PD.updateProduct(product);
        System.out.println(obj);
    }

    @Test
    public void queryBookById() {
        Product obj = PD.queryProductById(2);
        System.out.println(obj);
    }

    @Test
    public void queryBooks() {
        Object obj = PD.queryProducts();
        System.out.println(obj);
    }

    @Test
    void queryForPageTotalCount() {
        System.out.println(PD.queryForPageTotalCount());
    }

    @Test
    void queryForItem() {
        List<Product> items = PD.queryForItem(0, 5);
        for (Product item : items) {
            System.out.println(item);
        }
    }

}
