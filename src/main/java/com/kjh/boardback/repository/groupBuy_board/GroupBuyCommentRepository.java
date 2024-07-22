package com.kjh.boardback.repository.groupBuy_board;

import com.kjh.boardback.entity.board.CommentEntity;
import com.kjh.boardback.entity.groupBuy_board.GroupBuyCommentEntity;
import com.kjh.boardback.repository.resultSet.GetCommentListResultSet;
import com.kjh.boardback.repository.resultSet.GetGroupBuyCommentListResultSet;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupBuyCommentRepository extends JpaRepository<GroupBuyCommentEntity, Integer>{

    @Query(value =
            "SELECT "+
                    "U.nickname AS nickname, "+
                    "U.profile_image AS profileImage, "+
                    "C.write_datetime AS writeDatetime, "+
                    "C.comment_number AS commentNumber, "+
                    "C.content AS content "+
            "FROM groupbuy_comment AS C "+
            "INNER JOIN `user` AS U "+
            "ON C.user_email = U.email "+
            "WHERE C.board_number = ? "+
            "ORDER BY write_datetime DESC ",
            nativeQuery = true
    )
    List<GetGroupBuyCommentListResultSet> getCommentList(int boardNumber);

    @Transactional
    void deleteByBoardNumber(Integer boardNumber);


    GroupBuyCommentEntity findByCommentNumber(Integer commentNUmber);

}
