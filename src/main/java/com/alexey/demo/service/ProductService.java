package com.alexey.demo.service;

import com.alexey.demo.entity.Product;


import java.util.List;

public interface ProductService {
    public List<Product> getProducts();

    public void saveProduct(Product theProduct);

    public Product getProduct(long theId);

    public void deleteProduct(long theId);

    public List<Product> searchProduct(String theProductName);
}
