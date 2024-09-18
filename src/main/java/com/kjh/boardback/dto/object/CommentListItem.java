package com.kjh.boardback.dto.object;

import com.kjh.boardback.repository.resultSet.GetCommentListResultSet;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommentListItem {
    private Integer commentNumber;
    private String nickname;
    private String profileImage;
    private ZonedDateTime writeDatetime;  // 변경된 부분
    private String content;

    private CommentListItem(GetCommentListResultSet resultSet) {
        this.commentNumber = resultSet.getCommentNumber();
        this.nickname = resultSet.getNickname();
        this.profileImage = resultSet.getProfileImage();
        this.writeDatetime = resultSet.getWriteDatetime();  // 변경된 부분
        this.content = resultSet.getContent();
    }

    public static List<CommentListItem> copyList(List<GetCommentListResultSet> resultSets) {
        List<CommentListItem> list = new ArrayList<>();
        for (GetCommentListResultSet resultSet : resultSets) {
            CommentListItem commentListItem = new CommentListItem(resultSet);
            list.add(commentListItem);
        }
        return list;
    }
}
