package Esun.demo.service.Impl;

import Esun.demo.model.Product;
import Esun.demo.repository.ProductRepository;
import Esun.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    // Repository
    @Autowired
    private ProductRepository productRepository;


    // Add Product
    @Override
    public Product addProduct(Product product){
        //System.out.println("Name " + product.getProduct_Name());
        //System.out.println("NO " + product.getNo());
        try {
            Product check = productRepository.findById(product.getNo()).get();
            // primary in database, do not let user add
            check.setProduct_Name(null);
            return check;
        }
        catch (Exception e){
            return productRepository.save(product);
        }
    }


    // Query
    @Override
    public Product getProductByNo(String no) {
        return productRepository.findById(no).get();
    }


    // Menu
    @Override
    public List<Product> getProducts() {
        return (List<Product>)productRepository.findAll();
    }


   // Delete
    @Override
    public void deleteProduct(String no){
        productRepository.deleteById(no);
    }

    // Update
    @Override
    public Product updateProduct(Product product){
        return productRepository.save(product);
    }

}
