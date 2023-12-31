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

        @Enumerated( EnumType.STRING)
        private String userType;

    }
