package com.bayviewglen.zigzag;

import java.lang.reflect.Array;

public class ZigZag {

	public static void main(String[] args) {
		int[] numbers = {0,1,1,7,4,8,8,9,10,12,6,2,2,7};
		int[] increasing = new int [numbers.length];
		int[] decreasing = new int [numbers.length];
	    increasing[0] = 1;
	    decreasing[0] = 1;
	    
	    for (int i = 1; i < numbers.length; i++) {
	    	if ((numbers[i] - numbers[i-1]) < 0) {
	    		
	    			increasing[i] = decreasing [i-1] + 1;
	    			decreasing[i] = decreasing[i-1];
	    		
	    			
	    	}else if (numbers[i] == numbers[i-1]){
	    		
	    			increasing[i] = increasing[i-1];
	    			decreasing[i] = decreasing[i-1];
	    		} else {
	    			decreasing[i] = increasing[i - 1] + 1;
		        increasing[i] = increasing[i - 1];
	    		}
	    	}
	    
	    
	    if (increasing[numbers.length-1] > decreasing[numbers.length-1]) {
	    	System.out.println("The longest sequence has a length of " + increasing[numbers.length-1]);
	    } else {
	    	System.out.println("The longest sequence has a length of " + decreasing[numbers.length-1]);
	    }
		
	}
}

	
	
		    
	
	




