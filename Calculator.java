package ics211;

import java.util.Scanner;
import java.util.Stack;

public class Calculator<E> extends ArrayStack<E> {
	
	Stack<String> operands = new Stack<String>();
	Stack<String> operands2 = new Stack<String>();
	
	Number calculate(String s) {
		String x = "";
		String y = "";
		Number z = 0;
		String x2 = "";
		String y2 = "";
		Number z2 = 0;
		String[] token = s.split(" ");
		if (token[0].matches("[0-9]*.[0-9]*")) {
			for(int i = 0; i < token.length; i++) {
				if (token[i].equals("+")) {
					x2 = operands2.pop();
					y2 = operands2.pop();
					z2 = Float.parseFloat(y2) + Float.parseFloat(x2);
					operands2.push(""+z2);
				} else if (token[i].equals("-")) {
					x2 = operands2.pop();
					y2 = operands2.pop();
					z2 = Float.parseFloat(y2) - Float.parseFloat(x2);
					operands2.push(""+z2);
				} else if (token[i].equals("*")) {
					x2 = operands2.pop();
					y2 = operands2.pop();
					z2 = Float.parseFloat(y2) * Float.parseFloat(x2);
					operands2.push(""+z2);
				} else if (token[i].equals("/")) {
					x2 = operands2.pop();
					y2 = operands2.pop();
					z2 = Float.parseFloat(y2) / Float.parseFloat(x2);
					operands2.push(""+z2);
				} else operands2.push(token[i]);
			}
		return z2;
		} else {
			for(int i = 0; i < token.length; i++) {
				if (token[i].equals("+")) {
					x = operands.pop();
					y = operands.pop();
					z = Integer.parseInt(y) + Integer.parseInt(x);
					operands.push(""+z);
				} else if (token[i].equals("-")) {
					x = operands.pop();
					y = operands.pop();
					z = Integer.parseInt(y) - Integer.parseInt(x);
					operands.push(""+z);
				} else if (token[i].equals("*")) {
					x = operands.pop();
					y = operands.pop();
					z = Integer.parseInt(y) * Integer.parseInt(x);
					operands.push(""+z);
				} else if (token[i].equals("/")) {
					x = operands.pop();
					y = operands.pop();
					z = Integer.parseInt(y) / Integer.parseInt(x);
					operands.push(""+z);
				} else operands.push(token[i]);
			}
		return z;
		}
	}

	public Calculator() {
		
	}

	public static void main(String[] args) {
		Calculator calc = new Calculator();
		System.out.println("Calculator Test: ");
		System.out.println("1 2 + 3 * 6 + 2 3 + / " + "\nanswer: " + calc.calculate("1 2 + 3 * 6 + 2 3 + /"));
		System.out.println("2.2 7.0 + 3.0 * " + "\nanswer: " + calc.calculate("2.2 7.0 + 3.0 *"));
		System.out.println("1 3 5 + -  " + "\nanswer: " + calc.calculate("1 3 5 + - "));
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter expression ");
		String input = sc.nextLine();
		System.out.print(calc.calculate(input));
	}
}
