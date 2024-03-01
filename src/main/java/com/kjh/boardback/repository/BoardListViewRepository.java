package com.kjh.boardback.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kjh.boardback.entity.BoardListViewEntity;

import jakarta.persistence.Entity;

@Entity
public interface BoardListViewRepository extends JpaRepository<BoardListViewEntity, Integer> {
    
}
