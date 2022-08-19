package com.baranbatur.ftTechnology.repository;

import com.baranbatur.ftTechnology.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "SELECT * FROM products WHERE expire_date < ?1", nativeQuery = true)
    public List<Product> findByExpiredDate(String nowDate);

    //son kullanma tarihi geçmemiş olanları listele
    @Query(value = "SELECT * FROM products WHERE expiration_date > ?1", nativeQuery = true)
    public List<Product> findByNotExpireDate(String nowDate);
}
