public class Contact {

  private static final int CONTACT_PHONENUM_LENGTH = 10;
  private static final byte CONTACT_ID_LENGTH = 10;
  private static final byte CONTACT_FNAME_LENGTH = 10;
  private static final byte CONTACT_LNAME_LENGTH = 10;
  private static final byte CONTACT_ADDRESS_LENGTH = 30;
  private static final String INITIALIZER = "INITIAL";
  private static final String INITIALIZER_NUM = "5684225988";
  private String contactId;
  private String firstName;
  private String lastName;
  private String phoneNumber;
  private String address;

  Contact() {
    // Default constructor sets initial values
    this.contactId = INITIALIZER;
    this.firstName = INITIALIZER;
    this.lastName = INITIALIZER;
    this.phoneNumber = INITIALIZER_NUM;
    this.address = INITIALIZER;
  }

  Contact(String contactId) {
    // Constructor with contactId parameter
    updateContactId(contactId);
    this.firstName = INITIALIZER;
    this.lastName = INITIALIZER;
    this.phoneNumber = INITIALIZER_NUM;
    this.address = INITIALIZER;
  }

  Contact(String contactId, String firstName) {
    // Constructor with contactId and firstName parameters
    updateContactId(contactId);
    updateFirstName(firstName);
    this.lastName = INITIALIZER;
    this.phoneNumber = INITIALIZER_NUM;
    this.address = INITIALIZER;
  }

  Contact(String contactId, String firstName, String lastName) {
    // Constructor with contactId, firstName, and lastName parameters
    updateContactId(contactId);
    updateFirstName(firstName);
    updateLastName(lastName);
    this.phoneNumber = INITIALIZER_NUM;
    this.address = INITIALIZER;
  }

  Contact(String contactId, String firstName, String lastName, String phoneNumber) {
    // Constructor with contactId, firstName, lastName, and phoneNumber parameters
    updateContactId(contactId);
    updateFirstName(firstName);
    updateLastName(lastName);
    updatePhoneNumber(phoneNumber);
    this.address = INITIALIZER;
  }

  Contact(String contactId, String firstName, String lastName, String phoneNumber, String address) {
    // Constructor with all parameters
    updateContactId(contactId);
    updateFirstName(firstName);
    updateLastName(lastName);
    updatePhoneNumber(phoneNumber);
    updateAddress(address);
  }

  protected final String getContactId() { 
    // Getter for contactId
    return contactId; 
  }

  protected final String getFirstName() { 
    // Getter for firstName
    return firstName; 
  }

  protected final String getLastName() { 
    // Getter for lastName
    return lastName;
  }

  protected final String getPhoneNumber() { 
    // Getter for phoneNumber
    return phoneNumber; 
  }

  protected final String getAddress() { 
    // Getter for address
    return address; 
  }

  protected void updateFirstName(String firstName) {
    // Update the firstName attribute
    if (firstName == null) {
      throw new IllegalArgumentException("First name can't be empty");
    } else if (firstName.length() > CONTACT_FNAME_LENGTH) {
      throw new IllegalArgumentException("First name can't be longer than " + CONTACT_FNAME_LENGTH + " characters");
    } else {
      this.firstName = firstName;
    }
  }

  protected void updateLastName(String lastName) {
    // Update the lastName attribute
    if (lastName == null) {
      throw new IllegalArgumentException("Last name can't be empty");
    } else if (lastName.length() > CONTACT_LNAME_LENGTH) {
      throw new IllegalArgumentException("Last name can't be longer than " + CONTACT_LNAME_LENGTH + " characters");
    } else {
        this.lastName = lastName;
      }
    }

    protected void updatePhoneNumber(String phoneNumber) {
      // Update the phoneNumber attribute
      String regex = "[0-9]+";
      if (phoneNumber == null) {
        throw new IllegalArgumentException("Phone number can't be empty.");
      } else if (phoneNumber.length() != CONTACT_PHONENUM_LENGTH) {
        throw new IllegalArgumentException("Phone number length invalid. Ensure it is " + CONTACT_PHONENUM_LENGTH + " digits.");
      } else if (!phoneNumber.matches(regex)) {
        throw new IllegalArgumentException("Phone number can't have anything but numbers");
      } else {
        this.phoneNumber = phoneNumber;
      }
    }

    protected void updateAddress(String address) {
      // Update the address attribute
      if (address == null) {
        throw new IllegalArgumentException("Address can't be empty");
      } else if (address.length() > CONTACT_ADDRESS_LENGTH) {
        throw new IllegalArgumentException("Address can't be longer than " + CONTACT_ADDRESS_LENGTH + " characters");
      } else {
        this.address = address;
      }
    }

    protected void updateContactId(String contactId) {
      // Update the contactId attribute
      if (contactId == null) {
        throw new IllegalArgumentException("Contact ID cannot be empty");
      } else if (contactId.length() > CONTACT_ID_LENGTH) {
        throw new IllegalArgumentException("Contact ID cannot be longer than " + CONTACT_ID_LENGTH + " characters");
      } else {
        this.contactId = contactId;
      }
    }
  }
