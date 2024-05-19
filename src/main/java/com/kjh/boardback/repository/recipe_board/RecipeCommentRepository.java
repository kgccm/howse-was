package com.kjh.boardback.repository.recipe_board;

import com.kjh.boardback.entity.recipe_board.RecipeCommentEntity;
import com.kjh.boardback.entity.trade_board.TradeCommentEntity;
import com.kjh.boardback.repository.resultSet.GetRecipeCommentListResultSet;
import com.kjh.boardback.repository.resultSet.GetTradeCommentListResultSet;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeCommentRepository extends JpaRepository<RecipeCommentEntity, Integer> {

    @Query(value =
            "SELECT " +
                    "U.nickname AS nickname, " +
                    "U.profile_image AS profileImage, " +
                    "C.write_datetime AS writeDatetime, " +
                    "C.content AS content " +
                    "FROM recipe_comment AS C " +
                    "INNER JOIN `user` AS U " +
                    "ON C.user_email = U.email " +
                    "WHERE C.board_number = ? " +
                    "ORDER BY write_datetime DESC ",
            nativeQuery = true
    )
    List<GetRecipeCommentListResultSet> getCommentList(int boardNumber);

    @Transactional
    void deleteByBoardNumber(Integer boardNumber);
}
