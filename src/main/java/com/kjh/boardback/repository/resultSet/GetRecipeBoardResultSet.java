package com.kjh.boardback.repository.resultSet;

import java.time.ZonedDateTime;

public interface GetRecipeBoardResultSet {
    Integer getBoardNumber();

    String getTitle();

    String getContent();

    ZonedDateTime getWriteDatetime(); // ZonedDateTime으로 변경

    String getWriterEmail();

    String getWriterNickname();

    String getWriterProfileImage();

    Integer getType();

    Integer getCookingTime();

    String getStep_1();

    String getStep_2();

    String getStep_3();

    String getStep_4();

    String getStep_5();

    String getStep_6();

    String getStep_7();

    String getStep_8();

}
