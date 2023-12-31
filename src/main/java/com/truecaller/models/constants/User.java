package com.truecaller.models.constants;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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

    }
