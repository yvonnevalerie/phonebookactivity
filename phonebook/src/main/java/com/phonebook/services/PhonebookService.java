package com.phonebook.services;

import com.phonebook.models.Contact;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;


public class PhonebookService {

    private HashMap<String, Contact> contacts = new HashMap<>();

    public void addContact(Contact contact) {
        contacts.put(contact.getName(), contact);
    }

    public Contact searchContact(String name) {
        return contacts.get(name);
    }

    public boolean removeContact(String name) {
        return contacts.remove(name) != null;
    }

     public void displayAllContacts() {
        if (contacts.isEmpty()) {
            System.out.println("Phonebook is empty.");
            return;
        }

        for (Contact contact : contacts.values()) {
            System.out.println(contact);
        }
    }

    public void saveToCSV(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Contact contact : contacts.values()) {
                writer.write(contact.toCsvString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
