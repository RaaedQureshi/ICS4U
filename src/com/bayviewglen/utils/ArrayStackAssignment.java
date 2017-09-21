package com.bayviewglen.utils;

public class ArrayStackAssignment {
	Object [] stack;
	int HowMany = 0;
	

	public ArrayStackAssignment() {
		stack = new Object [10];
	}
		
		public void push(Object el) {
			if (HowMany >= 10) {
				Object[] tempStack = stack;
				stack = new Object[tempStack.length*2];
				
				for (int i = 0; i < HowMany; i++) {
					stack[i] = tempStack[i];
				}
				
				stack[HowMany] = el;
				HowMany++;
				
			} else {
				stack[HowMany] = el;
				HowMany++;
			}
		}
		
		public Object pop() {
			return stack[--HowMany];
		}
		
		public Object peek() {
			return stack[HowMany - 1];
		}
		
		public boolean empty() {
			int count = 0;
			for (int i = 0; i < stack.length; i++) {
				while (stack[i].equals(null)) {
					count ++;
					
				}
				if (count == stack.length) {
					return true;
				}
				
				
				}
			
			return false;
		}

	}


