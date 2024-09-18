package com.kjh.boardback.repository.resultSet;

import java.time.LocalDateTime;

public interface GetBoardResultSet {
    Integer getBoardNumber();

    String getTitle();

    String getContent();

    LocalDateTime getWriteDatetime();

    String getWriterEmail();

    String getWriterNickname();

    String getWriterProfileImage();

}
