package com.truecaller.Services;

import com.truecaller.models.constants.Contact;
import com.truecaller.models.constants.ContactTypes;
public interface ContactService {

        // Add a new contact
        Contact addContact(String phoneNumber, ContactTypes contactType);

        // Block a contact
        void blockContact(Long contactId);

        // Unblock a contact
        void unblockContact(Long contactId);

        // Report a contact as spam
        void reportSpam(Long contactId);

        // Identify a caller
        void identifyCaller(Long contactId, String callerName);

        // Add a contact to the blacklist
        void blackListContact(Long contactId);
    }
