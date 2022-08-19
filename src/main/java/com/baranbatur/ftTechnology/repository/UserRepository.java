package com.baranbatur.ftTechnology.repository;

import com.baranbatur.ftTechnology.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public User findByEmail(String email);

    public User findByNameOrEmail(String username, String email);

}
