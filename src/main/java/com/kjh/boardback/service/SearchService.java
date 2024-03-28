package com.kjh.boardback.service;

import com.kjh.boardback.dto.response.search.GetPopularListResponseDto;
import com.kjh.boardback.dto.response.search.GetRelationListResponseDto;
import org.springframework.http.ResponseEntity;

public interface SearchService {

    ResponseEntity<? super GetPopularListResponseDto> getPopularList();
    ResponseEntity<? super GetRelationListResponseDto> getRelationList(String searchWord);

}
