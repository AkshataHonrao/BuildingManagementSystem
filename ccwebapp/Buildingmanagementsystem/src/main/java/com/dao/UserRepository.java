package com.dao;

import java.util.UUID;

import com.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, UUID>{
    User findByUsername(String username);
    User saveAndFlush(User user);
}
