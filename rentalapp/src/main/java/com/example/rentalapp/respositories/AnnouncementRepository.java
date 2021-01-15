package com.example.rentalapp.respositories;

import com.example.rentalapp.models.Announcements;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnnouncementRepository extends JpaRepository<Announcements,Long> {
    List<Announcements> findAll();

    @Override
    <S extends Announcements> S saveAndFlush(S entity);
}
