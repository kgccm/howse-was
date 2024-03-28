package com.kjh.boardback.service.implement;

import com.kjh.boardback.dto.request.user.PatchNicknameRequestDto;
import com.kjh.boardback.dto.request.user.PatchProfileImageRequestDto;
import com.kjh.boardback.dto.response.user.GetUserResponseDto;
import com.kjh.boardback.dto.response.user.PatchNicknameResponseDto;
import com.kjh.boardback.dto.response.user.PatchProfileImageResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.kjh.boardback.dto.response.ResponseDto;
import com.kjh.boardback.dto.response.user.GetSignInUserResponseDto;
import com.kjh.boardback.entity.UserEntity;
import com.kjh.boardback.repository.UserRepository;
import com.kjh.boardback.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImplement implements UserService {

    private final UserRepository userRepository;

    @Override
    public ResponseEntity<? super GetUserResponseDto> getUser(String email) {

        UserEntity userEntity = null;

        try{

            userEntity = userRepository.findByEmail(email);
            if(userEntity == null) return GetUserResponseDto.noExistUser();


        }catch (Exception exception){
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return GetUserResponseDto.success(userEntity);
    }

    @Override
    public ResponseEntity<? super GetSignInUserResponseDto> getSignInUser(String email) {

        UserEntity userEntity = null;

        try {

            userEntity = userRepository.findByEmail(email);
            if(userEntity == null) return GetSignInUserResponseDto.noExistUser();

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetSignInUserResponseDto.success(userEntity);

    }

    @Override
    public ResponseEntity<? super PatchNicknameResponseDto> patchNickname(String email,PatchNicknameRequestDto dto) {

        UserEntity userEntity = null;

        try{
            userEntity = userRepository.findByEmail(email);
            if(userEntity == null) return PatchNicknameResponseDto.noExistUser();

            boolean existedNickname = userRepository.existsByNickname(dto.getNickname());
            if(existedNickname) return PatchNicknameResponseDto.duplicateNickname();

            userEntity.setNickname(dto.getNickname());
            userRepository.save(userEntity);


        }catch (Exception exception){
            exception.printStackTrace();
            return  ResponseDto.databaseError();
        }
        return PatchNicknameResponseDto.success();
    }

    @Override
    public ResponseEntity<? super PatchProfileImageResponseDto> patchProfileImage(String email, PatchProfileImageRequestDto dto) {

        UserEntity userEntity = null;

        try{
            userEntity = userRepository.findByEmail(email);
            if(userEntity == null) return PatchProfileImageResponseDto.noExistUser();

            userEntity.setProfileImage(dto.getProfileImage());
            userRepository.save(userEntity);

        }catch (Exception exception){
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return PatchProfileImageResponseDto.success();
    }
}
