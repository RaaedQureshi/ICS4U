package com.bayviewglen.list;

public class LinkedList {
	private IntNode head;
	private int numNodes;
	private IntNode tail;

	public LinkedList() {
		head = null;
		tail = null;
		numNodes = 0;
	}

	public void addFirst(int x) {  //Inserts the specified element at the beginning of this list.
		head = new IntNode(x, head);
		if (numNodes == 0)
			tail = head;
		numNodes++;
	}

	public boolean add(int x) {  //Appends the specified element to the end of this list.
		if (numNodes == 0) {
			addFirst(x);
		} else {

			IntNode temp = new IntNode(x, null);
			tail.setLink(temp);
			tail = temp;

			numNodes++;
		}
		return true;

	}

	public void add(int index, int value) {  //Inserts the specified element at the specified position in this list.
		IntNode current = head;
		if (index == 0) {
			addFirst(value);
		} else if (index == numNodes - 1) {
			add(value);
			
		} else if (index > 0 && index < numNodes - 1) {
			for (int i = 0; i < index; i++) {
				current = current.getLink();
			}
			IntNode temp = new IntNode(value, current.getLink());
			current.setLink(temp);
			numNodes++;
		}

	}

	public void clear() {  //Removes all of the elements from this list.
		head = null;
		tail = null;
		numNodes = 0;

	}

	public IntNode remove() {  //Retrieves and removes the head (first element) of this list.
		IntNode temp = head;
		head = head.getLink();
		numNodes--;
		return temp;

	}

	public int[] toArray() {  //Returns an array containing all of the elements in this list in proper sequence (from first to last element).
		int[] array = new int[numNodes];
		IntNode current = head;
		for (int i = 0; i < numNodes; i++) {
			array[i] = current.getData();

			current = current.getLink();
		}

		return array;

	}

	public int size() {  //Returns the number of elements in this list.
		return numNodes;
	}

	public IntNode getFirst() {  //Returns the first element in this list.
		if (numNodes == 0)
			System.out.println("There is nothing in this linked list.");
		return head;
	}

	public IntNode getLast() {  //Returns the last element in this list.
		if (numNodes == 0)
			System.out.println("There is no tail in this linked list.");
		return tail;
	}

	public boolean contains(int o) {  //Returns true if this list contains the specified element.
		IntNode temp = head;
		for (int i = 0; i < numNodes - 1; i++) {
			temp = temp.getLink();
			if (temp.getData() == o) {
				return true;
			}

		}
		return false;

	}

	public IntNode get(int index) { // index must be 1 or higher, Returns the element at the specified position in this list.

		if (index <= 0)
			System.out.println("This linked list is empty.");
		;

		IntNode current = head.getLink();
		for (int i = 1; i < index; i++) {
			if (current.getLink() == null)
				return null;

			current = current.getLink();
		}
		return current;

	}

	public int removeLast() {  //Removes and returns the last element from this list.
		IntNode temp = head;
		for (int i = 0; i < numNodes - 2; i++) {
			temp = temp.getLink();
		}
		IntNode newTail = tail;
		temp.setLink(newTail);
		numNodes--;
		return newTail.getData();
		

	}
	
	public boolean booleanRemove (int o) {  //Removes the first occurrence of the specified element from this list, if it is present.
		int [] arr = toArray(); //Make an array of intnodes, find the index and then remove it.
		int count = 0;
		
		while (count < 1) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == o) {
				remove(i);
				count++;
				return true;
			}
		}
		}
 		return false;
		
		
	}

	public boolean removeFirstOccurence(int o) {  //Removes the first occurrence of the specified element in this list (when traversing the list from head to tail).
		return booleanRemove(o);
	}

	public boolean removeLastOccurence(int o) {  //Removes the last occurrence of the specified element in this list (when traversing the list from head to tail).
		int [] arr = toArray();   //Make an array of intnodes, find the index and then remove it.
		int count = 0;
		while (count < 1) {
		for (int i = arr.length-1; i >= 0; i--) {
			if (arr[i] == o) {
				count++;
				remove(i);
				return true;
			}
		}
		}
		return false;

	}

	public IntNode set(int index, IntNode element) {  //Replaces the element at the specified position in this list with the specified element.
		IntNode current = head;
		for (int i = 0; i < index; i++) {
			current = current.getLink();
		}
		current.setData(element.getData());
		return current;

	}

	public int remove(int index) {  //Removes the element at the specified position in this list.
		IntNode temp = head;
		int retValue = 0;
		if (index == 0) {
			remove();
		}else if (index == numNodes-1){
				removeLast();
				
			
		} else {
			for (int i = 0; i < index-1; i++) {
				temp = temp.getLink();
			}
			IntNode remover = temp.getLink();
			retValue = remover.getData();
			temp.setLink(remover.getLink());
			numNodes--;
		}
		return retValue;
	}

}
