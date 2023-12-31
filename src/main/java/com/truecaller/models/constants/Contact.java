package com.truecaller.models.constants;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String PhoneNumber;

    @Enumerated( EnumType.STRING)
    private ContactTypes contactType;
}