package com.kjh.boardback.dto.response.groupBuy_board;

import com.kjh.boardback.common.ResponseCode;
import com.kjh.boardback.common.ResponseMessage;
import com.kjh.boardback.dto.response.ResponseDto;
import com.kjh.boardback.entity.board.ImageEntity;
import com.kjh.boardback.entity.groupBuy_board.GroupBuyImageEntity;
import com.kjh.boardback.repository.resultSet.GetBoardResultSet;
import com.kjh.boardback.repository.resultSet.GetGroupBuyBoardResultSet;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

@Getter
public class GetGroupBuyBoardResponseDto extends ResponseDto {

    private int boardNumber;
    private String title;
    private String content;
    private List<String> boardImageList;
    private String writeDatetime;
    private String writerEmail;
    private String writerNickname;
    private String writerProfileImage;
    private String participationArea;
    private String originalPrice;
    private String groupbuyPrice;

    private GetGroupBuyBoardResponseDto(GetGroupBuyBoardResultSet resultSet, List<GroupBuyImageEntity> imageEntities) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);

        List<String> boardImageList = new ArrayList<>();
        for(GroupBuyImageEntity imageEntity : imageEntities){
            String boardImage = imageEntity.getImage();
            boardImageList.add(boardImage);
        }

        this.boardNumber = resultSet.getBoardNumber();
        this.title = resultSet.getTitle();
        this.content = resultSet.getContent();
        this.boardImageList = boardImageList;
        this.writeDatetime = resultSet.getWriteDatetime();
        this.writerEmail = resultSet.getWriterEmail();
        this.writerNickname = resultSet.getWriterNickname();
        this.writerProfileImage = resultSet.getWriterProfileImage();
        this.participationArea = resultSet.getParticipationArea();
        this.originalPrice = resultSet.getOriginalPrice();
        this.groupbuyPrice = resultSet.getGroupbuyPrice();
    }

    public static ResponseEntity<GetGroupBuyBoardResponseDto> success(GetGroupBuyBoardResultSet resultSet, List<GroupBuyImageEntity> imageEntities){
        GetGroupBuyBoardResponseDto result = new GetGroupBuyBoardResponseDto(resultSet,imageEntities);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public static ResponseEntity<ResponseDto> noExistBoard(){
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXISTED_BOARD, ResponseMessage.NOT_EXISTED_BOARD);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }
}
