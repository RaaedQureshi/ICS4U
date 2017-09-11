package com.bayviewglen.arrays;

public class Contact implements Comparable {
	private String last = getLast();
	private String first = getFirst();
	private String phone;
	
	public Contact() {
		
	}
	
	public String toString() {
		String editedNumber = "(" + phone.substring(0, 3) + ") " + phone.substring(3,6) + "-" + phone.substring(6,10);
		return first + " " + last + " " + editedNumber;
	}
	
	public String getLast() {
		return last;
	}
	public Contact(String last, String first, String phone) {
		super();
		this.last = last;
		this.first = first;
		this.phone = phone;
	}
	public void setLast(String last) {
		this.last = last;
	}
	public String getFirst() {
		return first;
	}
	public void setFirst(String first) {
		this.first = first;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public int compareTo(Object o) {
		Contact c = (Contact) o;
		String a = this.last + this.first;
		String b = c.last + c.first;
		
		return a.compareTo(b);
	}

}
