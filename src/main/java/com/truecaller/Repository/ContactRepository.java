package com.truecaller.Repository;

import com.truecaller.models.constants.Contact;
import com.truecaller.models.constants.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository  extends JpaRepository<Contact,  Long> {
}
