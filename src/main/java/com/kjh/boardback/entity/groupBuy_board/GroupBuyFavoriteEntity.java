package com.kjh.boardback.entity.groupBuy_board;

import com.kjh.boardback.entity.primaryKey.FavoritePk;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "groupbuy_favorite")
@Table(name = "groupbuy_favorite")
@IdClass(FavoritePk.class)
public class GroupBuyFavoriteEntity {
    @Id
    private String userEmail;
    @Id
    private int boardNumber;
    
}
