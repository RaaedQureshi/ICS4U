package com.bayviewglen.arrays;

import java.util.Scanner;

public class AddressBookDriver {

	public static void main(String[] args) {
		AddressBook contacts = new AddressBook();
		Scanner keyboard = new Scanner (System.in);
		
		String phone;
		boolean book = true;
		
		
		
		while (book) {
		System.out.println("Welcome to my address book \n");
		System.out.println("If you want to remove a contact, type 'remove'.\nIf you want to add a contact, type 'add'.\nIf you want to search for a contact, type 'search'.\nIf you want to display all contacts type 'display'.\nType 'exit' if you want to leave the address book.");
		String word = keyboard.nextLine();
		if (word.equals("remove")) {
			System.out.println("Please type the last name of the person you want to delete.");
			String lastName = keyboard.nextLine();
			System.out.println("Please type the first name of the person you want to delete.");
			String firstName = keyboard.nextLine();
			contacts.removeContact(lastName , firstName);
		}
		if (word.equals("add")) {
			System.out.println("Please type the last name of the person you want to add.");
			String lastName = keyboard.nextLine();
			System.out.println("Please type the first name of the person you want to add.");
			String firstName = keyboard.nextLine();
			System.out.println("Please add the number of the person you want to add, it must be 10 digits, if it is not the addressbook will only save the first 10 digits.");
			phone = keyboard.nextLine();
			contacts.addContact(lastName, firstName, phone);
			
		}
		
		else if (word.equals("exit")) {
			System.out.println("Thank you for using my address book, goodbye");
			contacts.exit();
			book = false;
			
		}
		
		else if (word.equals("search")) {
			System.out.println("What is their last name?");
			String lastName = keyboard.nextLine();
			System.out.println("What is their first name?");
			String firstName = keyboard.nextLine();
			contacts.searchContact(lastName, firstName);
			
		}
		
		else if (word.equals("display")) {
			contacts.display();

		}
		
		else { 
			System.out.println("Please enter one of the options above.");
		}
		
		
		}
		

	}

}
