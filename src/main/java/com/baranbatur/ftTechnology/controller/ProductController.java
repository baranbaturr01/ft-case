package com.baranbatur.ftTechnology.controller;

import com.baranbatur.ftTechnology.model.Product;
import com.baranbatur.ftTechnology.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private final String nowDate = this.sdf.format(new java.util.Date());

    @PostMapping(value = "/save", produces = {"application/json"})
    public boolean saveProduct(@RequestBody Product product) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            sdf.parse(product.getExpirationDate());
        } catch (Exception e) {
            //return error message
            return false;
        }
        productService.saveProduct(product);
        return true;
    }

    @GetMapping(value = "/findByExpiredDate", produces = {"application/json"})
    public List<Product> findByExpiredDate() {
        return productService.findByExpiredDate(this.nowDate);
    }

    @GetMapping(value = "/findByNotExpireDate", produces = {"application/json"})
    public List<Product> findByNotExpireDate() {
        return productService.findByNotExpireDate(this.nowDate);
    }

    @PostMapping(value = "/findAll", produces = {"application/json"})
    public List<Product> findAll() {
        return productService.findAll();
    }
}
