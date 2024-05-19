package com.kjh.boardback.repository.recipe_board;

import com.kjh.boardback.entity.recipe_board.RecipeImageEntity;
import com.kjh.boardback.entity.trade_board.TradeImageEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface RecipeImageRepository extends JpaRepository<RecipeImageEntity, Integer> {

    List<RecipeImageEntity> findByBoardNumber(Integer boardNumber);

    @Transactional
    void deleteByBoardNumber(Integer boardNumber);

}
