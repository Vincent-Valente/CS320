import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {
  // Test data for contact attributes
  protected String contactId, firstNameTest, lastNameTest, phoneNumberTest, addressTest;
  protected String tooLongContactId, tooLongFirstName, tooLongLastName, tooLongPhoneNumber, tooShortPhoneNumber, tooLongAddress;

  @BeforeEach
  void setUp() {
    // Initialize test data
    contactId = "45859S884W";
    firstNameTest = "Sarah";
    lastNameTest = "Parker";
    phoneNumberTest = "2122122155";
    addressTest = "7 Test street Makeup NY 11221";
    tooLongContactId = "998878788455146612";
    tooLongFirstName = "Amber Saint Marcus";
    tooLongLastName = "-alexander Pallock";
    tooLongPhoneNumber = "99465881224";
    tooShortPhoneNumber = "6577777";
    tooLongAddress = "1234 Long Drive, Makeup, NY 11221";
  }

  @Test
  void newContactTest() {
    ContactService service = new ContactService();
    // Test creating new contacts with different parameters
    service.newContact();
    assertAll(
        "service",
        ()
            -> assertNotNull(service.getContactList().get(0).getContactId()), // Verify that contactId is not null
        ()
            -> assertEquals("INITIAL", service.getContactList().get(0).getFirstName()), // Verify initial firstName
        ()
            -> assertEquals("INITIAL", service.getContactList().get(0).getLastName()), // Verify initial lastName
        ()
            -> assertEquals("5684225988", service.getContactList().get(0).getPhoneNumber()), // Verify initial phoneNumber
        ()
            -> assertEquals("INITIAL", service.getContactList().get(0).getAddress()) // Verify initial address
    );
    service.newContact(firstNameTest);
    assertAll(
        "service",
        ()
            -> assertNotNull(service.getContactList().get(1).getContactId()), // Verify that contactId is not null
        ()
            -> assertEquals(firstNameTest, service.getContactList().get(1).getFirstName()), // Verify specified firstName
        ()
            -> assertEquals("INITIAL", service.getContactList().get(1).getLastName()), // Verify initial lastName
        ()
            -> assertEquals("5684225988", service.getContactList().get(1).getPhoneNumber()), // Verify initial phoneNumber
        ()
            -> assertEquals("INITIAL", service.getContactList().get(1).getAddress()) // Verify initial address
    );
    service.newContact(firstNameTest, lastNameTest);
    assertAll(
        "service",
        ()
            -> assertNotNull(service.getContactList().get(2).getContactId()), // Verify that contactId is not null
        ()
            -> assertEquals(firstNameTest, service.getContactList().get(2).getFirstName()), // Verify specified firstName
        ()
            -> assertEquals(lastNameTest, service.getContactList().get(2).getLastName()), // Verify specified lastName
        ()
            -> assertEquals("5684225988", service.getContactList().get(2).getPhoneNumber()), // Verify initial phoneNumber
        ()
            -> assertEquals("INITIAL", service.getContactList().get(2).getAddress()) // Verify initial address
    );
    service.newContact(firstNameTest, lastNameTest, phoneNumberTest);
    assertAll(
        "service",
        ()
            -> assertNotNull(service.getContactList().get(3).getContactId()), // Verify that contactId is not null
        ()
            -> assertEquals(firstNameTest, service.getContactList().get(3).getFirstName()), // Verify specified firstName
        ()
            -> assertEquals(lastNameTest, service.getContactList().get(3).getLastName()), // Verify specified lastName
        ()
            -> assertEquals(phoneNumberTest, service.getContactList().get(3).getPhoneNumber()), // Verify specified phoneNumber
        ()
            -> assertEquals("INITIAL", service.getContactList().get(3).getAddress()) // Verify initial address
    );
    service.newContact(firstNameTest, lastNameTest, phoneNumberTest, addressTest);
    assertAll(
        "service",
        ()
            -> assertNotNull(service.getContactList().get(4).getContactId()), // Verify that contactId is not null
        ()
            -> assertEquals(firstNameTest, service.getContactList().get(4).getFirstName()), // Verify specified firstName
        ()
            -> assertEquals(lastNameTest, service.getContactList().get(4).getLastName()), // Verify specified lastName
        ()
            -> assertEquals(phoneNumberTest, service.getContactList().get(4).getPhoneNumber()), // Verify specified phoneNumber
        ()
            -> assertEquals(addressTest, service.getContactList().get(4).getAddress()) // Verify specified address
    );
  }

  @Test
  void deleteContactTest() {
    ContactService service = new ContactService();
    // Test deleting a contact
    service.newContact();
    assertThrows(Exception.class, () -> service.deleteContact(contactId)); // Verify exception when deleting non-existing contact
    assertAll(
        () -> service.deleteContact(service.getContactList().get(0).getContactId()) // Verify successful deletion
    );
  }

  @Test
  void updateFirstNameTest() throws Exception {
    ContactService service = new ContactService();
    // Test updating the first name of a contact
    service.newContact();
    service.updateFirstName(service.getContactList().get(0).getContactId(), firstNameTest); // Update first name
    assertEquals(firstNameTest, service.getContactList().get(0).getFirstName()); // Verify updated first name
    assertThrows(IllegalArgumentException.class, () -> service.updateFirstName(service.getContactList().get(0).getContactId(), tooLongFirstName)); // Verify exception when updating with a too long first name
    assertThrows(IllegalArgumentException.class, () -> service.updateFirstName(service.getContactList().get(0).getContactId(), null)); // Verify exception when updating with a null first name
    assertThrows(Exception.class, () -> service.updateFirstName(contactId, firstNameTest)); // Verify exception when updating non-existing contact
  }

  @Test
  void updateLastNameTest() throws Exception {
    ContactService service = new ContactService();
    // Test updating the last name of a contact
    service.newContact();
    service.updateLastName(service.getContactList().get(0).getContactId(), lastNameTest); // Update last name
    assertEquals(lastNameTest, service.getContactList().get(0).getLastName()); // Verify updated last name
    assertThrows(IllegalArgumentException.class, () -> service.updateLastName(service.getContactList().get(0).getContactId(), tooLongLastName)); // Verify exception when updating with a too long last name
    assertThrows(IllegalArgumentException.class, () -> service.updateLastName(service.getContactList().get(0).getContactId(), null)); // Verify exception when updating with a null last name
    assertThrows(Exception.class, () -> service.updateLastName(contactId, lastNameTest)); // Verify exception when updating non-existing contact
  }

  @Test
  void updatePhoneNumberTest() throws Exception {
    ContactService service = new ContactService();
    // Test updating the phone number of a contact
    service.newContact();
    service.updatePhoneNumber(service.getContactList().get(0).getContactId(), phoneNumberTest); // Update phone number
    assertEquals(phoneNumberTest, service.getContactList().get(0).getPhoneNumber()); // Verify updated phone number
    assertThrows(IllegalArgumentException.class, () -> service.updatePhoneNumber(service.getContactList().get(0).getContactId(), tooLongPhoneNumber)); // Verify exception when updating with a too long phone number
    assertThrows(IllegalArgumentException.class, () -> service.updatePhoneNumber(service.getContactList().get(0).getContactId(), tooShortPhoneNumber)); // Verify exception when updating with a too short phone number
    assertThrows(IllegalArgumentException.class, () -> service.updatePhoneNumber(service.getContactList().get(0).getContactId(), contactId)); // Verify exception when updating with the same value as contactId
    assertThrows(IllegalArgumentException.class, () -> service.updatePhoneNumber(service.getContactList().get(0).getContactId(), null)); // Verify exception when updating with a null phone number
    assertThrows(Exception.class, () -> service.updatePhoneNumber(contactId, lastNameTest)); // Verify exception when updating non-existing contact
  }

  @Test
  void updateAddressTest() throws Exception {
    ContactService service = new ContactService();
    // Test updating the address of a contact
    service.newContact();
    service.updateAddress(service.getContactList().get(0).getContactId(), addressTest); // Update address
    assertEquals(addressTest, service.getContactList().get(0).getAddress()); // Verify updated address
    assertThrows(IllegalArgumentException.class, () -> service.updateAddress(service.getContactList().get(0).getContactId(), tooLongAddress)); // Verify exception when updating with a too long address
    assertThrows(IllegalArgumentException.class, () -> service.updateAddress(service.getContactList().get(0).getContactId(), null)); // Verify exception when updating with a null address
    assertThrows(Exception.class, () -> service.updateAddress(contactId, addressTest)); // Verify exception when updating non-existing contact
  }
}
