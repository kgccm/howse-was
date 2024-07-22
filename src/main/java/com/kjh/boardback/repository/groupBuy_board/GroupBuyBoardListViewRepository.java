package com.kjh.boardback.repository.groupBuy_board;

import com.kjh.boardback.entity.groupBuy_board.GroupBuyBoardListViewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface GroupBuyBoardListViewRepository extends JpaRepository<GroupBuyBoardListViewEntity, Integer> {


    List<GroupBuyBoardListViewEntity> findByOrderByWriteDatetimeDesc();


    // List<BoardListViewEntity> findTop3ByWriteDatetimeGreaterThanOrderByFavoriteCountDescCommentCountDescViewCountDescWriteDatetimeDesc(String writeDateTime);
    @Query(value = "SELECT * FROM groupbuy_board_list_view " +
            "WHERE write_datetime > ?1 " +
            "ORDER BY favorite_count DESC, comment_count DESC, " +
            "view_count DESC, write_datetime DESC " +
            "LIMIT 3", nativeQuery = true)
    List<GroupBuyBoardListViewEntity> getTop3BoardList(@Param("writeDateTime") String writeDateTime);

    // List<BoardListViewEntity> findByTitleContainsOrContentContainsOrderByWriteDatetimeDesc(String title,String content);
    @Query(value =
            "SELECT * FROM groupbuy_board_list_view " +
                    "WHERE title LIKE %?1% OR content LIKE %?2% " +
                    "ORDER BY write_datetime DESC ",
            nativeQuery = true
    )
    List<GroupBuyBoardListViewEntity> getSearchBoardList(String title, String content);

    List<GroupBuyBoardListViewEntity> findByWriterEmailOrderByWriteDatetimeDesc(String writerEmail);

}
