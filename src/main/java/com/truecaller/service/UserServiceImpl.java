package com.truecaller.service;


import com.truecaller.exception.ContactNotFoundException;
import com.truecaller.exception.UserNotFoundException;
import com.truecaller.models.Contact;
import com.truecaller.repository.UserRepository;
import com.truecaller.models.User;
import com.truecaller.models.constants.UserType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements userService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public String registerUser(String userName, String userPhoneNumber, String userEmail, UserType userType, String password) {
        // Check if the user with the given username or email already exists
//        if (userRepository.existsByUsernameOrUserEmail(userName, userEmail)) {
//            throw new IllegalArgumentException("Username or email already exists");
//        }

        // You might want to perform additional validation and checks here

        // Create a new user
        User user = new User();
        user.setUsername(userName);
        user.setPhoneNumber(userPhoneNumber);
        user.setUserEmail(userEmail);
        user.setUserType(userType);
        user.setPassword(passwordEncoder.encode(password)); // Encrypt the password before storing

        // Save the user to the database
        userRepository.save(user);
        String  message = "User registraton  successfull";
        return message;
    }
    public String identifyCaller(String  phoneNumber){
        Optional<User> optionalUser  = userRepository.findByPhoneNumber(phoneNumber);
        if(optionalUser.isEmpty()){
            throw  new UserNotFoundException("User doesn't exists");
        }
        return  optionalUser.get().getUsername();
    }
}
