package com.bayviewglen.multidimensionarrays;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MultipleChoiceTest {

	public static void main(String[] args) {
		String[] answers = {"D","B","D","C","C","D","A","E","A","D"};
		String[][] students = new String [8][10];
		int [] marks = new int [8];
		getTestAnswers(students);
		check(students, answers, marks);
		

	}
	
	private static void check(String[][] students, String[] answers, int [] marks) {
		for (int i = 0; i < students.length; i++) {
			for (int j = 0; j < students[i].length; j++) {
				if (students[i][j].equals(answers[j])) {
					marks[i] ++;
				}
			}
		}
		
		for (int k = 0; k < marks.length; k++) {
			System.out.println("Student " + (k + 1) + "'s score is " + marks[k]);
		}
	}
	

	private static void getTestAnswers(String[][] students) {
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new FileReader("data/test.dat"));
			
			// One way of reading the file
			for (int j = 0; j < 8; j++) {
				String contentLine = br.readLine();
				for (int i = 0; i < 10; i++) {
					students[j][i] = contentLine.substring(i, i+1);
				}
			}

		} catch (IOException ioe) {
			ioe.printStackTrace();
		} 
				
			} 

		
	}
	
	


