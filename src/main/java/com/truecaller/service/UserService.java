package com.truecaller.service;

import com.truecaller.dto.UserPhoneRequestDTO;
import com.truecaller.dto.UserPhoneResponseDTO;
import com.truecaller.dto.UserRegisterRequestDTO;
import com.truecaller.dto.UserRegisterResponseDto;
import com.truecaller.models.constants.UserType;
import org.springframework.http.ResponseEntity;

public interface UserService {

    ResponseEntity<UserRegisterResponseDto> registerUser(UserRegisterRequestDTO userRegisterRequestDTO, UserType userType);

    ResponseEntity<UserPhoneResponseDTO>  identifyCaller(UserPhoneRequestDTO userPhoneRequestDTO);
}
