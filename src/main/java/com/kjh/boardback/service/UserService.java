package com.kjh.boardback.service;

import com.kjh.boardback.dto.request.user.PatchNicknameRequestDto;
import com.kjh.boardback.dto.request.user.PatchProfileImageRequestDto;
import com.kjh.boardback.dto.response.user.GetUserResponseDto;
import com.kjh.boardback.dto.response.user.PatchNicknameResponseDto;
import com.kjh.boardback.dto.response.user.PatchProfileImageResponseDto;
import org.springframework.http.ResponseEntity;

import com.kjh.boardback.dto.response.user.GetSignInUserResponseDto;

public interface UserService {

    ResponseEntity<? super GetSignInUserResponseDto> getSignInUser(String email);
    ResponseEntity<? super GetUserResponseDto> getUser(String email);

    ResponseEntity<? super PatchNicknameResponseDto> patchNickname(String email,PatchNicknameRequestDto dto);
    ResponseEntity<? super PatchProfileImageResponseDto> patchProfileImage(String email, PatchProfileImageRequestDto dto);
}
