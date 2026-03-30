package com.phonebook;

import java.util.Scanner;

import com.phonebook.models.Contact;
import com.phonebook.services.PhonebookService;

public class App {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        PhonebookService service = new PhonebookService();

        String filename = "contacts.csv";

        service.loadFromCSV(filename);

        int choice;

        do {
           System.out.println("""
            -----------------
           |  PHONEBOOK MENU |
            -----------------
             1. Add
             2. Search
             3. Remove
             4. Display All
             5. Save to CSV
             0. Exit
                   
                   """);

            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {

                case 1:
                    System.out.print("Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Phone: ");
                    String phone = scanner.nextLine();

                    System.out.print("Email: ");
                    String email = scanner.nextLine();

                    service.addContact(new Contact(name, phone, email));
                    System.out.println("Contact added.");
                    break;

                case 2:
                    System.out.print("Enter name to search: ");
                    String searchName = scanner.nextLine();

                    Contact found = service.searchContact(searchName);

                    if (found != null) {
                        System.out.println("Found: " +
                                found.getName() + " | " +
                                found.getPhoneNumber() + " | " +
                                found.getEmail());
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter name to remove: ");
                    String removeName = scanner.nextLine();

                    service.removeContact(removeName);
                    System.out.println("Contact removed.");
                    break;

                case 4:
                    service.displayAll();
                    break;

                case 5:
                    service.saveToCSV(filename);
                    break;

                case 0:
                    service.saveToCSV(filename);
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);

        scanner.close();
    }
}
