package com.kjh.boardback.dto.response.recipe_board;

import com.kjh.boardback.common.ResponseCode;
import com.kjh.boardback.common.ResponseMessage;
import com.kjh.boardback.dto.response.ResponseDto;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
public class PatchRecipeBoardResponseDto extends ResponseDto {
    private PatchRecipeBoardResponseDto() {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
    }

    public static ResponseEntity<PatchRecipeBoardResponseDto> success(){
        PatchRecipeBoardResponseDto result = new PatchRecipeBoardResponseDto();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public static ResponseEntity<ResponseDto> noExistUser(){
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXISTED_USER,ResponseMessage.NOT_EXISTED_USER);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }

    public static ResponseEntity<ResponseDto> noExistBoard(){
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXISTED_BOARD,ResponseMessage.NOT_EXISTED_BOARD);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }

    public static ResponseEntity<ResponseDto> noPermission(){
        ResponseDto result = new ResponseDto(ResponseCode.NO_PERMISSION,ResponseMessage.NO_PERMISSION);
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(result);
    }


}
