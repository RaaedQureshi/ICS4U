package com.bayviewglen.quiz;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class DPQuiz {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner (new File ("data/numbers.dat"));
		
		int [] numbers = new int [3];
		int n = 0;
		String line;
		int answer = 0;
		
		int sol = 0;
		
		
		while(in.hasNextLine()) {
			line = in.nextLine();
			n = Integer.parseInt(line);
			String options = in.nextLine();
			numbers[0] = Integer.parseInt(options.split(" ")[0]);
		    numbers[1] = Integer.parseInt(options.split(" ")[1]);
		    numbers[2] = Integer.parseInt(options.split(" ")[2]);
		}
		
		
		while (answer != 1) {
			answer = n;
			if (answer%isDivisible(answer, numbers) == 0) {
				answer = answer/isDivisible(answer,numbers);
				System.out.println("Divided by " + isDivisible(answer, numbers));
				sol ++;
			} else if (answer/isDivisible(answer,numbers) % 2 != 0) {
				answer = answer - 1;
				System.out.println("Subtracted 1");
				sol ++;
			}
		}
		
		System.out.println("It took " + (sol) + " steps");
		
		
		
			
		

	}
	
	public static int isDivisible(int n, int [] numbers) {
		int max = numbers[0];
	    for (int i = 0; i < numbers.length; i++) {
	    	if (max < numbers[i] && n/numbers[i] % 2 == 0 ) {
	    		max = numbers[i];
	    	}
	    }
	    return max;

	}

}
