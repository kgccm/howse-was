package com.kjh.boardback.dto.object;

import com.kjh.boardback.repository.resultSet.GetTradeCommentListResultSet;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor

public class TradeCommentListItem {
    private Integer commentNumber;
    private String nickname;
    private String profileImage;
    private LocalDateTime writeDatetime; // 변경된 부분
    private String content;

    private TradeCommentListItem(GetTradeCommentListResultSet resultSet) {
        this.commentNumber = resultSet.getCommentNumber();
        this.nickname = resultSet.getNickname();
        this.profileImage = resultSet.getProfileImage();
        this.writeDatetime = resultSet.getWriteDatetime();
        this.content = resultSet.getContent();
    }

    public static List<TradeCommentListItem> copyList(List<GetTradeCommentListResultSet> resultSets) {
        List<TradeCommentListItem> list = new ArrayList<>();
        for (GetTradeCommentListResultSet resultSet : resultSets) {
            TradeCommentListItem commentListItem = new TradeCommentListItem(resultSet);
            list.add(commentListItem);
        }
        return list;
    }
}
