package com.bayviewglen.contacttree;

import java.util.Scanner;

public class ContactDriver {

	public static void main(String[] args) {
		
		AddressBook numbers = new AddressBook();
	    Scanner keyboard = new Scanner (System.in);
	    String choice, first, last, phone;
	    boolean book = true;
	   
	    
	    numbers.welcomeMessage();
	    numbers.menu();
	    while (book == true) {
	     choice = keyboard.nextLine();
	     if (choice.equals("1")) {
	    	 System.out.println("Please enter the contacts first name: ");
	    	 first = keyboard.nextLine();
	    	 System.out.println("Please enter the contacts last name: ");
	    	 last = keyboard.nextLine();
	    	 System.out.println("Please enter the contacts number: ");
	    	 phone = keyboard.nextLine();
	    	 while (numbers.numberChecker(phone) == false)
	    		 phone = keyboard.nextLine();
	    	 numbers.addContact(last, first, phone);
	    	 System.out.println(first + " " + last + " has been added.");
	    	 numbers.menu();
	     } else if(choice.equals("2")) {
	    	 if (AddressBook.numContacts == 0) {
	    		 System.out.println("You have no friends and have no contacts.");
	    		 numbers.menu();
	    	 }
	    	 
	    	 else{ 
	    		 numbers.display();
	    		 numbers.menu();
	    	 }
	     } else if(choice.equals("3")) {
	    	 System.out.println("Please enter the first name of the contact: ");
	    	 first = keyboard.nextLine();
	    	 System.out.println("Please enter the last name of the contact: ");
	    	 last = keyboard.nextLine();
	    	 numbers.searchContact(last, first);
	    	 numbers.menu();
	     } else if (choice.equals("4")) {
	    	 System.out.println("Please enter the first name of the contact: ");
	    	 first = keyboard.nextLine();
	    	 System.out.println("Please enter the last name of the contact: ");
	    	 last = keyboard.nextLine();
	    	 numbers.removeContact(last,first);
	    	 numbers.menu();
	     } else if (choice.equals("5")) {
	    	 System.out.println("Thank you for using my address book, goodbye.");
	    	 book = false;
	     }
	    	 
	     		
	   
	    }
		
		}
	
	
	

}
