package com.kjh.boardback.dto.object;

import com.kjh.boardback.repository.resultSet.GetFavoriteListResultSet;
import com.kjh.boardback.repository.resultSet.GetGroupBuyFavoriteListResultSet;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor

public class GroupBuyFavoriteListItem {
    private String email;
    private String nickname;
    private String profileImage;

    public GroupBuyFavoriteListItem(GetGroupBuyFavoriteListResultSet resultSet) {
        this.email = resultSet.getEmail();
        this.nickname = resultSet.getNickname();
        this.profileImage = resultSet.getProfileImage();
    }

    public static List<GroupBuyFavoriteListItem> copyList(List<GetGroupBuyFavoriteListResultSet> resultSets){
        List<GroupBuyFavoriteListItem> list = new ArrayList<>();
        for(GetGroupBuyFavoriteListResultSet resultSet : resultSets){
            GroupBuyFavoriteListItem favoriteListItem = new GroupBuyFavoriteListItem(resultSet);
            list.add(favoriteListItem);
        }
        return list;
    }
}
