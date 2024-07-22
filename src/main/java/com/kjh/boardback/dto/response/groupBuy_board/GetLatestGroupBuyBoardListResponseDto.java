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
public class GetLatestGroupBuyBoardListResponseDto extends ResponseDto {

    private final List<GroupBuyBoardListItem> groupBuylatestList;

    private GetLatestGroupBuyBoardListResponseDto(List<GroupBuyBoardListViewEntity> boardListViewEntities) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.groupBuylatestList = GroupBuyBoardListItem.getList(boardListViewEntities);


    }

    public static ResponseEntity<GetLatestGroupBuyBoardListResponseDto> success(List<GroupBuyBoardListViewEntity> boardListViewEntities) {
        GetLatestGroupBuyBoardListResponseDto result = new GetLatestGroupBuyBoardListResponseDto(boardListViewEntities);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
