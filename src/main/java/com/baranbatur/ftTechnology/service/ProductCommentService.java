package com.baranbatur.ftTechnology.service;

import com.baranbatur.ftTechnology.model.ProductComment;
import com.baranbatur.ftTechnology.repository.ProductCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProductCommentService {

    @Autowired
    ProductCommentRepository productCommentRepository;

    public List<ProductComment> findByProductId(Long productId) {

        List<ProductComment> productComments = productCommentRepository.findByProductId(productId);
        return productComments;
    }

    public List<ProductComment> findByProductIdAndCommentDateBetween(Long productId, Date startDate, Date endDate) {
        return productCommentRepository.findByProductIdAndCommentDateBetween(productId, startDate, endDate);
    }

    public List<ProductComment> findByUserId(Long userId) {
        return productCommentRepository.findByUserId(userId);
    }

    public List<ProductComment> findByUserIdAndCommentDateBetween(Long userId, Date startDate, Date endDate) {
        return productCommentRepository.findByUserIdAndCommentDateBetween(userId, startDate, endDate);
    }

    public void saveProductComment(ProductComment productComment) {
        productCommentRepository.save(productComment);
    }
}
