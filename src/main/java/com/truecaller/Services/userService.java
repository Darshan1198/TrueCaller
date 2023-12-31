package com.truecaller.Services;

import com.truecaller.models.constants.User;
import com.truecaller.models.constants.UserType;

public interface userService {

    User registerUser(String userName, String userPhoneNumber, String userEmail, UserType userType, String password);
}
