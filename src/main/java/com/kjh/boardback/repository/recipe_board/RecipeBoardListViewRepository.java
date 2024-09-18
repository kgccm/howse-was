package com.kjh.boardback.repository.recipe_board;

import com.kjh.boardback.entity.recipe_board.RecipeBoardListViewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RecipeBoardListViewRepository extends JpaRepository<RecipeBoardListViewEntity, Integer> {


    @Query(value = "SELECT * FROM recipe_board_list_view "+
            "WHERE type = ?1 "+
            "ORDER BY write_datetime DESC",nativeQuery = true
    )
    List<RecipeBoardListViewEntity> findByOrderByWriteDatetimeDesc(int type);


    // List<RecipeBoardListViewEntity> findTop3ByWriteDatetimeGreaterThanOrderByFavoriteCountDescCommentCountDescViewCountDescWriteDatetimeDesc(String writeDateTime);
    @Query(value = "SELECT * FROM recipe_board_list_view " +
            "WHERE write_datetime > ?1 AND type = ?2 " +
            "ORDER BY favorite_count DESC, comment_count DESC, " +
            "view_count DESC, write_datetime DESC " +
            "LIMIT 3", nativeQuery = true)
    List<RecipeBoardListViewEntity> getTop3BoardList(String writeDateTime,int type);

    // List<RecipeBoardListViewEntity> findByTitleContainsOrContentContainsOrderByWriteDatetimeDesc(String title,String content);
    @Query(value =
            "SELECT * FROM recipe_board_list_view " +
                    "WHERE title LIKE %?1% OR content LIKE %?2% " +
                    "ORDER BY write_datetime DESC ",
            nativeQuery = true
    )
    List<RecipeBoardListViewEntity> getSearchBoardList(String title, String content);

    List<RecipeBoardListViewEntity> findByWriterEmailOrderByWriteDatetimeDesc(String writerEmail);

}
