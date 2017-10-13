package com.bayviewglen.contacttree;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import com.bayviewglen.contacttree.Contact;

public class AddressBook {
	private BinarySearchTree contacts;
	static int numContacts;

	public AddressBook() {
		contacts = new BinarySearchTree();
		numContacts = 0;
	}

	public String toString() { // Traverses through the tree in order
		contacts.inorderTraversal(contacts.getRoot());
		return ("");
	}

	public void welcomeMessage() { // Welcomes users to my address book.
		System.out.println("Welcome to Raaed's addressbook. \n");
	}

	public void addContact(String lastName, String firstName, String phone) { // Adds a contact to my address book.
		contacts.add(new Contact(lastName, firstName, phone));
		numContacts++;

	}

	public void removeContact(String lastName, String firstName) { // Removes a contact from my address book.
		contacts.delete(firstName, lastName);
		numContacts--;
	}

	public void searchContact(String lastName, String firstName) { // Search for a contact
		System.out.println(contacts.search(firstName, lastName));

	}

	public void display() { // Display all contacts
		if (numContacts == 0) {
			System.out.println("There's nothing in this address book.");
		}
		System.out.println("These are your contacts: \n");
		contacts.inorderTraversal(contacts.getRoot());
	}

	public boolean numberChecker(String phone) {
		boolean number = true;
		String numbers = "1234567890";
		for (int i = 0; i < phone.length() && number; i++) {
			if (numbers.indexOf(phone.substring(i, i + 1)) < 0) {
				number = false;
			}
		}
		if (phone.length() == 10 && number == true)
			return true;
		else {
			Scanner keyboard = new Scanner(System.in);
			number = true;
			System.out.println("Please enter a number with 10 digits.");
			while (phone.length() == 10 && number) {
				phone = keyboard.nextLine();
				for (int i = 0; i < phone.length() && number; i++) {
					if (phone.substring(i, i + 1).indexOf(numbers) < 0) {
						number = false;
					}
				}
			}
			return true;
		}

	}

	public void menu() {
		System.out.println("\n1: Add contact\n2: Display contacts\n3: Search\n4: Delete contact\n5: Exit");
	}

}
