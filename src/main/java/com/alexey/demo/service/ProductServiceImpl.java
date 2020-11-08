package com.alexey.demo.service;

import com.alexey.demo.entity.Product;
import com.alexey.demo.repository.ProductRepository;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    @Transactional
    public List<Product> getProducts() {
        return productRepository.getProducts();
    }

    @Override
    @Transactional
    public void saveProduct(Product theProduct) {
        productRepository.saveProduct(theProduct);
    }

    @Override
    @Transactional
    public Product getProduct(long theId) {
        Product product = productRepository.getProduct(theId);
        return product;
    }

    @Override
    @Transactional
    public void deleteProduct(long theId) {

        productRepository.deleteProduct(theId);
    }

    @Override
    @Transactional
    public List<Product> searchProduct(String theProductName) {

        return productRepository.searchProduct(theProductName);
    }


}
