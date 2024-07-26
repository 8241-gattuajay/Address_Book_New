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
}
