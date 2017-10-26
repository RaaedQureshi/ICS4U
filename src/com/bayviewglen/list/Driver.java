package com.bayviewglen.list;

public class Driver {

	public static void main(String[] args) {
		LinkedList x = new LinkedList();
		
		x.add(1);
		x.add(3);
		x.add(5);
		x.add(7);
		
		x.add(0,5742);
		x.add(2);
		x.add(3);
		x.add(8);
		x.add(9);
		x.add(10);
		x.add(5742);
		x.add(8);
		x.add(3);
		x.add(8);
		x.add(9);
		x.add(10);
		x.add(5742);
		

		display(x.toArray());
		x.remove(2);
		x.booleanRemove(5742);
		x.removeFirstOccurence(3);
		x.removeLastOccurence(8);
	    
	    


		display(x.toArray());
		
		
		
	}
	public static void display(int[] arr) {
		for(int y : arr) {
			System.out.print(y + ", ");
		}
		System.out.println();
	}

}
