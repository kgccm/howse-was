package com.kjh.boardback.repository.resultSet;

import java.time.LocalDateTime;

public interface GetTradeBoardResultSet {
    Integer getBoardNumber();

    String getTitle();

    String getContent();

    LocalDateTime getWriteDatetime();

    String getWriterEmail();

    String getTradeLocation();

    String getPrice();

    String getWriterNickname();

    String getWriterProfileImage();

}
