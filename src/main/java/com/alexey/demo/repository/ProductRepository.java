package com.alexey.demo.repository;

import com.alexey.demo.entity.Product;

import java.util.List;

public interface ProductRepository {

    List<Product> getProducts();

    void saveProduct(Product theProduct);

    Product getProduct(long theId);

    void deleteProduct(long theId);

    List<Product> searchProduct(String theNameProduct);






}
