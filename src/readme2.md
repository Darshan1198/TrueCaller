**Requirements:**

- User should be able to Resister
- User should be able to Add Contact
- User should be able to Block/Unblock Contact/Numbers
- User should be able to Report Spam
- User should be able to Identify a Caller when Call comes
- User Service
    - Handle User Registration
    - Business Registration
- Contact manager - Manages User Contacts


**User:**
  -username
  -phonenumber
  -userEmail
-List<contact> blockedcontacts
  -userType
- registerUser()


**Contact**
- Phone number
- c0ntact type
- spamCount
- addContact()
- blockContact()
- unblockContact()
- reportSpam()
- identifyCaller()
- blacklistcontact()

**Contacttype**
-Normal
- Blocked 
-Business
-blackListed

**User type**
Normal user
contact manager
