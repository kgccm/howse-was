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
    private String step_1;
    private String step_2;
    private String step_3;
    private String step_4;
    private String step_5;
    private String step_6;
    private String step_7;
    private String step_8;

}
