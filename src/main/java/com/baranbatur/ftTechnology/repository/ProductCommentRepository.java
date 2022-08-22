package com.baranbatur.ftTechnology.repository;

import com.baranbatur.ftTechnology.model.ProductComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ProductCommentRepository extends JpaRepository<ProductComment, Long> {

    List<ProductComment> findByProductId(Long productId);

    List<ProductComment> findByProductIdAndCommentDateBetween(Long productId, Date startDate, Date endDate);

    List<ProductComment> findByUserId(Long userId);

    List<ProductComment> findByUserIdAndCommentDateBetween(Long userId, Date startDate, Date endDate);

}