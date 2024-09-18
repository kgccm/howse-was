package com.kjh.boardback.repository.resultSet;

import java.time.LocalDateTime;

public interface GetRecipeCommentListResultSet {
    Integer getCommentNumber();

    String getNickname();

    String getProfileImage();

    LocalDateTime getWriteDatetime();

    String getContent();
}
