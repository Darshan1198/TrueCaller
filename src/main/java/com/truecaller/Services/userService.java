package com.truecaller.Services;

import com.truecaller.models.constants.User;

public interface userService {

    User registerUser(String userName,String phoneNumber,String userEmail, String password);
}
