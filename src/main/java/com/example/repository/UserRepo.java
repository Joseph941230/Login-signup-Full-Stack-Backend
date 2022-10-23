package com.example.repository;


import com.example.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
//这个来查数据库
    User findUserByPhone(String phone);

    User findUserByEmail(String email);


}
