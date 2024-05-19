package com.kjh.boardback.dto.object;

import com.kjh.boardback.entity.recipe_board.RecipeBoardListViewEntity;
import com.kjh.boardback.entity.trade_board.TradeBoardListViewEntity;
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

    public RecipeBoardListItem(RecipeBoardListViewEntity recipeBoardListViewEntity) {
        this.boardNumber = recipeBoardListViewEntity.getBoardNumber();
        this.title = recipeBoardListViewEntity.getTitle();
        this.content = recipeBoardListViewEntity.getContent();
        this.boardTitleImage = recipeBoardListViewEntity.getWriterProfileImage();
        this.favoriteCount = recipeBoardListViewEntity.getFavoriteCount();
        this.commentCount = recipeBoardListViewEntity.getCommentCount();
        this.viewCount = recipeBoardListViewEntity.getViewCount();
        this.writeDatetime = recipeBoardListViewEntity.getWriteDatetime();
        this.writerNickname = recipeBoardListViewEntity.getWriterNickname();
        this.writerProfileImage = recipeBoardListViewEntity.getWriterProfileImage();
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
