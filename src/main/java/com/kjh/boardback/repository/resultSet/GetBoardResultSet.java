package com.kjh.boardback.repository.resultSet;

import java.time.ZonedDateTime;

public interface GetBoardResultSet {
    Integer getBoardNumber();

    String getTitle();

    String getContent();

    ZonedDateTime getWriteDatetime(); // ZonedDateTime으로 변경

    String getWriterEmail();

    String getWriterNickname();

    String getWriterProfileImage();

}
