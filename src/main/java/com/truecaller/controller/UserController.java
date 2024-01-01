package com.truecaller.controller;


import com.truecaller.dto.UserPhoneRequestDTO;
import com.truecaller.dto.UserPhoneResponseDTO;
import com.truecaller.dto.UserRegisterRequestDTO;
import com.truecaller.dto.UserRegisterResponseDto;
import com.truecaller.models.constants.UserType;
import com.truecaller.service.ContactService;
import com.truecaller.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

//    @Autowired
//    private ContactService contactService;

    @PostMapping("/user/registration")
    public ResponseEntity<UserRegisterResponseDto> registerUser(@RequestBody UserRegisterRequestDTO userRegisterRequestDTO){
        ResponseEntity<UserRegisterResponseDto> response  = userService.registerUser(userRegisterRequestDTO, UserType.NORMAL_USER);
        return  response;
    }
    @PostMapping("/manager/registration")
    public ResponseEntity<UserRegisterResponseDto> registerManager(@RequestBody UserRegisterRequestDTO userRegisterRequestDTO) {
        ResponseEntity<UserRegisterResponseDto> response = userService.registerUser(userRegisterRequestDTO, UserType.CONTACT_MANAGER);
        return response;
    }
    @GetMapping("/user/identification")
    public ResponseEntity<UserPhoneResponseDTO>  identifyUser(@RequestBody UserPhoneRequestDTO userPhoneRequestDTO) {
        return userService.identifyCaller(userPhoneRequestDTO);
    }


}
