package com.bayviewglen.arrays;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class WordSorter {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		String[] allWords = new String[1000];
		int wordCount = 0;

		Scanner input = new Scanner(new File("data/words.dat"));
		while (input.hasNext()) {
		    String word = input.next();
		    allWords[wordCount] = word;
		    wordCount++;
		}
		
		allWords = truncateArray(allWords, wordCount);
		Arrays.sort(allWords);
		
		allWords = removeMiddleWord(allWords);
		
		for (int i = 0; i < allWords.length; i++) {
			System.out.println(allWords[i]);
		}
		input.close();
		
		
		


	}

	private static String[] removeMiddleWord(String[] allWords) {
		String[] temp = new String [allWords.length-1];
		
		for (int i = 0; i<allWords.length; i++) {
			if (i < allWords.length/2)
				temp[i] = allWords [i];
			else if (i>allWords.length/2)
				temp[i-1] = allWords[i];
		}
		return temp;
	}

	private static String[] truncateArray(String[] allWords, int wordCount) {
		String [] arr = new String[wordCount];
		for (int i = 0; i < wordCount; i++) {
			arr[i] = allWords[i];
		}
		return arr;
	}

}
