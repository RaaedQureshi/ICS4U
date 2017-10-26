package com.bayviewglen.multidimensionarrays;

import java.util.Scanner;

public class Soduku {

	public static void main(String[] args) {
		int [][] grid = new int [9][9];
		boolean valid = true;
		Scanner scanner = new Scanner (System.in);
		System.out.println("Please enter a solution.");
		for (int i = 0; i < grid.length; i++) {
			String [] choice = scanner.nextLine().split("");
			for (int j = 0; j < grid[0].length; j++) {
				
				grid[i][j] = Integer.parseInt(choice[j]);
				
			}
		}
	}
}
		

	


