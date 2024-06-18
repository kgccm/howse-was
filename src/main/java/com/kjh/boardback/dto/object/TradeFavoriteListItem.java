package com.kjh.boardback.dto.object;

import com.kjh.boardback.repository.resultSet.GetFavoriteListResultSet;
import com.kjh.boardback.repository.resultSet.GetTradeFavoriteListResultSet;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor

public class TradeFavoriteListItem {
    private String email;
    private String nickname;
    private String profileImage;

    public TradeFavoriteListItem(GetTradeFavoriteListResultSet resultSet) {
        this.email = resultSet.getEmail();
        this.nickname = resultSet.getNickname();
        this.profileImage = resultSet.getProfileImage();
    }

    public static List<TradeFavoriteListItem> copyList(List<GetTradeFavoriteListResultSet> resultSets){
        List<TradeFavoriteListItem> list = new ArrayList<>();
        for(GetTradeFavoriteListResultSet resultSet : resultSets){
            TradeFavoriteListItem favoriteListItem = new TradeFavoriteListItem(resultSet);
            list.add(favoriteListItem);
        }
        return list;
    }
}
