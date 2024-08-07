package com.kjh.boardback.dto.response.recipe_board;

import com.kjh.boardback.common.ResponseCode;
import com.kjh.boardback.common.ResponseMessage;
import com.kjh.boardback.dto.response.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class GetTop5RecipeBoardListResponseDto extends ResponseDto {
    private GetTop5RecipeBoardListResponseDto(String code, String message) {
        super(code, message);
    }

    public static ResponseEntity<? extends ResponseDto> getTop5DatabaseError(){
        GetTop5RecipeBoardListResponseDto responseBody = new GetTop5RecipeBoardListResponseDto(ResponseCode.DATABASE_ERROR, ResponseMessage.DATABASE_ERROR);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
    }
    public static ResponseEntity<? extends ResponseDto> getTop5TypeError(){
        GetTop5RecipeBoardListResponseDto responseBody = new GetTop5RecipeBoardListResponseDto(ResponseCode.NOT_EXISTED_BOARD, ResponseMessage.NOT_EXISTED_BOARD);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
    }
}
