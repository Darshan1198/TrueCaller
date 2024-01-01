package com.truecaller.dto;

import com.truecaller.models.constants.UserType;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserRegisterResponseDto {
    private  String  name;
    private  String  phoneNummber;
    private  String  email;
    private  UserType userType;
    private  int  responseCode;
    private  String  responseMessage;

}
