package com.kjh.boardback.entity.groupBuy_board;

import com.kjh.boardback.dto.request.groupBuy_board.PatchGroupBuyCommentRequestDto;
import com.kjh.boardback.dto.request.groupBuy_board.PostGroupBuyCommentRequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "groupbuy_comment")
@Table(name = "groupbuy_comment")
public class GroupBuyCommentEntity {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int commentNumber;

    private String content;
    private String writeDatetime;
    private String userEmail;
    private int boardNumber;

    public GroupBuyCommentEntity(Integer boardNumber, String email, PostGroupBuyCommentRequestDto dto) {
        Date date = Date.from(Instant.now());
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String writeDatetime = dateFormat.format(date);

        this.boardNumber =boardNumber;
        this.userEmail = email;
        this.content = dto.getContent();
        this.writeDatetime =writeDatetime;
    }

    public void patchComment(PatchGroupBuyCommentRequestDto dto){
        this.content = dto.getContent();
    }
}
