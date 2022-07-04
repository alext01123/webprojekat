package com.example.repository;

import com.example.entity.Artikal;
import com.example.entity.Komentar;
import com.example.entity.Restoran;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ArtikalRepository extends JpaRepository<Artikal, Long> {
    public Artikal getById(Long id);
}
