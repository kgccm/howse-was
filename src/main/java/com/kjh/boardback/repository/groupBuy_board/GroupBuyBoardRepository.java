package com.kjh.boardback.repository.groupBuy_board;

import com.kjh.boardback.entity.board.BoardEntity;
import com.kjh.boardback.entity.groupBuy_board.GroupBuyBoardEntity;
import com.kjh.boardback.repository.resultSet.GetBoardResultSet;
import com.kjh.boardback.repository.resultSet.GetGroupBuyBoardResultSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupBuyBoardRepository extends JpaRepository<GroupBuyBoardEntity, Integer> {

    @Query(
            value =
                    "SELECT " +
                            "B.board_number AS boardNumber, " +
                            "B.title AS title, " +
                            "B.content AS content, " +
                            "B.write_datetime AS writeDatetime, " +
                            "B.writer_email AS writerEmail, " +
                            "U.nickname AS writerNickname, " +
                            "U.profile_image AS writerProfileImage, " +
                            "B.participation_area AS participationArea, " +
                            "B.original_price AS originalPrice, " +
                            "B.groupbuy_price AS groupbuyPrice " +
                            "FROM groupbuy_board AS B " +
                            "INNER JOIN `user` AS U ON B.writer_email = U.email " +
                            "WHERE board_number = ?1 ",
            nativeQuery = true
    )
    GetGroupBuyBoardResultSet getBoard(Integer boardNumber);

    GroupBuyBoardEntity findByBoardNumber(Integer boardNumber);

    Boolean existsByBoardNumber(Integer boardNumber);
}
