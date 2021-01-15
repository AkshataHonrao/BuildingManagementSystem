package com.example.rentalapp.respositories;

import com.example.rentalapp.models.AuthGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.math.BigInteger;

@Repository
public interface AuthGroupRepository extends JpaRepository<AuthGroup, Long> {
    List<AuthGroup> findByUsername(String userName);
    @Override
    <S extends AuthGroup> S saveAndFlush(S entity);
}

