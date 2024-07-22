package com.kjh.boardback.dto.request.groupBuy_board;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PatchGroupBuyCommentRequestDto {

    @NotBlank
    private String content;

}
