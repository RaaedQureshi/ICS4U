package com.bayviewglen.queens;

import java.util.Scanner;
import java.util.Stack;

public class nQueens {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Please enter a number: ");
		int n = keyboard.nextInt();
		boolean conflict = false;;
		Stack queens = new Stack<Queen>();
		int filled = 1;
		boolean placed = false;
		
		while (n < filled) { 
			while (!placed) {
				Queen a = new Queen (filled, 0);
				Stack<Queen> newQueens = new Stack<Queen>();
				newQueens.addAll(queens);
				while (!newQueens.isEmpty()) {
					if (a.conflict(newQueens.pop()))
						conflict = true;
				}
				
				if (!conflict) {
					queens.push(a);
					placed = true;
					
				} else if(conflict && a.getCol() + 1 <= n){
					a.setCol(a.getCol()+1);
					
				} else if(conflict && (a.getCol()+1 > n)) {
					
				}
			
			
				
			}
			
			}
		
		
	}
	
	
	

}
