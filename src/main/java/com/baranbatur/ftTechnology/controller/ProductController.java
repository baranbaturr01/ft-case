package com.baranbatur.ftTechnology.controller;

import com.baranbatur.ftTechnology.model.Product;
import com.baranbatur.ftTechnology.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    private final Date currentDate = sdf.parse(sdf.format(new Date()));

    public ProductController() throws ParseException {
    }

    @PostMapping(value = "/save", produces = {"application/json"})
    public boolean saveProduct(@RequestBody Product product) throws Exception {
        productService.saveProduct(product);
        return true;
    }

    @GetMapping(value = "/findByExpiredDate", produces = {"application/json"})
    public List<Product> findByExpiredDate() {
        return productService.findByExpiredDate(this.currentDate);
    }

    @GetMapping(value = "/findByNotExpireDate", produces = {"application/json"})
    public List<Product> findByNotExpireDate() {
        return productService.findByNotExpireDate(this.currentDate);
    }

    @PostMapping(value = "/findAll", produces = {"application/json"})
    public List<Product> findAll() {
        return productService.findAll();
    }
}
