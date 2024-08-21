package com.kjh.boardback.dto.response.recipe_board;

import com.kjh.boardback.common.ResponseCode;
import com.kjh.boardback.common.ResponseMessage;
import com.kjh.boardback.dto.response.ResponseDto;
import com.kjh.boardback.entity.recipe_board.RecipeImageEntity;
import com.kjh.boardback.repository.resultSet.GetRecipeBoardResultSet;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

@Getter
public class GetRecipeBoardResponseDto extends ResponseDto {

    private int boardNumber;
    private String title;
    private String content;
    private List<String> boardImageList;
    private String writeDatetime;
    private String writerEmail;
    private String writerNickname;
    private String writerProfileImage;
    private int cookingTime;
    private String step_1;
    private String step_2;
    private String step_3;
    private String step_4;
    private String step_5;
    private String step_6;
    private String step_7;
    private String step_8;

    private GetRecipeBoardResponseDto(GetRecipeBoardResultSet resultSet, List<RecipeImageEntity> imageEntities) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);

        List<String> boardImageList = new ArrayList<>();
        for(RecipeImageEntity imageEntity : imageEntities){
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
        this.cookingTime = resultSet.getCookingTime();
        this.step_1 = resultSet.getStep_1();
        this.step_2 = resultSet.getStep_2();
        this.step_3 = resultSet.getStep_3();
        this.step_4 = resultSet.getStep_4();
        this.step_5 = resultSet.getStep_5();
        this.step_6 = resultSet.getStep_6();
        this.step_7 = resultSet.getStep_7();
        this.step_8 = resultSet.getStep_8();
    }

    public static ResponseEntity<GetRecipeBoardResponseDto> success(GetRecipeBoardResultSet resultSet, List<RecipeImageEntity> imageEntities){
        GetRecipeBoardResponseDto result = new GetRecipeBoardResponseDto(resultSet,imageEntities);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public static ResponseEntity<ResponseDto> noExistBoard(){
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXISTED_BOARD, ResponseMessage.NOT_EXISTED_BOARD);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }
}
