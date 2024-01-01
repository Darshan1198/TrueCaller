package com.truecaller.models;

import com.truecaller.models.constants.ContactTypes;
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

    private String phoneNumber;

    private int SpamCount;

    @Enumerated( EnumType.STRING)
    private ContactTypes contactType;
}