package com.kjh.boardback.repository.resultSet;

public interface GetGroupBuyBoardResultSet {
    Integer getBoardNumber();
    String getTitle();
    String getContent();
    String getWriteDatetime();
    String getWriterEmail();
    String getWriterNickname();
    String getWriterProfileImage();
    String getParticipationArea();
    String getOriginalPrice();
    String getGroupbuyPrice();

}
