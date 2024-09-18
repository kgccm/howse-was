package com.kjh.boardback.repository.resultSet;

import java.time.ZonedDateTime;

public interface GetRecipeCommentListResultSet {
    Integer getCommentNumber();

    String getNickname();

    String getProfileImage();

    ZonedDateTime getWriteDatetime(); // ZonedDateTime으로 변경

    String getContent();
}
