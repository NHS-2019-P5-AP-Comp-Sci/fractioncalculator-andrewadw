package fracCalc;

import java.util.*;

public class FracCalc {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		String fractions = userInput.nextLine();
		while (!(fractions.toUpperCase()).equals("QUIT")) {
			System.out.println(produceAnswer(fractions));
			fractions = userInput.nextLine();
		}
// TODO: Read the input from the user and call produceAnswer with an equation

	}

// ** IMPORTANT ** DO NOT DELETE THIS FUNCTION. This function will be used to
// test your code
// This function takes a String 'input' and produces the result
//
// input is a fraction string that needs to be evaluated. For your program, this
// will be the user input.
// e.g. input ==> "1/2 + 3/4"
//
// The function should return the result of the fraction after it has been
// calculated
// e.g. return ==> "1_1/4"
	public static String produceAnswer(String input) {
		String operator;
		int nums1;
		int topa = input.indexOf(" + ");
		int topb = input.indexOf(" - ");
		int topc = input.indexOf(" * ");
		int topd = input.indexOf(" / ");
		if (topa != -1) {
			nums1 = topa;
			operator = "+";
		} else if (topb != -1) {
			nums1 = topb;
			operator = "-";
		} else if (topc != -1) {
			nums1 = topc;
			operator = "*";
		} else {
			nums1 = topd;
			operator = "/";
		}
		String firstFraction = "";
		String secondFraction = "";
		for (int i = 0; i < nums1; i++) {
			firstFraction = firstFraction + input.charAt(i);
		}
		for (int i = 0; i < input.length() - 3 - nums1; i++) {
			secondFraction = secondFraction + input.charAt(3 + nums1 + i);
		}
		return secondFraction;
	}

// TODO: Fill in the space below with any helper methods that you think you will
// need

}
