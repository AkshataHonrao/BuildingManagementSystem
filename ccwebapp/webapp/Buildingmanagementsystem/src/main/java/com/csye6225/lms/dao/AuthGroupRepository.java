package com.csye6225.lms.dao;

import com.csye6225.lms.auth.AuthGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AuthGroupRepository extends JpaRepository<AuthGroup, Long> {
    List<AuthGroup> findByUsername(String username);

    @Override
    <S extends AuthGroup> S saveAndFlush(S entity);
}
