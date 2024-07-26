import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBook {
    private List<Contacts> contacts;
    private String name;
    private Scanner scanner;

    public AddressBook(String name) {
        this.name = name;
        contacts = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addContact(){
        System.out.println("Enter the first name: ");
        String firstName = scanner.next();
        System.out.println("Enter the last name: ");
        String lastName = scanner.next();
        System.out.println("Enter address: ");
        String address = scanner.next();
        System.out.println("Enter city: ");
        String city = scanner.next();
        System.out.println("Enter State: ");
        String state = scanner.next();
        System.out.println("Enter Zip code: ");
        int zip = scanner.nextInt();
        System.out.println("Enter phone number: ");
        long phoneNumber = scanner.nextLong();
        System.out.println("Enter email: ");
        String email = scanner.next();

        Contacts contact = new Contacts(email, phoneNumber, zip, state, city, address, lastName, firstName);
        contacts.add(contact);
        System.out.println("Contact added successfully!");

    }

    public void editContact() {
        System.out.println("Enter first name to Edit: ");
        String firstName = scanner.next();
        boolean found = false;
        for (Contacts contact : contacts) {
            if (contact.getFirstName().equals(firstName)) {
                System.out.println("Contact found! Enter what you want to edit: ");
                System.out.println("1. First Name");
                System.out.println("2. Last Name");
                System.out.println("3. Address");
                System.out.println("4. City");
                System.out.println("5. State");
                System.out.println("6. Zip Code");
                System.out.println("7. Phone Number");
                System.out.println("8. Email");
                System.out.println("9. Exit");

                System.out.println("Enter your choice: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("Enter new first name: ");
                        contact.setFirstName(scanner.next());
                        break;
                    case 2:
                        System.out.println("Enter new last name: ");
                        contact.setLastName(scanner.next());
                        break;
                    case 3:
                        System.out.println("Enter new address: ");
                        contact.setAddress(scanner.next());
                        break;
                    case 4:
                        System.out.println("Enter new city: ");
                        contact.setCity(scanner.next());
                        break;
                    case 5:
                        System.out.println("Enter new state: ");
                        contact.setState(scanner.next());
                        break;
                    case 6:
                        System.out.println("Enter new zip code: ");
                        contact.setZip(scanner.nextInt());
                        break;
                    case 7:
                        System.out.println("Enter new phone number: ");
                        contact.setPhoneNumber(scanner.nextLong());
                        break;
                    case 8:
                        System.out.println("Enter new email: ");
                        contact.setEmail(scanner.next());
                        break;
                    case 9:
                        break;
                    default:
                        System.out.println("Invalid choice! Please enter a valid choice.");
                        break;
                }

                System.out.println("Contact updated successfully!");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Contact not found!");
        }
    }
    public void deleteContact() {
        System.out.println("Enter first name to delete: ");
        String firstName = scanner.next();
        boolean found = false;
        for (Contacts contact : contacts) {
            if (contact.getFirstName().equals(firstName)) {
                contacts.remove(contact);
                System.out.println("Contact deleted successfully!");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Contact not found!");
        }

    }

    public void displayContacts(){
        if(contacts.isEmpty()){
            System.out.println("No contacts to display!");
        } else {
            for (Contacts contact : contacts) {
                System.out.println(contact);
            }
            System.out.println();
        }
    }

    public void start(){
        int choice;
        do{
            System.out.println("Address Book: " + name);
            System.out.println("1. Add Contact");
            System.out.println("2. Edit Contact");
            System.out.println("3. Delete Contact");
            System.out.println("4. Display Contacts");
            System.out.println("5. Exit");

            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice){
                case 1:
                    addContact();
                    break;
                case 2:
                    editContact();
                    break;
                case 3:
                    deleteContact();
                    break;
                case 4:
                    displayContacts();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a valid choice.");
                    break;
            }
        }while (choice != 5);
    }

    public String getName() {
        return name;
    }
    
}
