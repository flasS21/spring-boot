package com.code4fun.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.code4fun.app.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
