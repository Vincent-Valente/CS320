import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactTest {
  protected String contactId, firstNameTest, lastNameTest, phoneNumberTest, addressTest;
  protected String tooLongContactId, tooLongFirstName, tooLongLastName, tooLongPhoneNumber, tooShortPhoneNumber, tooLongAddress;

  @BeforeEach
  void setUp() {
    // Initialize test data
    contactId = "8977F847A2";
    firstNameTest = "Mary";
    lastNameTest = "Lamb";
    phoneNumberTest = "5556662222";
    addressTest = "7 Test Street Makeup NY 11221";
    tooLongContactId = "641546546555555146";
    tooLongFirstName = "Larry Large Little";
    tooLongLastName = "-deMarcus Cartsonston";
    tooLongPhoneNumber = "61554999155";
    tooShortPhoneNumber = "6555148";
    tooLongAddress = "1234 Longpark testville Drive, Makeup, NY 12221";
  }

  @Test
  void contactTest() {
    // Test default constructor
    Contact contact = new Contact();
    assertAll("constructor",
        () -> assertNotNull(contact.getContactId()), // Verify contactId is not null
        () -> assertNotNull(contact.getFirstName()), // Verify firstName is not null
        () -> assertNotNull(contact.getLastName()), // Verify lastName is not null
        () -> assertNotNull(contact.getPhoneNumber()), // Verify phoneNumber is not null
        () -> assertNotNull(contact.getAddress()) // Verify address is not null
    );
  }

  @Test
  void contactIdConstructorTest() {
    // Test constructor with contactId parameter
    Contact contact = new Contact(contactId);
    assertAll("constructor one",
        () -> assertEquals(contactId, contact.getContactId()), // Verify specified contactId
        () -> assertNotNull(contact.getFirstName()), // Verify firstName is not null
        () -> assertNotNull(contact.getLastName()), // Verify lastName is not null
        () -> assertNotNull(contact.getPhoneNumber()), // Verify phoneNumber is not null
        () -> assertNotNull(contact.getAddress()) // Verify address is not null
    );
  }

  @Test
  void contactIdAndFirstNameConstructorTest() {
    // Test constructor with contactId and firstName parameters
    Contact contact = new Contact(contactId, firstNameTest);
    assertAll("constructor two",
        () -> assertEquals(contactId, contact.getContactId()), // Verify specified contactId
        () -> assertEquals(firstNameTest, contact.getFirstName()), // Verify specified firstName
        () -> assertNotNull(contact.getLastName()), // Verify lastName is not null
        () -> assertNotNull(contact.getPhoneNumber()), // Verify phoneNumber is not null
        () -> assertNotNull(contact.getAddress()) // Verify address is not null
    );
  }

  @Test
  void contactIdAndFullNameConstructorTest() {
    // Test constructor with contactId, firstName, and lastName parameters
    Contact contact = new Contact(contactId, firstNameTest, lastNameTest);
    assertAll("constructor three",
        () -> assertEquals(contactId, contact.getContactId()), // Verify specified contactId
        () -> assertEquals(firstNameTest, contact.getFirstName()), // Verify specified firstName
        () -> assertEquals(lastNameTest, contact.getLastName()), // Verify specified lastName
        () -> assertNotNull(contact.getPhoneNumber()), // Verify phoneNumber is not null
        () -> assertNotNull(contact.getAddress()) // Verify address is not null
    );
  }

  @Test
  void contactIdFullNamePhoneNumberConstructorTest() {
    // Test constructor with contactId, firstName, lastName, and phoneNumber parameters
    Contact contact = new Contact(contactId, firstNameTest, lastNameTest, phoneNumberTest);
    assertAll("constructor four",
        () -> assertEquals(contactId, contact.getContactId()), // Verify specified contactId
        () -> assertEquals(firstNameTest, contact.getFirstName()), // Verify specified firstName
        () -> assertEquals(lastNameTest, contact.getLastName()), // Verify specified lastName
        () -> assertEquals(phoneNumberTest, contact.getPhoneNumber()), // Verify specified phoneNumber
        () -> assertNotNull(contact.getAddress()) // Verify address is not null
    );
  }

  @Test
  void allTheProperThingsConstructorTest() {
    // Test constructor with all parameters
    Contact contact = new Contact(contactId, firstNameTest, lastNameTest, phoneNumberTest, addressTest);
    assertAll("constructor all",
        () -> assertEquals(contactId, contact.getContactId()), // Verify specified contactId
        () -> assertEquals(firstNameTest, contact.getFirstName()), // Verify specified firstName
        () -> assertEquals(lastNameTest, contact.getLastName()), // Verify specified lastName
        () -> assertEquals(phoneNumberTest, contact.getPhoneNumber()), // Verify specified phoneNumber
        () -> assertEquals(addressTest, contact.getAddress()) // Verify specified address
    );
  }

  @Test
  void updateFirstNameTest() {
    // Test updating the first name
    Contact contact = new Contact();
    contact.updateFirstName(firstNameTest);
    assertAll("first name",
        () -> assertEquals(firstNameTest, contact.getFirstName()), // Verify updated firstName
        () -> assertThrows(IllegalArgumentException.class, () -> contact.updateFirstName(null)), // Verify null firstName throws exception
        () -> assertThrows(IllegalArgumentException.class, () -> contact.updateFirstName(tooLongFirstName)) // Verify too long firstName throws exception
    );
  }

  @Test
  void updateLastNameTest() {
    // Test updating the last name
    Contact contact = new Contact();
    contact.updateLastName(lastNameTest);
    assertAll("last name",
        () -> assertEquals(lastNameTest, contact.getLastName()), // Verify updated lastName
        () -> assertThrows(IllegalArgumentException.class, () -> contact.updateLastName(null)), // Verify null lastName throws exception
        () -> assertThrows(IllegalArgumentException.class, () -> contact.updateLastName(tooLongFirstName)) // Verify too long lastName throws exception
    );
  }

  @Test
  void updatePhoneNumberTest() {
    // Test updating the phone number
    Contact contact = new Contact();
    contact.updatePhoneNumber(phoneNumberTest);
    assertAll("phone number",
        () -> assertEquals(phoneNumberTest, contact.getPhoneNumber()), // Verify updated phoneNumber
        () -> assertThrows(IllegalArgumentException.class, () -> contact.updatePhoneNumber(null)), // Verify null phoneNumber throws exception
        () -> assertThrows(IllegalArgumentException.class, () -> contact.updatePhoneNumber(tooLongPhoneNumber)), // Verify too long phoneNumber throws exception
        () -> assertThrows(IllegalArgumentException.class, () -> contact.updatePhoneNumber(tooShortPhoneNumber)), // Verify too short phoneNumber throws exception
        () -> assertThrows(IllegalArgumentException.class, () -> contact.updatePhoneNumber(contactId)) // Verify phoneNumber same as contactId throws exception
    );
  }

  @Test
  void updateAddressTest() {
    // Test updating the address
    Contact contact = new Contact();
    contact.updateAddress(addressTest);
    assertAll("address",
        () -> assertEquals(addressTest, contact.getAddress()), // Verify updated address
        () -> assertThrows(IllegalArgumentException.class, () -> contact.updateAddress(null)), // Verify null address throws exception
        () -> assertThrows(IllegalArgumentException.class, () -> contact.updateAddress(tooLongAddress)) // Verify too long address throws exception
    );
  }

  @Test
  void updateContactIdTest() {
    // Test updating the contactId
    Contact contact = new Contact();
    contact.updateContactId(contactId);
    assertAll("contact ID",
        () -> assertEquals(contactId, contact.getContactId()), // Verify updated contactId
        () -> assertThrows(IllegalArgumentException.class, () -> contact.updateContactId(null)), // Verify null contactId throws exception
        () -> assertThrows(IllegalArgumentException.class, () -> contact.updateContactId(tooLongContactId)) // Verify too long contactId throws exception
    );
  }
}
