package com.kjh.boardback.repository.groupBuy_board;

import com.kjh.boardback.entity.board.ImageEntity;
import com.kjh.boardback.entity.groupBuy_board.GroupBuyImageEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface GroupBuyImageRepository extends JpaRepository<GroupBuyImageEntity, Integer>{

    List<GroupBuyImageEntity> findByBoardNumber(Integer boardNumber);

    @Transactional
    void deleteByBoardNumber(Integer boardNumber);
    
}
