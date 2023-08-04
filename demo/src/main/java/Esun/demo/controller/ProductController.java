package Esun.demo.controller;

import Esun.demo.model.Product;
import Esun.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class ProductController {

    @Autowired
    private ProductService productService;

    // Add Product
    @PostMapping("/add_product")
    public String addProduct(@RequestBody Product product){
       /*
        System.out.println("Name " + product.getProduct_Name());
        System.out.println("NO " + product.getNo());
        System.out.println("price " + product.getPrice());
        System.out.println("fee rate " + product.getFee_Rate());
        */
        Product check = productService.addProduct(product);
        if(check.getProduct_Name() != null){
            return "ADD PRODUCT SUCCESSFULLY";
        }
        else{
            return "TYPE SOMETHING WRONG OR ALREADY HAVE PRODUCT";
        }
    }

    // Query
    @RequestMapping("/product/{no}")
    public Product getProductByNo(@PathVariable("no") String no){
        return productService.getProductByNo(no);
    }

    // Show For User
    @RequestMapping("/products")
    public List<Product> getProducts(){
        return productService.getProducts();
    }


    // Delete
    @DeleteMapping("/product/{no}")
    public void deleteProduct(@PathVariable("no") String no){
        productService.deleteProduct(no);
    }

    // Update Product
    @PutMapping("/product_update")
    public Product updateProduct(@RequestBody Product product){
        return productService.updateProduct(product);
    }


}
