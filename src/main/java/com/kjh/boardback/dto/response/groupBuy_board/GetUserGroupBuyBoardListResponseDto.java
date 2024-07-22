package com.kjh.boardback.dto.response.groupBuy_board;

import com.kjh.boardback.common.ResponseCode;
import com.kjh.boardback.common.ResponseMessage;
import com.kjh.boardback.dto.object.BoardListItem;
import com.kjh.boardback.dto.object.GroupBuyBoardListItem;
import com.kjh.boardback.dto.response.ResponseDto;
import com.kjh.boardback.entity.board.BoardListViewEntity;
import com.kjh.boardback.entity.groupBuy_board.GroupBuyBoardListViewEntity;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Getter
public class GetUserGroupBuyBoardListResponseDto extends ResponseDto {

    private List<GroupBuyBoardListItem> userBoardList;

    private GetUserGroupBuyBoardListResponseDto(List<GroupBuyBoardListViewEntity> boardListViewEntities) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        List<GroupBuyBoardListItem> boardListItems = GroupBuyBoardListItem.getList(boardListViewEntities);
        this.userBoardList = boardListItems;
    }

    public static ResponseEntity<GetUserGroupBuyBoardListResponseDto> success(List<GroupBuyBoardListViewEntity> boardListViewEntities){
        GetUserGroupBuyBoardListResponseDto result = new GetUserGroupBuyBoardListResponseDto(boardListViewEntities);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public static ResponseEntity<ResponseDto> noExistUser(){
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXISTED_USER, ResponseMessage.NOT_EXISTED_USER);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }
}
