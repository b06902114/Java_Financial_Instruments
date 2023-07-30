package Esun.demo.service;

import Esun.demo.model.Product;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface ProductService {
    public Product getProductByNo(String no);

    public List<Product> getProducts();

    public void deleteProduct(String no);

    public Product addProduct(Product product);

    public Product updateProduct(Product product);

}
