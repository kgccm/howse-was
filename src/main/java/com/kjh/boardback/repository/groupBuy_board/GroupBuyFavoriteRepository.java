package com.kjh.boardback.repository.groupBuy_board;

import com.kjh.boardback.entity.board.FavoriteEntity;
import com.kjh.boardback.entity.groupBuy_board.GroupBuyFavoriteEntity;
import com.kjh.boardback.entity.primaryKey.FavoritePk;
import com.kjh.boardback.entity.primaryKey.GroupBuyFavoritePk;
import com.kjh.boardback.repository.resultSet.GetFavoriteListResultSet;
import com.kjh.boardback.repository.resultSet.GetGroupBuyFavoriteListResultSet;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupBuyFavoriteRepository extends JpaRepository<GroupBuyFavoriteEntity, GroupBuyFavoritePk> {

    GroupBuyFavoriteEntity findByBoardNumberAndUserEmail(Integer boarNumber,String UserEmail);

    @Query(
            value =
            "SELECT "+
                    "U.email AS email, "+
                    "U.nickname AS nickname, "+
                    "U.profile_image AS profileImage "+
                    "FROM groupbuy_favorite AS F "+
                    "INNER JOIN user AS U "+
                    "ON F.user_email = U.email "+
                    "WHERE F.board_number = ? ",
            nativeQuery = true
    )
    List<GetGroupBuyFavoriteListResultSet> getFavoriteList(Integer boardNumber);

    @Transactional
    void deleteByBoardNumber(Integer boardNumber);
}
