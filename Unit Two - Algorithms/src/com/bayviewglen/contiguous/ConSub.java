package com.bayviewglen.contiguous;

public class ConSub {

	public static void main(String[] args) {
		int [] num = {5,15,-30,10,-5,40,10};
		findSub(num);
		
		
		

	}

	
	public static void findSub (int [] num) {
		int largestSum = 0;
		int start = 0;
		int end = 0;
		int [] sum = new int [num.length];
	
		for (int i = 0; i < num.length; i++) {
			if (i == 0)
				sum[i] = num[i];
		 else {
			if (num[i] + sum[i-1] > num[i]) {
				sum [i] = sum [i-1] + num[i];
				end = i;
			} else {
				sum[i] = num[i];
			    start = i;
			}
			
		}
			if (largestSum < sum[i])
				largestSum = sum[i];
			
		
		

}
		System.out.print("The longest sequence is: ");

		
		
		
		for(int i = start; i <= end; i++) {
		System.out.print(num[i] + " ");
		}
		
		System.out.println("\nIt has a sum of " + largestSum);
}
}
