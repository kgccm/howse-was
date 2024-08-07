package com.kjh.boardback.dto.response.recipe_board;

import com.kjh.boardback.common.ResponseCode;
import com.kjh.boardback.common.ResponseMessage;
import com.kjh.boardback.dto.object.RecipeBoardListItem;
import com.kjh.boardback.dto.response.ResponseDto;
import com.kjh.boardback.entity.recipe_board.RecipeBoardListViewEntity;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Getter
public class GetTop5ConvenienceRecipeBoardListResponseDto extends ResponseDto {

    private List<RecipeBoardListItem> conveniencerecipetop5List;
    private GetTop5ConvenienceRecipeBoardListResponseDto(List<RecipeBoardListViewEntity> boardListViewEntities) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.conveniencerecipetop5List = RecipeBoardListItem.getList(boardListViewEntities);

    }

    public static ResponseEntity<GetTop5ConvenienceRecipeBoardListResponseDto> success(List<RecipeBoardListViewEntity> boardListViewEntities){
        GetTop5ConvenienceRecipeBoardListResponseDto result = new GetTop5ConvenienceRecipeBoardListResponseDto(boardListViewEntities);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
