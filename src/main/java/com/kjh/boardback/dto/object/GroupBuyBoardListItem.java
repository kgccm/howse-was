package com.kjh.boardback.dto.object;

import com.kjh.boardback.entity.board.BoardListViewEntity;
import com.kjh.boardback.entity.groupBuy_board.GroupBuyBoardListViewEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GroupBuyBoardListItem {
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
   private String participationArea;
   private String originalPrice;
   private String groupbuyPrice;

   public GroupBuyBoardListItem(GroupBuyBoardListViewEntity boardListViewEntity){
      this.boardNumber = boardListViewEntity.getBoardNumber();
      this.title = boardListViewEntity.getTitle();
      this.content = boardListViewEntity.getContent();
      this.boardTitleImage = boardListViewEntity.getTitleImage();
      this.viewCount = boardListViewEntity.getViewCount();
      this.favoriteCount = boardListViewEntity.getFavoriteCount();
      this.commentCount = boardListViewEntity.getCommentCount();
      this.writeDatetime = boardListViewEntity.getWriteDatetime();
      this.writerNickname = boardListViewEntity.getWriterNickname();
      this.writerProfileImage = boardListViewEntity.getWriterProfileImage();
      this.participationArea = boardListViewEntity.getParticipationArea();
      this.originalPrice = boardListViewEntity.getOriginalPrice();
      this.groupbuyPrice = boardListViewEntity.getGroupbuyPrice();
   }

   public static List<GroupBuyBoardListItem> getList(List<GroupBuyBoardListViewEntity> boardListViewEntities){
      List<GroupBuyBoardListItem> list = new ArrayList<>();
      for(GroupBuyBoardListViewEntity boardListViewEntity : boardListViewEntities){
         GroupBuyBoardListItem boardListItem = new GroupBuyBoardListItem(boardListViewEntity);
         list.add(boardListItem);
      }
      return list;
   }
}