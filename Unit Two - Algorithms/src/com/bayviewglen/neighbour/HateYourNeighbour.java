package com.bayviewglen.neighbour;

public class HateYourNeighbour {

	public static void main(String[] args) {
		int [] donation = {10, 3, 2, 5, 7, 8};
		
		int [] firstSolution = new int [donation.length-1];
		int [] secondSolution = new int [donation.length-1];
		firstSolution[0] = donation[0];
		secondSolution[0] = donation[donation.length-1];
		
		for (int i = 1; i < donation.length-1; i ++) {
			int x = donation.length-1-i;
			if (firstSolution[i-1] > donation[i]) {
				firstSolution[i] = firstSolution[i-1];
			}else {
				firstSolution[i] = donation[i];
			}
			if(secondSolution[i-1] > donation[x]) {
				secondSolution[i] = secondSolution[i-1];
				
			} else {
				secondSolution[i] = donation[x];
			}
			if (i > 1) {
				if (firstSolution[i] > firstSolution[i-2] + donation[i]) {
					firstSolution[i] = firstSolution[i];
				} else {
					firstSolution[i] = firstSolution[i-2] + donation[i];
				}
				if (secondSolution[i] > secondSolution[i-2] + donation[x]) {
					secondSolution[i] = secondSolution[i];
				} else {
					secondSolution[i] = secondSolution[i-2] + donation[x];
				}
				
						
					
			}
			if (i > 2) {
				if (firstSolution[i] > firstSolution[i-3] + donation[i]) {
					firstSolution[i] = firstSolution[i];
				} else {
					firstSolution[i] = firstSolution[i-3] + donation[i];
				}
				if (secondSolution[i] > secondSolution[i-3] + donation[x]) {
					secondSolution[i] = secondSolution[i];
				} else {
					secondSolution[i] = secondSolution[i-3] + donation[x];
				}
				
			}
			
		}
		
		System.out.println(Math.max(firstSolution[firstSolution.length - 1], secondSolution[secondSolution.length - 1]));
		

	}

}
