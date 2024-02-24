package com.kjh.boardback.dto.object;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar.String;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor

public class CommentListItem {
    private String nickname;
    private String profileImage;
    private String writeDatetime;
    private String content;
}
