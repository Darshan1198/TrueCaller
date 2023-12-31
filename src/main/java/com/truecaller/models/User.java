package com.truecaller.models;

import com.truecaller.models.constants.UserType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
    public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String username;
        private String phoneNumber;
        private String userEmail;
        private String password;

        @Enumerated( EnumType.STRING)
        private UserType userType;
        @OneToMany
        List<Contact> blockedContact;
    }
