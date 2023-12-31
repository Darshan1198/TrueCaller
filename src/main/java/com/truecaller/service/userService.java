package com.truecaller.service;

import com.truecaller.models.User;
import com.truecaller.models.constants.UserType;

import java.util.Optional;

public interface userService {

    String  registerUser(String userName, String userPhoneNumber, String userEmail, UserType userType, String password);

    String  identifyCaller(String Phonenumber);
}
