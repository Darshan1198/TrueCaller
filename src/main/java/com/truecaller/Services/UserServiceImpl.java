package com.truecaller.Services;


import com.truecaller.Repository.UserRepository;
import com.truecaller.models.constants.User;
import com.truecaller.models.constants.UserType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements userService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User registerUser(String userName, String userPhoneNumber, String userEmail, UserType userType, String password) {
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
        return userRepository.save(user);
    }
}
