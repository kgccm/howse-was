package com.kjh.boardback.dto.object;

import com.kjh.boardback.entity.recipe_board.RecipeBoardListViewEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private String writeDatetime;
    private String writerNickname;
    private String writerProfileImage;
    private int cookingTime;
    private String step_1;
    private String step_2;
    private String step_3;
    private String step_4;
    private String step_5;
    private String step_6;
    private String step_7;
    private String step_8;

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
        this.step_1 = recipeBoardListViewEntity.getStep_1();
        this.step_2 = recipeBoardListViewEntity.getStep_2();
        this.step_3 = recipeBoardListViewEntity.getStep_3();
        this.step_4 = recipeBoardListViewEntity.getStep_4();
        this.step_5 = recipeBoardListViewEntity.getStep_5();
        this.step_6 = recipeBoardListViewEntity.getStep_6();
        this.step_7 = recipeBoardListViewEntity.getStep_7();
        this.step_8 = recipeBoardListViewEntity.getStep_8();
    }

    public static List<RecipeBoardListItem> getList(List<RecipeBoardListViewEntity>recipeBoardListViewEntities ){
        List<RecipeBoardListItem> recipeBoardListItems = new ArrayList<>();
        for(RecipeBoardListViewEntity recipeBoardListViewEntity : recipeBoardListViewEntities){
            RecipeBoardListItem recipeBoardListItem = new RecipeBoardListItem(recipeBoardListViewEntity);
            recipeBoardListItems.add(recipeBoardListItem);
        }
        return recipeBoardListItems;
    }
}
