package com.kjh.boardback.repository.resultSet;

import java.time.ZonedDateTime;

public interface GetTradeBoardResultSet {
    Integer getBoardNumber();

    String getTitle();

    String getContent();

    ZonedDateTime getWriteDatetime(); // ZonedDateTime으로 변경

    String getWriterEmail();

    String getTradeLocation();

    String getPrice();

    String getWriterNickname();

    String getWriterProfileImage();

}
