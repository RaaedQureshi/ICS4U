package com.bayviewglen.multidimensionarrays;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class GPS {

	
		public static void main(String[] args) {
			double[][] coord = null;
			try {
				Scanner input = new Scanner(new FileReader("data/coords.dat"));
				coord = new double[Integer.parseInt(input.nextLine())][2];
				String line;
				for (int i = 0; i < coord.length; i++) {
					line = input.nextLine();
					coord[i][0] = Double.parseDouble(line.split(" ")[0]);
					coord[i][1] = Double.parseDouble(line.split(" ")[1]);
				}

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
}
			
			

