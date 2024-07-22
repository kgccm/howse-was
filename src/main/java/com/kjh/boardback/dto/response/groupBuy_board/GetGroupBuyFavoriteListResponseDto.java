package com.kjh.boardback.dto.response.groupBuy_board;

import com.kjh.boardback.common.ResponseCode;
import com.kjh.boardback.common.ResponseMessage;
import com.kjh.boardback.dto.object.FavoriteListItem;
import com.kjh.boardback.dto.object.GroupBuyFavoriteListItem;
import com.kjh.boardback.dto.response.ResponseDto;
import com.kjh.boardback.repository.resultSet.GetFavoriteListResultSet;
import com.kjh.boardback.repository.resultSet.GetGroupBuyFavoriteListResultSet;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Getter
public class GetGroupBuyFavoriteListResponseDto extends ResponseDto {

    private final List<GroupBuyFavoriteListItem> favoriteList;

    private GetGroupBuyFavoriteListResponseDto(List<GetGroupBuyFavoriteListResultSet> resultSets) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.favoriteList = GroupBuyFavoriteListItem.copyList(resultSets);
    }

    public static ResponseEntity<GetGroupBuyFavoriteListResponseDto> success(List<GetGroupBuyFavoriteListResultSet> resultSets) {
        GetGroupBuyFavoriteListResponseDto result = new GetGroupBuyFavoriteListResponseDto(resultSets);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public static ResponseEntity<ResponseDto> noExistBoard() {
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXISTED_BOARD, ResponseMessage.NOT_EXISTED_BOARD);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }
}
