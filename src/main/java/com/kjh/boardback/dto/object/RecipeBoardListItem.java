package com.kjh.boardback.dto.object;

import com.kjh.boardback.entity.recipe_board.RecipeBoardListViewEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class RecipeBoardListItem {
    private int boardNumber;
    private String title;
    private String content;
    private String boardTitleImage;
    private int favoriteCount;
    private int commentCount;
    private int viewCount;
    private ZonedDateTime writeDatetime;
    private String writerNickname;
    private String writerProfileImage;
    private int type;
    private int cookingTime;
    private String step1_content;
    private String step2_content;
    private String step3_content;
    private String step4_content;
    private String step5_content;
    private String step6_content;
    private String step7_content;
    private String step8_content;

    public RecipeBoardListItem(RecipeBoardListViewEntity recipeBoardListViewEntity) {
        this.boardNumber = recipeBoardListViewEntity.getBoardNumber();
        this.title = recipeBoardListViewEntity.getTitle();
        this.content = recipeBoardListViewEntity.getContent();
        this.boardTitleImage = recipeBoardListViewEntity.getTitleImage();
        this.favoriteCount = recipeBoardListViewEntity.getFavoriteCount();
        this.commentCount = recipeBoardListViewEntity.getCommentCount();
        this.viewCount = recipeBoardListViewEntity.getViewCount();
        this.writeDatetime = recipeBoardListViewEntity.getWriteDatetime();
        this.writerNickname = recipeBoardListViewEntity.getWriterNickname();
        this.writerProfileImage = recipeBoardListViewEntity.getWriterProfileImage();
        this.cookingTime = recipeBoardListViewEntity.getCookingTime();
        this.type = recipeBoardListViewEntity.getType();
        this.step1_content = recipeBoardListViewEntity.getStep_1();
        this.step2_content = recipeBoardListViewEntity.getStep_2();
        this.step3_content = recipeBoardListViewEntity.getStep_3();
        this.step4_content = recipeBoardListViewEntity.getStep_4();
        this.step5_content = recipeBoardListViewEntity.getStep_5();
        this.step6_content = recipeBoardListViewEntity.getStep_6();
        this.step7_content = recipeBoardListViewEntity.getStep_7();
        this.step8_content = recipeBoardListViewEntity.getStep_8();
    }

    public static List<RecipeBoardListItem> getList(List<RecipeBoardListViewEntity> recipeBoardListViewEntities) {
        List<RecipeBoardListItem> recipeBoardListItems = new ArrayList<>();
        for (RecipeBoardListViewEntity recipeBoardListViewEntity : recipeBoardListViewEntities) {
            RecipeBoardListItem recipeBoardListItem = new RecipeBoardListItem(recipeBoardListViewEntity);
            recipeBoardListItems.add(recipeBoardListItem);
        }
        return recipeBoardListItems;
    }
}
