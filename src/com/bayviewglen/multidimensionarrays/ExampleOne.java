package com.bayviewglen.multidimensionarrays;

public class ExampleOne {

	public static void main(String[] args) {
		char[][] words = new char[3][];
		
		words[0] = "cipher".toCharArray();
		words[1] = "hiccup".toCharArray();
		words[2] = "laughable".toCharArray();
		words [1] = words[2]; // we did not change the size of the array that held hiccup - we pointed to a new array instead
		
		for (int i = 0; i < words.length; i++) {
			for (int j = 0; j < words[i].length; j++) {
				words [i][j] += 2;
			}
			System.out.println();
		}
		for (char[] arr : words) {
			for (char i : arr) {
				System.out.print(i);
			}
			System.out.println();
		}

	}

}
