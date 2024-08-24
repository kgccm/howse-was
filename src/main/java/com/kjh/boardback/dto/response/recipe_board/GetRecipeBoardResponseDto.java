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
    private int type;
    private int cookingTime;
    private List<String> step1_image;
    private String step1_content;
    private List<String> step2_image;
    private String step2_content;
    private List<String> step3_image;
    private String step3_content;
    private List<String> step4_image;
    private String step4_content;
    private List<String> step5_image;
    private String step5_content;
    private List<String> step6_image;
    private String step6_content;
    private List<String> step7_image;
    private String step7_content;
    private List<String> step8_image;
    private String step8_content;
   

    private GetRecipeBoardResponseDto(GetRecipeBoardResultSet resultSet, List<RecipeImageEntity> imageEntities) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);

        List<String> boardImageList = new ArrayList<>();
        List<String> step1_image = new ArrayList<>();
        List<String> step2_image = new ArrayList<>();
        List<String> step3_image = new ArrayList<>();
        List<String> step4_image = new ArrayList<>();
        List<String> step5_image = new ArrayList<>();
        List<String> step6_image = new ArrayList<>();
        List<String> step7_image = new ArrayList<>();
        List<String> step8_image = new ArrayList<>();

        classificationImage(imageEntities, boardImageList, step1_image, step2_image, step3_image, step4_image, step5_image, step6_image, step7_image, step8_image);

        this.boardNumber = resultSet.getBoardNumber();
        this.title = resultSet.getTitle();
        this.content = resultSet.getContent();
        this.boardImageList = boardImageList;
        this.writeDatetime = resultSet.getWriteDatetime();
        this.writerEmail = resultSet.getWriterEmail();
        this.writerNickname = resultSet.getWriterNickname();
        this.writerProfileImage = resultSet.getWriterProfileImage();
        this.type = resultSet.getType();
        this.cookingTime = resultSet.getCookingTime();
        this.step1_content = resultSet.getStep_1();
        this.step2_content = resultSet.getStep_2();
        this.step3_content = resultSet.getStep_3();
        this.step4_content = resultSet.getStep_4();
        this.step5_content = resultSet.getStep_5();
        this.step6_content = resultSet.getStep_6();
        this.step7_content = resultSet.getStep_7();
        this.step8_content = resultSet.getStep_8();
        this.step1_image = step1_image;
        this.step2_image = step2_image;
        this.step3_image = step3_image;
        this.step4_image = step4_image;
        this.step5_image = step5_image;
        this.step6_image = step6_image;
        this.step7_image = step7_image;
        this.step8_image = step8_image;
    }

    private static void classificationImage(List<RecipeImageEntity> imageEntities, List<String> boardImageList, List<String> step1_image, List<String> step2_image, List<String> step3_image, List<String> step4_image, List<String> step5_image, List<String> step6_image, List<String> step7_image, List<String> step8_image) {
        for(RecipeImageEntity imageEntity : imageEntities){
            String boardImage = imageEntity.getImage();
            int step = imageEntity.getStep();
            switch(step){
                case 0:
                    boardImageList.add(boardImage);
                    break;
                case 1:
                    step1_image.add(boardImage);
                    break;
                case 2:
                    step2_image.add(boardImage);
                    break;
                case 3:
                    step3_image.add(boardImage);
                    break;
                case 4:
                    step4_image.add(boardImage);
                    break;
                case 5:
                    step5_image.add(boardImage);
                    break;
                case 6:
                    step6_image.add(boardImage);
                    break;
                case 7:
                    step7_image.add(boardImage);
                    break;
                case 8:
                    step8_image.add(boardImage);
                    break;
            }
        }
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
