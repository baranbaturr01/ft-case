package com.baranbatur.ftTechnology.repository;

import com.baranbatur.ftTechnology.model.ProductComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ProductCommentRepository extends JpaRepository<ProductComment, Long> {

    public List<ProductComment> findByProductId(Long productId);

    @Query(value = "SELECT * FROM product_comments WHERE product_id = ?1 AND comment_date BETWEEN ?2 AND ?3", nativeQuery = true)
    public List<ProductComment> findByProductIdAndCommentDateBetween(Long productId, Date startDate, Date endDate);

    public List<ProductComment> findByUserId(Long userId);

    @Query(value = "SELECT * FROM product_comments WHERE user_id = ?1 AND comment_date BETWEEN ?2 AND ?3", nativeQuery = true)
    public List<ProductComment> findByUserIdAndCommentDateBetween(Long userId, Date startDate, Date endDate);

}