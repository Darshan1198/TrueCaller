package com.truecaller.service;


import com.truecaller.dto.UserPhoneRequestDTO;
import com.truecaller.dto.UserPhoneResponseDTO;
import com.truecaller.dto.UserRegisterRequestDTO;
import com.truecaller.dto.UserRegisterResponseDto;
import com.truecaller.exception.UserNotFoundException;
import com.truecaller.repository.UserRepository;
import com.truecaller.models.User;
import com.truecaller.models.constants.UserType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import  static com.truecaller.mapper.UserEntityDTOMapper.*;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public ResponseEntity<UserRegisterResponseDto> registerUser(UserRegisterRequestDTO userRegisterRequestDTO, UserType userType) {
        // Check if the user with the given username or email already exists
//        if (userRepository.existsByUsernameOrUserEmail(userName, userEmail)) {
//            throw new IllegalArgumentException("Username or email already exists");
//        }

        // You might want to perform additional validation and checks here

        // Create a new user
        UserRegisterResponseDto responseDto = new UserRegisterResponseDto();
        try {
            User user = getUserEntityFromUserRequestDTO(userRegisterRequestDTO);
            user.setUserType(userType);
            user.setPassword(passwordEncoder.encode(userRegisterRequestDTO.getPassword())); // Encrypt the password before storing

            // Save the user to the database
            userRepository.save(user);
            responseDto  = getUserRegisterResponseDTOFromUserEntity(user);
            responseDto.setResponseCode(200);
            responseDto.setResponseMessage("Success : User Registration Successfull");
            return ResponseEntity.ok(responseDto);

        } catch (Exception e) {
            responseDto.setResponseMessage("please Use valid  Email or Password ");
            responseDto.setResponseCode(500);
            return ResponseEntity.status(500).body(responseDto);
        }

    }

    public ResponseEntity<UserPhoneResponseDTO> identifyCaller(UserPhoneRequestDTO userPhoneRequestDTO){
        UserPhoneResponseDTO userPhoneResponseDto  = new UserPhoneResponseDTO();
        try{
            Optional<User> optionalUser  = userRepository.findByPhoneNumber(userPhoneRequestDTO.getPhoneNumber());
            if(optionalUser.isEmpty()){
                throw  new UserNotFoundException("User doesn't exists");
            }
            userPhoneResponseDto.setName(optionalUser.get().getName());
            userPhoneResponseDto.setPhoneNumber(userPhoneRequestDTO.getPhoneNumber());
            userPhoneResponseDto.setResponseCode(200);
            userPhoneResponseDto.setResponseMessage("Success : Request successfully processed");
            return ResponseEntity.ok(userPhoneResponseDto);

        }catch (Exception e){
            userPhoneResponseDto.setResponseCode(500);
            userPhoneResponseDto.setResponseMessage("Failure: Phone Number  Not  found in  data  base");
            return ResponseEntity.status(500).body(userPhoneResponseDto);
        }
    }
}
