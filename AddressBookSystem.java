import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressBookSystem {
    private Map<String, AddressBook> addressBooks;
    private Scanner scanner;

    public AddressBookSystem() {
        addressBooks = new HashMap<>();
        scanner = new Scanner(System.in);
    }

    public void createAddressBook() {
        System.out.println("Enter the name of the address book: ");
        String name = scanner.next();
        if (addressBooks.containsKey(name)) {
            System.out.println("Address book with this name already exists!");
            return;
        } else {
            AddressBook addressBook = new AddressBook(name);
            addressBooks.put(name, addressBook);
            System.out.println("Address book" + name + " created successfully!");
        }
    }

    public AddressBook selectAddressBook() {
        System.out.println("Enter the name of the address book: ");
        String name = scanner.next();
        if (addressBooks.containsKey(name)) {
            return addressBooks.get(name);
        } else {
            System.out.println("Address book with this name does not exist!");
            return null;
        }
    }

    public void displayAddressBooks() {
        if (addressBooks.isEmpty()) {
            System.out.println("No address books to display!");
        } else {
            for (String name : addressBooks.keySet()) {
                System.out.println(name);
            }
            System.out.println();
        }
    }

    public void start() {
        int choice;
        do {
            System.out.println("Address Book System");
            System.out.println("1. Create Address Book");
            System.out.println("2. Select Address Book");
            System.out.println("3. Display Address Books");
            System.out.println("4. Exit");

            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice) {
                case 1:
                    createAddressBook();
                    break;
                case 2:
                    AddressBook addressBook = selectAddressBook();
                    if (addressBook != null) {
                        addressBook.start();
                    }
                    break;
                case 3:
                    displayAddressBooks();
                    break;
            }
        } while (choice != 4);
        scanner.close();
    }

    public static void main(String[] args) {
        AddressBookSystem addressBookSystem = new AddressBookSystem();
        addressBookSystem.start();
    }
}
