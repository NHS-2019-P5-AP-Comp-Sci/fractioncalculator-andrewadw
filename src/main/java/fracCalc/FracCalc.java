package fracCalc;

//importing java util package in order to get user inputs and other functions that are given by java utiul 
import java.util.*;

public class FracCalc {
//asks user for fractions by using scanners (
//i choose not to use print ln statements to actually ask the user for fear it would break the checks
	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		String fractions = userInput.nextLine();
		while (!(fractions.toUpperCase()).equals("QUIT")) {

			System.out.println(produceAnswer(fractions));
			fractions = userInput.nextLine();
		}
		userInput.close();

	}

//by using index of finds the fraction around what operation the user wants, determining what operation the user wants. 
	public static String produceAnswer(String input) {
		String operator;
		int numsBefore;
		int a = input.indexOf(" + ");
		int b = input.indexOf(" - ");
		int c = input.indexOf(" * ");
		int d = input.indexOf(" / ");
		if (a != -1) {
			numsBefore = a;
			operator = "+";
		}

		else if (b != -1) {
			numsBefore = b;
			operator = "-";
		}

		else if (c != -1) {
			numsBefore = c;
			operator = "*";
		}

		else {
			numsBefore = d;
			operator = "/";
		}
		// creates a first and second fraction
		String firstFraction = "";
		String secondFraction = "";
		for (int i = 0; i < numsBefore; i++) {
			firstFraction = firstFraction + input.charAt(i);
		}

		for (int i = 0; i < input.length() - 3 - numsBefore; i++) {
			secondFraction = secondFraction + input.charAt(3 + numsBefore + i);
		}
		//// technically not a new method but it makes the assigns each part of a
		//// fraction an int
		// hole (whole number) numerator and denominator
		int hole1 = Integer.parseInt(whole(firstFraction));
		int hole2 = Integer.parseInt(whole(secondFraction));
		int denominator1 = Integer.parseInt(denominator(firstFraction));
		int denominator2 = Integer.parseInt(denominator(secondFraction));
		int numerator1 = Integer.parseInt(numerator(firstFraction));
		int numerator2 = Integer.parseInt(numerator(secondFraction));

		// a set up mostly to allow addition and subtraction for the following chunk
		// below to execute
		// since subtraction and addition require the same numerator and denominator
		// basically could be thought of a step similar to making the dnominators equal
		// for addition and subtraction
		if (firstFraction.indexOf("-") != -1 && firstFraction.indexOf("_") != -1) {
			numerator1 = (hole1 * denominator1 - numerator1);
			if (operator.equals("+") || operator.equals("-")) {
				numerator1 *= denominator2;
			}
		}

		else if (operator.equals("+") || operator.equals("-")) {
			numerator1 = (numerator1 + hole1 * denominator1) * denominator2;
		}

		else {
			numerator1 = (numerator1 + hole1 * denominator1);
		}

		if (secondFraction.indexOf("-") != -1 && secondFraction.indexOf("_") != -1) {
			numerator2 = (hole2 * denominator2 - numerator2);
			if (operator.equals("+") || operator.equals("-")) {
				numerator2 *= denominator1;
			}
		} else if (operator.equals("+") || operator.equals("-")) {
			numerator2 = (numerator2 + hole2 * denominator2) * denominator1;
		}

		else {
			numerator2 = (numerator2 + hole2 * denominator2);
		}
		if (operator.equals("+") || operator.equals("-")) {
			denominator1 *= denominator2;
			denominator2 = denominator1;
		}
//simple math, doing the operation as if in real life (depending on the operation) returns as improper fraction (unsimplified) 
//just like how you would do math in real life (example addition is just numerators added and denominator stay the same ect) 
		int finalNumerator = 0;
		int finaldenominator = 0;
		if (operator.equals("+")) {
			finalNumerator = numerator1 + numerator2;
			finaldenominator = denominator1;
		}

		else if (operator.equals("-")) {
			finalNumerator = numerator1 - numerator2;
			finaldenominator = denominator1;
		}

		else if (operator.equals("/")) {
			finalNumerator = numerator1 * denominator2;
			finaldenominator = denominator1 * numerator2;
		}

		else {
			finalNumerator = numerator1 * numerator2;
			finaldenominator = denominator1 * denominator2;
		}
		// gives simplified answer using the simplify method from below
		return simplify(finalNumerator, finaldenominator);
	}

	public static String whole(String fraction) {
		String whole = "";
		if (fraction.indexOf("/") == -1) {
			whole = fraction;
		}

		else if (fraction.indexOf("_") != -1) {
			int beforeUnderscore = fraction.indexOf("_");
			for (int i = 0; i < beforeUnderscore; i++) {
				whole = whole + fraction.charAt(i);
			}
		}

		else if (fraction.indexOf("_") == -1) {
			whole = "0";
		}
		return whole;
	}

// for finding numerator of fraction
	public static String numerator(String fraction) {
		String numerator = "";
		if (fraction.indexOf("/") == -1) {
			numerator = "0";
		}

		else if (fraction.indexOf("_") != -1) {
			int beforeSlash = fraction.indexOf("/");
			int beforeUnderscore = fraction.indexOf("_");
			for (int i = 0; i < beforeSlash - beforeUnderscore - 1; i++) {
				numerator = numerator + fraction.charAt(beforeUnderscore + 1 + i);
			}
		}

		else if (fraction.indexOf("_") == -1) {
			int beforeSlash = fraction.indexOf("/");
			for (int i = 0; i < beforeSlash; i++) {
				numerator = numerator + fraction.charAt(i);
			}
		}
		return numerator;
	}

//for finding the denominator of the fraction
	public static String denominator(String fraction) {
		String denominator = "";
		if (fraction.indexOf("/") == -1) {
			denominator = "1";
		}

		else if (fraction.indexOf("_") != -1) {
			int beforeSlash = fraction.indexOf("/");
			for (int i = 0; i < fraction.length() - beforeSlash - 1; i++) {
				denominator = denominator + fraction.charAt(beforeSlash + 1 + i);
			}
		}

		else if (fraction.indexOf("_") == -1) {
			int beforeSlash = fraction.indexOf("/");
			for (int i = 0; i < fraction.length() - beforeSlash - 1; i++) {
				denominator = denominator + fraction.charAt(beforeSlash + 1 + i);
			}
		}
		return denominator;
	}

	// simplifies fraction and returns to produceAnswer
	public static String simplify(int numerator, int denominator) {
		if (denominator < 0 && numerator > 0) {
			numerator = 0 - numerator;
			denominator = 0 - denominator;
		}
		if (numerator < 0 && denominator < 0) {
			numerator = 0 - numerator;
			denominator = 0 - denominator;
		}
		if (numerator == 0) {
			return "0";

		}

		else if (denominator == 1) {
			return "" + numerator;

		}

		else if (numerator % denominator == 0) {
			return "" + numerator / denominator;

		}
		int greatestCommonFactor = Math.abs(numerator + denominator);
		while (numerator % greatestCommonFactor != 0 || denominator % greatestCommonFactor != 0) {
			greatestCommonFactor--;

		}
//additional simplifing part of the method above, just wanted to make that clear
		numerator /= greatestCommonFactor;
		denominator /= greatestCommonFactor;
		if (Math.abs(numerator) > denominator) {
			int whole = numerator / denominator;
			numerator = numerator % denominator;
			if (numerator < 0) {
				numerator = Math.abs(numerator);
				return whole + "_" + numerator + "/" + denominator;
			}

			else {
				return whole + "_" + numerator + "/" + denominator;
			}
		}

		else {
			return numerator + "/" + denominator;
		}

	}
}
