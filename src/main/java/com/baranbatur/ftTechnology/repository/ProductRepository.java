package com.baranbatur.ftTechnology.repository;

import com.baranbatur.ftTechnology.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "SELECT * FROM products WHERE expiration_date < ?1", nativeQuery = true)
    List<Product> findByExpiredDate(Date nowDate);

    //or expiration_date null or expiration_date > ?1

    @Query(value = "SELECT * FROM products WHERE expiration_date is null or expiration_date > ?1 ", nativeQuery = true)
    public List<Product> findByNotExpireDate(Date nowDate);

}
