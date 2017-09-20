package com.bayviewglen.multidimensionarrays;

import java.util.Scanner;

public class GridQuiz {
	public static void main(String[] args) {
		String [][] grid = new String [3][3];
		char x = 'x';
		char o = 'o';
		char dot = '.';
		boolean validGame = true;
		makeGrid(grid, x, o, dot);
		checkGrid(grid, x, o, dot, validGame);
		closingMessage();
		
	}




		private static void closingMessage() {
		System.out.println("Thank you for playing.");
		
	}




		public static void makeGrid(String[][] grid, char x, char o, char dot) {
			System.out.println("Please enter x, o or dot.");
			Scanner keyboard = new Scanner (System.in);

			for (int i = 0; i < grid.length; i++) {
				for (int j = 0; j < grid[0].length; j++) {
					String choice = keyboard.nextLine();
					while (choice.equals(x) || choice.equals(o) || choice.equals(dot)) {
						if (choice.equals(x)) {
							grid[i][j] = choice;
						}
						if (choice.equals(o)) {
							grid[i][j] = choice;
						}
						if (choice.equals(dot)) {
							grid[i][j] = choice;
						}
					}
					System.out.println(grid);
				}
			}
		}

		
		public static void checkGrid (String[][] grid, char x, char o, char dot, boolean validGame) {
			int numX = 0;
			int numO = 0;
		
			for (int i = 0; i < grid.length; i++) {
				for (int j = 0; j < grid[0].length; j++) {
					
				if (grid[i][j].equals(x)) {
					numX ++;
				}
				if (grid[i][j].equals(o)) {
					numO ++;
				}
				if (numX - numO > 1 || numO - numX > 1) {
					validGame = false;
					System.out.println("Not a valid game.");
				}
                    while (validGame) {
					if (grid[i][j].equals(x) && grid[i][j+1].equals(x) && grid[i][j+2].equals(x)) {
						System.out.println("X wins.");
					}
					if (grid[i][j].equals(o) && grid[i][j+1].equals(o) && grid[i][j+2].equals(o)) {
						System.out.println("O wins.");
						
					}
					if (grid[i][j].equals(x) && grid[i+1][j].equals(x) && grid[i+2][j].equals(x)) {
						System.out.println("X wins.");
				}
					if (grid[i][j].equals(o) && grid[i+1][j].equals(o) && grid[i+2][j].equals(o)) {
						System.out.println("O wins.");
			}
					if (grid[i][j].equals(x) && grid[i+1][j+1].equals(x) && grid[i+2][j+2].equals(x)) {
						System.out.println("O wins.");
		} if (grid[i][j].equals(o) && grid[i+1][j+1].equals(o) && grid[i+2][j+2].equals(o)) {
			System.out.println("O wins.");
}
		if (grid[i][j].equals(o) && grid[i+1][j+1].equals(o) && grid[i+2][j+2].equals(o)) {
			System.out.println("O wins.");
		}
		if (grid[i][j].equals(dot) && grid[i+1][j+1].equals(dot) && grid[i+2][j+2].equals(dot)) {
			System.out.println("It is a tie.");
		}
		if (grid[i][j].equals(dot) && grid[i][j+1].equals(dot) && grid[i][j+2].equals(dot)) {
			System.out.println("It is a tie.");
                    }
		if (grid[i][j].equals(dot) && grid[i+1][j].equals(dot) && grid[i+2][j].equals(dot)) {
			System.out.println("It is a tie.");

				}
			}
		}
}
		}
}

	

