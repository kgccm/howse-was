package com.kjh.boardback.dto.request.trade_board;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PatchTradeCommentRequestDto {

    @NotBlank
    private String content;

}
