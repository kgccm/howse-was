package com.kjh.boardback.dto.response.recipe_board;

import com.kjh.boardback.common.ResponseCode;
import com.kjh.boardback.common.ResponseMessage;
import com.kjh.boardback.dto.object.BoardListItem;
import com.kjh.boardback.dto.object.RecipeBoardListItem;
import com.kjh.boardback.dto.response.ResponseDto;
import com.kjh.boardback.entity.board.BoardListViewEntity;
import com.kjh.boardback.entity.recipe_board.RecipeBoardListViewEntity;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Getter
public class GetTop3RecipeBoardListResponseDto extends ResponseDto {

    private List<RecipeBoardListItem> recipetop3List;
    private GetTop3RecipeBoardListResponseDto(List<RecipeBoardListViewEntity> boardListViewEntities) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.recipetop3List = RecipeBoardListItem.getList(boardListViewEntities);

    }

    public static ResponseEntity<GetTop3RecipeBoardListResponseDto> success(List<RecipeBoardListViewEntity> boardListViewEntities){
        GetTop3RecipeBoardListResponseDto result = new GetTop3RecipeBoardListResponseDto(boardListViewEntities);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
