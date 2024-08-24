package com.kjh.boardback.dto.request.recipe_board;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PatchRecipeBoardRequestDto {
    @NotBlank
    private String title;
    @NotBlank
    private String content;
    @NotNull
    private List<String> boardImageList;
    @NotNull
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

}
