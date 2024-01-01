package com.truecaller.service;

import com.truecaller.exception.ContactNotFoundException;
import com.truecaller.exception.IlegalOperationException;
import com.truecaller.exception.UserNotFoundException;
import com.truecaller.models.constants.UserType;
import com.truecaller.repository.ContactRepository;
import com.truecaller.repository.UserRepository;
import com.truecaller.models.Contact;
import com.truecaller.models.constants.ContactTypes;
import com.truecaller.models.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;
    private final UserRepository userRepository;

    public ContactServiceImpl(ContactRepository contactRepository, UserRepository userRepository) {
        this.contactRepository = contactRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Contact addContact(String phoneNumber, ContactTypes contactType) {
        Contact newContact = new Contact();
        newContact.setPhoneNumber(phoneNumber);
        newContact.setContactType(contactType);
        return contactRepository.save(newContact);
    }

    @Override
    public void blockContact(Long userId, String phonenumber) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isEmpty()) {
            throw new UserNotFoundException("User doesn't exits");
        }
        Optional<Contact> contactOptional = contactRepository.findByPhoneNumber(phonenumber);
        if (contactOptional.isEmpty()) {
            throw new ContactNotFoundException("Contact doesn't exits");
        }
        userOptional.get().getBlockedContact().add(contactOptional.get()); // Adding the  contact to  user blocked  list
        userRepository.save(userOptional.get());  //  saving in the  user  repository
    }

    @Override
    public void unblockContact(Long userId, String phonenumber) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isEmpty()) {
            throw new UserNotFoundException("User doesn't exits");
        }
        Optional<Contact> contactOptional = contactRepository.findByPhoneNumber(phonenumber);
        if (contactOptional.isEmpty()) {
            throw new ContactNotFoundException("Contact doesn't exits");
        }
        if (userOptional.get().getBlockedContact().stream().parallel().noneMatch(contact -> contact.getId().equals(contactOptional.get().getId()))) { // validating  if  Phone number exists  in  blocked list
            throw new ContactNotFoundException("Contact is  not present in the User's blocked list");
        }
//        userOptional.get().getBlockedContact().remove(contactOptional.get()); // removing the  contact from the  USers  blocked list  after  Validation
//        userRepository.save(userOptional.get());  //  saving in the  user  repository

        // in  another  way//
        User user = userOptional.get();
        user.getBlockedContact().remove(contactOptional.get()); // removing the  contact from the  USers  blocked list  after  Validation
        userRepository.save(user);
    }

    public void reportSpam(Long contactId) {
        Optional<Contact> optionalContact = contactRepository.findById(contactId);
        if (optionalContact.isEmpty()) {
            throw new ContactNotFoundException("Contact doesn't exists");
        }
        Contact updatedSpamConunt = optionalContact.get();
        updatedSpamConunt.setSpamCount(updatedSpamConunt.getSpamCount() + 1);
        contactRepository.save(updatedSpamConunt);
    }


    @Override
    public void blackListContact(Long userId , String poneNumber) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isEmpty()) {
            throw new ContactNotFoundException("Contact doesn't exits");
        }
        User user  = userOptional.get();
        if(!user.getUserType().equals(UserType.CONTACT_MANAGER)){
            throw new IlegalOperationException("Only Contat manager can block lis the  user");

        }
        Optional<Contact>  contactOptional  = contactRepository.findByPhoneNumber(poneNumber);
        if(!contactOptional.isEmpty()){
            throw new ContactNotFoundException("Contact  doesn't exist");
        }
        Contact contact = contactOptional.get();
        contact.setContactType(ContactTypes.BLOCKLISTED);
        contactRepository.save(contact);
    }
}

