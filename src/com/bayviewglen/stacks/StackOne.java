package com.bayviewglen.stacks;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class StackOne {

	public static void main(String[] args) {
		testInfix("data/stack.dat");
		testPostfix("data/postfix.dat");

	}

	private static void testInfix(String string) {
		File f = new File(string);
		try {
			Scanner in = new Scanner(f);
			while (in.hasNext()) {
				String expression = in.nextLine();
				evaluateInfix(expression.split(" "));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}

	private static void testPostfix(String string) {
		File f = new File(string);
		try {
			Scanner in = new Scanner(f);
			while (in.hasNext()) {
				String expression = in.nextLine();
				evaluatePostfix(expression.split(" "));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	private static void evaluatePostfix(String[] string) {
		Stack<String> operators = new Stack<String>();
		Stack<Double> operands = new Stack <Double>();	


		final String OPERATORS = "()*+-/";
		final String OPERATIONS = "+-*/";

		for (String s : string) {

			if (OPERATORS.indexOf(s) == -1) {
				operands.push(new Double(s));
			}
			else {
				String op = s;
				double operand1 = operands.pop();
				double operand2 = operands.pop();
				if (op.equals("*")) {
					operands.push(operand1 * operand2);	
				}
				else if (op.equals("+")){
					operands.push(operand1 + operand2);
				}
				else if (op.equals("-")) {
					operands.push(operand1 - operand2);
				}
				else if (op.equals("/")) {
					operands.push(operand1 / operand2);
				}
				
				

			}
		}


	}

	private static void evaluateInfix(String[] split) {
		Stack<String> operators = new Stack<String>();
		Stack<Double> operands = new Stack <Double>();	


		final String OPERATORS = "()*+-/";
		final String OPERATIONS = "+-*/";

		for (String s : split) {

			if (OPERATORS.indexOf(s) == -1) {
				if (OPERATIONS.indexOf(operators.peek()) == -1) {
					Double operand2 = operands.pop();
					Double operand1 = new Double(s);
					String op = operators.pop();
					if (op.equals("*")) {
						operands.push(operand1 * operand2);	
					}
					else if (op.equals("+")){
						operands.push(operand1 + operand2);
					}
					else if (op.equals("-")) {
						operands.push(operand1 - operand2);
					}
					else if (op.equals("/")) {
						operands.push(operand1 / operand2);
					}
				}
			}
			
		}
		
		
		System.out.println(operands.peek());


	}

}
