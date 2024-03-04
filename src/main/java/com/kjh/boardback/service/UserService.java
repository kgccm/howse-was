package com.kjh.boardback.service;

import org.springframework.http.ResponseEntity;

import com.kjh.boardback.dto.response.user.GetSignInUserResponseDto;

public interface UserService {

    ResponseEntity<? super GetSignInUserResponseDto> getSignInUser(String email);
    
}
