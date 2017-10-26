package com.bayviewglen.files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class FileReaderWriterExample {

	public static void main(String[] args) throws IOException {
		FileWriter fw = new FileWriter (new File ("data/sample.dat"));
		fw.write("This is a test...\n");
		fw.write("This is another test...\n");
		fw.close();
		
		FileInputStream fis = new FileInputStream ("data/sample.dat");
		BufferedReader fr = new BufferedReader(new InputStreamReader(fis));
		
		String line = fr.readLine();
		while (line != null) {
			System.out.println(fr.readLine());
		}
		fr.close();
		
		Scanner scanner = new Scanner(new File ("data/sample.dat"));
		
		String line2 = fr.readLine();
		while (line2 != null) {
			System.out.println(fr.readLine());
			line2 = scanner.nextLine();
		}
		
		scanner.close();

	}

}
