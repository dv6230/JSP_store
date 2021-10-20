import com.example.pojo.Page;
import com.example.pojo.Product;
import com.example.service.ProductService;
import com.example.service.imp.ProductServiceImp;
import org.junit.jupiter.api.Test;

import static com.example.pojo.Page.PAGE_SIZE;
import static org.junit.jupiter.api.Assertions.*;

class ProductServiceImpTest {

    ProductService productService = new ProductServiceImp();

    @Test
    void addProduct() {
        productService.addProduct(new Product(null, "合金卡丁車", "超快跑跑卡丁車", 900, 10, 21, ""));
    }

    @Test
    void deleteProduct() {
        productService.deleteProduct(12);
    }

    @Test
    void updateProduct() {
        productService.updateProduct(new Product(12, "競速卡丁車", "超快跑跑卡丁車", 900, 10, 21, ""));
    }

    @Test
    void queryProductById() {
        System.out.println(productService.queryProductById(2));
    }

    @Test
    void queryProduct() {
        System.out.println(productService.queryProduct());
    }

    @Test
    void page() {
        System.out.println(productService.page(1, PAGE_SIZE));
    }

}