package com.bayviewglen.arrays;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class AddressBook {
	private Contact[] contacts;
	private int numContacts;
	
	public AddressBook() {
		contacts = new Contact [1000];
		numContacts = 0;
	}
	
	public void addContact (String lastName, String firstName, String phone) {
		contacts[numContacts++] = new Contact(lastName, firstName, phone);
		
	}
	
	public void removeContact (String lastName, String firstName) {
		if(numContacts == 0)
			System.out.println("There are no contacts in this book...");;
			int index = 0;
			for (int i = 0; i < numContacts; i++) {
				if (contacts[i].getLast().equals(lastName) && contacts[i].getFirst().equals(firstName)) {
				  index = i;
				}
		
		if(index == -1) {
			System.out.println("The contact doesn't exist...");;
		}
		for(int i1 = index; i1<numContacts;i1++) {
			contacts[i1] = contacts[i1+1];
		}
		numContacts--;
			}
	}
		
	
	
	public void searchContact (String lastName, String firstName) {
		for (int i = 0; i < numContacts; i++) {
			if (contacts[i].getLast().equals(lastName) && contacts[i].getFirst().equals(firstName)) {
				System.out.println(contacts[i]);
			} else {
				System.out.println("This contact doesn't exist");
			}
		} 
		
	}
	
	public void display() {
		if(numContacts == 0) {
			System.out.println("There's nothing in this address book.");
		}
		System.out.println();

		for(int i = 0; i < numContacts; i++) {
			System.out.println(contacts[i]);
		}
	}
	
	public void read() {
		try {
			Scanner input = new Scanner(new File("data/contacts.dat"));
			numContacts = Integer.parseInt(input.nextLine());
			for(int i= 0; i<numContacts; i++) {
				String line = input.nextLine(); 
				contacts[i] = new Contact(line.split("_")[0], line.split("_")[1], line.split("_")[2]);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void exit() {
		FileWriter fw;
		try {
			fw = new FileWriter(new File("data/contacts.dat"));
			fw.write(numContacts + "\n");

			for(int i= 0; i<numContacts; i++) {
				fw.write(contacts[i].getLast() + "_" + contacts[i].getFirst() + "_" + contacts[i].getPhone() + "\n");
			}			
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
	}
	
	
	
	

		


	

}
