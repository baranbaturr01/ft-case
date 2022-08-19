package com.baranbatur.ftTechnology.controller;

import com.baranbatur.ftTechnology.model.ProductComment;
import com.baranbatur.ftTechnology.service.ProductCommentService;
import org.hibernate.dialect.SybaseAnywhereDialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/product-comment")
public class ProductCommentController {

    @Autowired
    ProductCommentService productCommentService;

    @PostMapping(value = "/save", produces = {"application/json"})
    public boolean saveProductComment(@RequestBody ProductComment productComment) throws Exception {

//set comment date to current date
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sdf.format(new Date());
        productComment.setCommentDate(sdf.parse(currentDate));
        productCommentService.saveProductComment(productComment);
        return true;
    }

    @PostMapping("/findByProductId")
    public List<ProductComment> findByProductId(@RequestBody Long product_id) {
        return productCommentService.findByProductId(product_id);
    }

    @PostMapping("/findByProductIdAndCommentDateBetween")
    public List<ProductComment> findByProductIdAndCommentDateBetween(@RequestBody Long product_id, @RequestBody Date start_date, @RequestBody Date end_date) {
        return productCommentService.findByProductIdAndCommentDateBetween(product_id, start_date, end_date);
    }

    @PostMapping("/findByUserId")
    public List<ProductComment> findByUserId(@RequestBody Long user_id) {
        return productCommentService.findByUserId(user_id);
    }

    @PostMapping("/findByUserIdAndCommentDateBetween")
    public List<ProductComment> findByUserIdAndCommentDateBetween(@RequestBody Long user_id, @RequestBody Date start_date, @RequestBody Date end_date) {
        return productCommentService.findByUserIdAndCommentDateBetween(user_id, start_date, end_date);
    }

}
