package com.kjh.boardback.entity.groupBuy_board;

import com.kjh.boardback.dto.request.groupBuy_board.PatchGroupBuyBoardRequestDto;
import com.kjh.boardback.dto.request.groupBuy_board.PostGroupBuyBoardRequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "groupbuy_board")
@Table(name = "groupbuy_board")
public class GroupBuyBoardEntity {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int boardNumber;

    private String title;

    private String content;

    private String writeDatetime;
    
    private int favoriteCount;

    private int commentCount;

    private int viewCount;

    private String writerEmail;

    private String participationArea;

    private String originalPrice;

    private String groupbuyPrice;



    public void increaseViewCount(){
        this.viewCount++;
    }

    public void increaseCommentCount(){
        this.commentCount++;
    }

    public void decreaseCommentCount() {this.commentCount--;}

    public void increaseFavoriteCount(){this.favoriteCount++;}
    public void decreaseFavoriteCount(){this.favoriteCount--;}

    public GroupBuyBoardEntity(PostGroupBuyBoardRequestDto dto, String email) {

        Date now = Date.from(Instant.now());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String writeDateTime = simpleDateFormat.format(now);

        this.title = dto.getTitle();
        this.content = dto.getContent();
        this.writeDatetime = writeDateTime;
        this.favoriteCount =0;
        this.commentCount = 0;
        this.viewCount = 0;
        this.writerEmail = email;
        this.participationArea = dto.getParticipationArea();
        this.originalPrice = dto.getOriginalPrice();
        this.groupbuyPrice = dto.getGroupbuyPrice();
    }

    public void patchBoard(PatchGroupBuyBoardRequestDto dto){
        this.title = dto.getTitle();
        this.content = dto.getContent();
        this.participationArea = dto.getParticipationArea();
        this.originalPrice = dto.getOriginalPrice();
        this.groupbuyPrice = dto.getGroupbuyPrice();
    }

}
