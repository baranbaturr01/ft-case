package com.baranbatur.ftTechnology.service;

import com.baranbatur.ftTechnology.model.Product;
import com.baranbatur.ftTechnology.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> findByExpiredDate(String nowDate) {
        return productRepository.findByExpiredDate(nowDate);
    }

    public List<Product> findByNotExpireDate(String nowDate) {
        return productRepository.findByNotExpireDate(nowDate);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    //save
    public void saveProduct(Product product) {
        productRepository.save(product);
    }


}
