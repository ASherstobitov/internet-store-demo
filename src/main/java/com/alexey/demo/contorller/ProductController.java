package com.alexey.demo.contorller;

import com.alexey.demo.entity.Product;
import com.alexey.demo.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {


    //    need to inject our customer service
    @Autowired
    private ProductService productService;



    @GetMapping("/list-products")
    public List<Product> listProducts() {
//        get Product form the service
        List<Product> products = productService.getProducts();
        return products;

    }


    @PostMapping("/saveProduct")
    public Product saveProduct(@ModelAttribute("product") Product theProduct) {
//        save our product using our service
        productService.saveProduct(theProduct);
        return productService.getProduct(theProduct.getId());
    }

    @GetMapping("/delete")
    public List<Product> delete(@RequestParam("productId") long theId) {
//        delete product
        productService.deleteProduct(theId);
        return productService.getProducts();
    }

    @GetMapping("/search")
    public List<Product> searchProducts(@RequestParam("theNameProduct") String theNameProduct) {

        // search customers from the service
        List<Product> theCustomers = productService.searchProduct(theNameProduct);

        return theCustomers;
    }


}

