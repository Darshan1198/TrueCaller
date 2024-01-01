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
        private String name;
        private String phoneNumber;
        private String email;
        private String password;

        @Enumerated( EnumType.STRING)
        private UserType userType;
        @OneToMany
        List<Contact> blockedContact;
    }
