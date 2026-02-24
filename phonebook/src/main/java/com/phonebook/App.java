package com.phonebook;

import java.util.Scanner;

import com.phonebook.models.Contact;
import com.phonebook.services.PhonebookService;

public class App {
    public static void main(String[] args) {

        PhonebookService service = new PhonebookService();
        Scanner scanner = new Scanner(System.in);

        int choice;

        do{
            System.out.println("""
                    -----------------------
                   |     PHONEBOOK MENU    |
                    -----------------------
                   | |1| ADD               |
                   | |2| SEARCH            |
                   | |3| REMOVE            |
                   | |4| DISPLAY ALL       |
                   | |5| SAVE TO CSV       |
                   | |0| EXIT              |
                    -----------------------

                    """);
            System.out.print("Enter Choice:");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter Name:");
                    String name = scanner.nextLine();
                    System.out.println("Enter Phone Number:");
                    String phoneNumber = scanner.nextLine();
                    System.out.println("Enter Email:");
                    String email = scanner.nextLine();
                    Contact contact = new Contact(name , phoneNumber , email);
                    service.addContact(contact);
                    break;

                case 2:
                    System.out.print("Enter name to search: ");
                    String searchName = scanner.nextLine();

                    Contact found = service.searchContact(searchName);
                    if (found != null) {
                        System.out.println(found);
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;

                 case 3:
                    System.out.print("Enter name to remove: ");
                    String removeName = scanner.nextLine();

                    boolean removed = service.removeContact(removeName);
                    if (removed) {
                        System.out.println("Contact removed.");
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;
                
                case 4:
                    service.displayAllContacts();
                    break;

                case 5:
                    service.saveToCSV("contacts.csv");
                    break;

                case 0:
                    System.out.println("Exiting application...");
                    break;


                 default:
                    System.out.println("Invalid option. Try again.");
            }

        } while (choice != 0);

        scanner.close();
    }
}


