package com.truecaller.mapper;

import com.truecaller.dto.UserRegisterRequestDTO;
import com.truecaller.dto.UserRegisterResponseDto;
import com.truecaller.models.User;

public class UserEntityDTOMapper {
    public   static User getUserEntityFromUserRequestDTO(UserRegisterRequestDTO userRegisterRequestDTO){
        User user  = new User();
        user.setName(userRegisterRequestDTO.getName());
        user.setPhoneNumber(userRegisterRequestDTO.getPhoneNumber());
        user.setEmail(userRegisterRequestDTO.getEmail());
        return   user;
    }

    public   static UserRegisterResponseDto getUserRegisterResponseDTOFromUserEntity( User  user){
        UserRegisterResponseDto  userRegisterResponseDto = new UserRegisterResponseDto();
        userRegisterResponseDto.setUserType(user.getUserType());
        userRegisterResponseDto.setName(user.getName());
        userRegisterResponseDto.setEmail(user.getEmail());
        userRegisterResponseDto.setPhoneNummber(user.getPhoneNumber());
        return userRegisterResponseDto;
    }

}
