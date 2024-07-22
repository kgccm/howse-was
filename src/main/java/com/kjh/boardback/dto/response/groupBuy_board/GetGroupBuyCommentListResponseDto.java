package com.kjh.boardback.dto.response.groupBuy_board;

import com.kjh.boardback.common.ResponseCode;
import com.kjh.boardback.common.ResponseMessage;
import com.kjh.boardback.dto.object.CommentListItem;
import com.kjh.boardback.dto.object.GroupBuyCommentListItem;
import com.kjh.boardback.dto.response.ResponseDto;
import com.kjh.boardback.repository.resultSet.GetCommentListResultSet;
import com.kjh.boardback.repository.resultSet.GetGroupBuyCommentListResultSet;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Getter
public class GetGroupBuyCommentListResponseDto extends ResponseDto {

    private List<GroupBuyCommentListItem> commentList;

    private GetGroupBuyCommentListResponseDto(List<GetGroupBuyCommentListResultSet> resultSets) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.commentList = GroupBuyCommentListItem.copyList(resultSets);
    }

    public static ResponseEntity<GetGroupBuyCommentListResponseDto> success(List<GetGroupBuyCommentListResultSet> resultSets){
        GetGroupBuyCommentListResponseDto result = new GetGroupBuyCommentListResponseDto(resultSets);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public static ResponseEntity<ResponseDto> noExistBoard(){
        ResponseDto result  = new ResponseDto(ResponseCode.NOT_EXISTED_BOARD, ResponseMessage.NOT_EXISTED_BOARD);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }
}
