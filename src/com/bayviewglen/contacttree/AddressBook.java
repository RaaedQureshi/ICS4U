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
	
	public static String numberChecker(String input) { // checks valid phone number
		int length = 10;
		Scanner keyboard = new Scanner(System.in);
		boolean valid = true;
		String numbers = "0123456789";

		for (int i = 0; i < input.length() && valid == true; i++) {
			if (numbers.indexOf(input.substring(i, i + 1)) == -1) {
				valid = false;
			}
		}
		if (input.length() != length) {
			valid = false;
		}

		while (!valid) {
			valid = true;
			System.out.print("Please enter a 10-digit number: ");
			input = keyboard.nextLine();

			for (int i = 0; i < input.length() && valid == true; i++) {
				if (numbers.indexOf(input.substring(i, i + 1)) == -1) {
					valid = false;
				}
			}
			if (input.length() != length) {
				valid = false;
			}
		}

		return input;
	}


	

	public void menu() {
		System.out.println("\n1: Add contact\n2: Display contacts\n3: Search\n4: Delete contact\n5: Exit");
	}

}
