package com.baranbatur.ftTechnology.service;

import com.baranbatur.ftTechnology.model.Product;
import com.baranbatur.ftTechnology.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> findByExpiredDate(Date nowDate) {
        return productRepository.findByExpiredDate(nowDate);
    }

    public List<Product> findByNotExpireDate(Date nowDate) {
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
