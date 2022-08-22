package com.baranbatur.ftTechnology.controller;

import com.baranbatur.ftTechnology.model.Product;
import com.baranbatur.ftTechnology.model.ProductComment;
import com.baranbatur.ftTechnology.model.User;
import com.baranbatur.ftTechnology.service.ProductCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.init.ResourceReader;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/product-comment")
public class ProductCommentController {

    @Autowired
    ProductCommentService productCommentService;

    @PostMapping(value = "/save/{productId}/{userId}", produces = {"application/json"})
    public boolean saveProductComment(@PathVariable(value = "productId") Long productId, @PathVariable(value = "userId") Long userId, @RequestBody ProductComment productComment) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sdf.format(new Date());
        productComment.setCommentDate(sdf.parse(currentDate));

        Product product = new Product();
        product.setId(productId);
        productComment.setProduct(product);
        User user = new User();
        user.setId(userId);
        productComment.setUser(user);

        productCommentService.saveProductComment(productComment);
        return true;
    }

    @GetMapping(value = "/findByProductId/{productId}", produces = {"application/json"})
    public List<Object> findByProductId(@PathVariable(value = "productId") Long productId) {

        List<ProductComment> productComments = productCommentService.findByProductId(productId);
        List<Object> productCommentsObject = new ArrayList<>();
        for (ProductComment productComment : productComments) {
            Map<String, Object> productCommentObject = new HashMap<>();
            productCommentObject.put("id", productComment.getId());
            productCommentObject.put("comment", productComment.getComment());
            productCommentObject.put("commentDate", productComment.getCommentDate());
            productCommentObject.put("product", productComment.getProduct().getName());
            productCommentObject.put("user", productComment.getUser().getName());
            productCommentsObject.add(productCommentObject);
        }

        return ResponseEntity.ok().body(productCommentsObject).getBody();
    }

    @GetMapping(value = "/findByProductIdAndCommentDateBetween/{productId}/{startDate}/{endDate}", produces = {"application/json"})
    public List<Object> findByProductIdAndCommentDateBetween(@PathVariable(value = "productId") Long productId, @PathVariable(value = "startDate") String startDate, @PathVariable(value = "endDate") String endDate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date startDateDate = sdf.parse(startDate);
        Date endDateDate = sdf.parse(endDate);
        List<ProductComment> productComments = productCommentService.findByProductIdAndCommentDateBetween(productId, startDateDate, endDateDate);
        List<Object> productCommentsObject = new ArrayList<>();
        for (ProductComment productComment : productComments) {
            Map<String, Object> productCommentObject = new HashMap<>();
            productCommentObject.put("id", productComment.getId());
            productCommentObject.put("comment", productComment.getComment());
            productCommentObject.put("commentDate", productComment.getCommentDate());
            productCommentObject.put("product", productComment.getProduct().getName());
            productCommentObject.put("user", productComment.getUser().getName());
            productCommentsObject.add(productCommentObject);
        }

        return ResponseEntity.ok().body(productCommentsObject).getBody();
    }

    @GetMapping("/findCommentsByUserId/{userId}")
    public List<Object> findByUserId(@PathVariable Long userId) {
        List<ProductComment> productComments = productCommentService.findByUserId(userId);
        List<Object> productCommentsObject = new ArrayList<>();
        for (ProductComment productComment : productComments) {
            Map<String, Object> productCommentObject = new HashMap<>();
            productCommentObject.put("product_id", productComment.getProduct().getId());
            productCommentObject.put("comment", productComment.getComment());
            productCommentObject.put("commentDate", productComment.getCommentDate());
            productCommentObject.put("product", productComment.getProduct().getName());
            productCommentsObject.add(productCommentObject);
        }

        return ResponseEntity.ok().body(productCommentsObject).getBody();
    }

    @GetMapping("/findCommentsByUserIdAndCommentDateBetween/{userId}/{startDate}/{endDate}")
    public List<Object> findByUserIdAndCommentDateBetween(@PathVariable(value = "userId") Long userId, @PathVariable(value = "startDate") String startDate, @PathVariable(value = "endDate") String endDate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date startDateDate = sdf.parse(startDate);
        Date endDateDate = sdf.parse(endDate);
        List<ProductComment> productComments = productCommentService.findByUserIdAndCommentDateBetween(userId, startDateDate, endDateDate);
        List<Object> productCommentsObject = new ArrayList<>();
        for (ProductComment productComment : productComments) {
            Map<String, Object> productCommentObject = new HashMap<>();
            productCommentObject.put("product_id", productComment.getProduct().getId());
            productCommentObject.put("comment", productComment.getComment());
            productCommentObject.put("commentDate", productComment.getCommentDate());
            productCommentObject.put("product", productComment.getProduct().getName());
            productCommentsObject.add(productCommentObject);
        }

        return ResponseEntity.ok().body(productCommentsObject).getBody();
    }

}
