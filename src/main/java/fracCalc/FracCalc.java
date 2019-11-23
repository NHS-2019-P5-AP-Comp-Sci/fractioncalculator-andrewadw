package fracCalc;

import java.util.*;

public class FracCalc {

	public static void main(String[] args) {

		Scanner userInput = new Scanner(System.in);

		String userFractions = userInput.nextLine();

		while (!(userFractions.toUpperCase()).equals("QUIT")) {

			System.out.println(produceAnswer(userFractions));

			userFractions = userInput.nextLine();

		}

		userInput.close();

	}

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

		} else if (b != -1) {

			numsBefore = b;

			operator = "-";

		} else if (c != -1) {

			numsBefore = c;

			operator = "*";

		} else {

			numsBefore = d;

			operator = "/";

		}

		String Fraction1 = "";

		String Fraction2 = "";

		for (int i = 0; i < numsBefore; i++) {

			Fraction1 += input.charAt(i);

		}

		for (int i = 0; i < input.length() - 3 - numsBefore; i++) {

			Fraction2 += input.charAt(3 + numsBefore + i);

		}

		int Top1 = Integer.parseInt(whole(Fraction1));

		int Top2 = Integer.parseInt(whole(Fraction2));

		int Numerator1 = Integer.parseInt(numerator(Fraction1));

		int Numerator2 = Integer.parseInt(numerator(Fraction2));

		int Denominator1 = Integer.parseInt(denominator(Fraction1));

		int Denominator2 = Integer.parseInt(denominator(Fraction2));

// sets up fractions for the calculation
// sets up fractions for the calculation

		return ("whole:" + Top2 + " " + "numerator:" + Numerator2 + " " + "denominator:"
				+ Denominator2);

	}

//finds the whole number in a mixed or whole number

	public static String whole(String fraction) {

		String whole = "";

		if (fraction.indexOf("/") == -1) {

			whole = fraction;

		} else if (fraction.indexOf("_") != -1) {

			int beforeUnderscore = fraction.indexOf("_");

			for (int i = 0; i < beforeUnderscore; i++) {

				whole = whole + fraction.charAt(i);

			}

		} else if (fraction.indexOf("_") == -1) {

			whole = "0";

		}

		return whole;

	}

//finds the numerator of a fraction

	public static String numerator(String fraction) {

		String numerator = "";

		if (fraction.indexOf("/") == -1) {

			numerator = "0";

		} else if (fraction.indexOf("_") != -1) {

			int beforeSlash = fraction.indexOf("/");

			int beforeUnderscore = fraction.indexOf("_");

			for (int i = 0; i < beforeSlash - beforeUnderscore - 1; i++) {

				numerator = numerator + fraction.charAt(beforeUnderscore + 1 + i);

			}

		} else if (fraction.indexOf("_") == -1) {

			int beforeSlash = fraction.indexOf("/");

			for (int i = 0; i < beforeSlash; i++) {

				numerator = numerator + fraction.charAt(i);

			}

		}

		return numerator;

	}

//finds the denominator of a fraction

	public static String denominator(String fraction) {

		String denominator = "";

		if (fraction.indexOf("/") == -1) {

			denominator = "1";

		} else if (fraction.indexOf("_") != -1) {

			int beforeSlash = fraction.indexOf("/");

			for (int i = 0; i < fraction.length() - beforeSlash - 1; i++) {

				denominator = denominator + fraction.charAt(beforeSlash + 1 + i);

			}

		} else if (fraction.indexOf("_") == -1) {

			int beforeSlash = fraction.indexOf("/");

			for (int i = 0; i < fraction.length() - beforeSlash - 1; i++) {

				denominator = denominator + fraction.charAt(beforeSlash + 1 + i);

			}

		}

		return denominator;

	}

}