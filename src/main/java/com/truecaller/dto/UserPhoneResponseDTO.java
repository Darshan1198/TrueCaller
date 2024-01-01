package com.truecaller.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserPhoneResponseDTO {
    private String name;
    private String phoneNumber;
    private int responseCode;
    private String responseMessage;

}
