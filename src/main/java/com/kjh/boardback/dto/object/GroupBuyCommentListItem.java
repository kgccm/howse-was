package com.kjh.boardback.dto.object;

import com.kjh.boardback.repository.resultSet.GetCommentListResultSet;
import com.kjh.boardback.repository.resultSet.GetGroupBuyCommentListResultSet;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor

public class GroupBuyCommentListItem {
    private Integer commentNumber;
    private String nickname;
    private String profileImage;
    private String writeDatetime;
    private String content;

    private GroupBuyCommentListItem(GetGroupBuyCommentListResultSet resultSet){
        this.commentNumber = resultSet.getCommentNumber();
        this.nickname = resultSet.getNickname();
        this.profileImage = resultSet.getProfileImage();
        this.writeDatetime = resultSet.getWriteDatetime();
        this.content = resultSet.getContent();
    }

    public static List<GroupBuyCommentListItem> copyList(List<GetGroupBuyCommentListResultSet> resultSets) {
        List<GroupBuyCommentListItem> list = new ArrayList<>();
        for (GetGroupBuyCommentListResultSet resultSet : resultSets) {
            GroupBuyCommentListItem commentListItem = new GroupBuyCommentListItem(resultSet);
            list.add(commentListItem);
        }
        return list;
    }
}
