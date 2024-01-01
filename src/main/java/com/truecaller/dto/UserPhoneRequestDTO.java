package com.truecaller.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserPhoneRequestDTO {
    private   Long  UserId;
    private   String  PhoneNumber;
}
