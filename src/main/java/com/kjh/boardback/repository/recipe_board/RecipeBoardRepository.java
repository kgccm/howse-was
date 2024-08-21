package com.kjh.boardback.repository.recipe_board;

import com.kjh.boardback.entity.recipe_board.RecipeBoardEntity;
import com.kjh.boardback.repository.resultSet.GetRecipeBoardResultSet;
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
                            "B.cooking_time AS cookingTime, " +
                            "B.step_1 AS step_1, " +
                            "B.step_2 AS step_2, " +
                            "B.step_3 AS step_3, " +
                            "B.step_4 AS step_4, " +
                            "B.step_5 AS step_5, " +
                            "B.step_6 AS step_6, " +
                            "B.step_7 AS step_7, " +
                            "B.step_8 AS step_8, " +
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
