import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ContactService {

  private String uniqueId;
  private List<Contact> contactList = new ArrayList<>();

  {
    // Generate a unique identifier for the ContactService instance
    uniqueId = UUID.randomUUID().toString().substring(
        0, Math.min(toString().length(), 10));
  }

  public void newContact() {
    // Create a new contact with a unique ID and add it to the contactList
    Contact contact = new Contact(newUniqueId());
    contactList.add(contact);
  }

  public void newContact(String firstname) {
    // Create a new contact with a unique ID and specified first name, and add it to the contactList
    Contact contact = new Contact(newUniqueId(), firstname);
    contactList.add(contact);
  }

  public void newContact(String firstname, String lastname) {
    // Create a new contact with a unique ID and specified first and last names, and add it to the contactList
    Contact contact = new Contact(newUniqueId(), firstname, lastname);
    contactList.add(contact);
  }

  public void newContact(String firstname, String lastname, String phonenumber) {
    // Create a new contact with a unique ID and specified first name, last name, and phone number, and add it to the contactList
    Contact contact = new Contact(newUniqueId(), firstname, lastname, phonenumber);
    contactList.add(contact);
  }

  public void newContact(String firstname, String lastname, String phonenumber, String address) {
    // Create a new contact with a unique ID and specified first name, last name, phone number, and address, and add it to the contactList
    Contact contact = new Contact(newUniqueId(), firstname, lastname, phonenumber, address);
    contactList.add(contact);
  }

  public void deleteContact(String id) throws Exception {
    // Remove the contact with the specified ID from the contactList
    contactList.remove(searchForContact(id));
  }

  public void updateFirstName(String id, String firstName) throws Exception {
    // Update the first name of the contact with the specified ID
    searchForContact(id).updateFirstName(firstName);
  }

  public void updateLastName(String id, String lastName) throws Exception {
    // Update the last name of the contact with the specified ID
    searchForContact(id).updateLastName(lastName);
  }

  public void updatePhoneNumber(String id, String phoneNumber) throws Exception {
    // Update the phone number of the contact with the specified ID
    searchForContact(id).updatePhoneNumber(phoneNumber);
  }

  public void updateAddress(String id, String address) throws Exception {
    // Update the address of the contact with the specified ID
    searchForContact(id).updateAddress(address);
  }

  protected List<Contact> getContactList() {
    // Get the list of contacts
    return contactList;
  }

  private String newUniqueId() {
    // Generate a new unique identifier for the contacts
    return uniqueId = UUID.randomUUID().toString().substring(0, Math.min(toString().length(), 10));
  }

  private Contact searchForContact(String id) throws Exception {
    // Search for the contact with the specified ID in the contactList
    int index = 0;
    while (index < contactList.size()) {
      if (id.equals(contactList.get(index).getContactId())) {
        return contactList.get(index);
      }
      index++;
    }
    // Throw an exception if the contact is not found
    throw new Exception("The contact doesn't exist!");
  }
}
