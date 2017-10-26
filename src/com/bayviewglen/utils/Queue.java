package com.bayviewglen.utils;

public class Queue {
	Object [] queue;
	int HowMany = 0;
	
	public Queue() {
		queue = new Object [10];
	}
	
	public void enqueue (Object el) {
		if (HowMany >= 10) {
			Object[] tempqueue = queue;
			queue = new Object[tempqueue.length*2];
			
			for (int i = 0; i < HowMany; i++) {
				queue[i] = tempqueue[i];
			}
			for (int i = 0; i < queue.length; i++) {
				queue[i+1] = queue[i];
			}
			queue[HowMany] = el;
			HowMany++;
			
		} else {
			
			queue[HowMany] = el;
			HowMany++;
		}

}
	public Object dequeue () {
		Object firstIndex = queue[0];
		for (int i = 0; i < queue.length; i++) {
			queue[i] = queue[i+1];
		}
		return firstIndex;
		
	}
	
	public Object peek () {
		return queue[0];
		
	}
	
	public void clear() {
		for (int i = 0; i < queue.length; i++) {
			queue[i] = null;
		}
		
	}
	
	public boolean empty() {
		if (HowMany == 0) {
			return true;
		}
		return false;
		
	}
	
}
