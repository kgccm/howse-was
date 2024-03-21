package com.kjh.boardback.service.implement;

import com.kjh.boardback.dto.response.ResponseDto;
import com.kjh.boardback.dto.response.search.GetPopularListResponseDto;
import com.kjh.boardback.repository.SearchLogRepository;
import com.kjh.boardback.repository.resultSet.GetPopularListResultSet;
import com.kjh.boardback.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchServiceImplement implements SearchService {

    private final SearchLogRepository searchLogRepository;
    @Override
    public ResponseEntity<? super GetPopularListResponseDto> getPopularList() {

        List<GetPopularListResultSet> resultSets = new ArrayList<>();

        try{
            resultSets = searchLogRepository.getPopularList();

        }catch (Exception exception){
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return GetPopularListResponseDto.success(resultSets);
    }
}
