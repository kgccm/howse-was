package com.kjh.boardback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kjh.boardback.entity.ImageEntity;

@Repository

public interface ImageRepository extends JpaRepository<ImageEntity, Integer>{
    
}
