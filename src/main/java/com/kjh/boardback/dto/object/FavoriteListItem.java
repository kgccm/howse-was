package com.kjh.boardback.dto.object;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar.String;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor

public class FavoriteListItem {
    private String email;
    private String nickname;
    private String profileImage;
}
