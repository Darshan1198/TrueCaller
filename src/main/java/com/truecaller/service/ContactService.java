package com.truecaller.service;

import com.truecaller.models.Contact;
import com.truecaller.models.constants.ContactTypes;
public interface ContactService {

        // Add a new contact
        Contact addContact(String phoneNumber, ContactTypes contactType);

        // Block a contact
        void blockContact(Long userId,String   phoneNumber);

        // Unblock a contact
        void unblockContact(Long userid, String PhoneNumber);

        // Report a contact as spam
        void reportSpam(Long contactId);

        // Identify a caller


        // Add a contact to the blacklist
        void blackListContact(Long contactId);
    }
