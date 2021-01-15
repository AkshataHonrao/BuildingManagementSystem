package com.example.rentalapp.respositories;

import com.example.rentalapp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;
import java.math.BigInteger;

@Repository
public interface UserRepository extends JpaRepository<User,BigInteger> {
    User findUserByEmail(String email);
    User saveAndFlush(User user);
    //User findUserByUsername(String email);
}
