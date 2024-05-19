package com.kjh.boardback.repository.recipe_board;

import com.kjh.boardback.entity.recipe_board.RecipeBoardEntity;
import com.kjh.boardback.entity.trade_board.TradeBoardEntity;
import com.kjh.boardback.repository.resultSet.GetRecipeBoardResultSet;
import com.kjh.boardback.repository.resultSet.GetTradeBoardResultSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeBoardRepository extends JpaRepository<RecipeBoardEntity, Integer> {

    @Query(
            value =
                    "SELECT " +
                            "B.board_number AS boardNumber, " +
                            "B.title AS title, " +
                            "B.content AS content, " +
                            "B.write_datetime AS writeDatetime, " +
                            "B.writer_email AS writerEmail, " +
                            "B.trade_location AS tradeLocation, " +
                            "U.nickname AS writerNickname, " +
                            "U.profile_image AS writerProfileImage " +
                            "FROM recipe_board AS B " +
                            "INNER JOIN `user` AS U ON B.writer_email = U.email " +
                            "WHERE board_number = ?1 ",
            nativeQuery = true
    )
    GetRecipeBoardResultSet getRecipeBoard(Integer boardNumber);

    RecipeBoardEntity findByBoardNumber(Integer boardNumber);

    Boolean existsByBoardNumber(Integer boardNumber);
}
