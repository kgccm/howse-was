package com.kjh.boardback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.kjh.boardback.entity.BoardListViewEntity;

import java.util.List;


@Repository
public interface BoardListViewRepository extends JpaRepository<BoardListViewEntity, Integer> {


    List<BoardListViewEntity> findByOrderByWriteDatetimeDesc();

    // 게시물 top3 메서드 이름 너무 김 아래 네이티브 쿼리로 구현함
    List<BoardListViewEntity> findTop3ByWriteDatetimeGreaterThanOrderByFavoriteCountDescCommentCountDescViewCountDescWriteDatetimeDesc(String writeDateTime);

    @Query(value = "SELECT * FROM board_list_view " +
            "WHERE write_datetime > ?1 " +
            "ORDER BY favorite_count DESC, comment_count DESC, " +
            "view_count DESC, write_datetime DESC " +
            "LIMIT 3", nativeQuery = true)
    List<BoardListViewEntity> getTop3BoardList(@Param("writeDateTime") String writeDateTime);
    
}
