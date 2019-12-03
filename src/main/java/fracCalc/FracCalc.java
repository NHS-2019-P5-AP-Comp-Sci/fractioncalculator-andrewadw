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
		String firstFraction = "";
		String secondFraction = "";
		for (int i = 0; i < numsBefore; i++) {
			firstFraction = firstFraction + input.charAt(i);
		}
		for (int i = 0; i < input.length() - 3 - numsBefore; i++) {
			secondFraction = secondFraction + input.charAt(3 + numsBefore + i);
		}

		int Hole1 = Integer.parseInt(whole(firstFraction));
		int Hole2 = Integer.parseInt(whole(secondFraction));
		int Numerator1 = Integer.parseInt(numerator(firstFraction));
		int Numerator2 = Integer.parseInt(numerator(secondFraction));
		int Denominator1 = Integer.parseInt(denominator(firstFraction));
		int Denominator2 = Integer.parseInt(denominator(secondFraction));

		if (firstFraction.indexOf("-") != -1 && firstFraction.indexOf("_") != -1) {
			Numerator1 = (Hole1 * Denominator1 - Numerator1);
			if (operator.equals("+") || operator.equals("-")) {
				Numerator1 *= Denominator2;
			}
		} else if (operator.equals("+") || operator.equals("-")) {
			Numerator1 = (Numerator1 + Hole1 * Denominator1) * Denominator2;
		} else {
			Numerator1 = (Numerator1 + Hole1 * Denominator1);
		}

		if (secondFraction.indexOf("-") != -1 && secondFraction.indexOf("_") != -1) {
			Numerator2 = (Hole2 * Denominator2 - Numerator2);
			if (operator.equals("+") || operator.equals("-")) {
				Numerator2 *= Denominator1;
			}
		} else if (operator.equals("+") || operator.equals("-")) {
			Numerator2 = (Numerator2 + Hole2 * Denominator2) * Denominator1;
		} else {
			Numerator2 = (Numerator2 + Hole2 * Denominator2);
		}
		if (operator.equals("+") || operator.equals("-")) {
			Denominator1 *= Denominator2;
			Denominator2 = Denominator1;
		}

		int FinalNumerator = 0;
		int FinalDenominator = 0;
		if (operator.equals("+")) {
			FinalNumerator = Numerator1 + Numerator2;
			FinalDenominator = Denominator1;
		} 
		
		else if (operator.equals("-")) {
			FinalNumerator = Numerator1 - Numerator2;
			FinalDenominator = Denominator1;
		}
			
		
		else if (operator.equals("/")) {
				FinalNumerator = Numerator1 * Denominator2;
				FinalDenominator = Denominator1 * Numerator2;
		} 
		
		else {
			FinalNumerator = Numerator1 * Numerator2;
			FinalDenominator = Denominator1 * Denominator2;
		}

		return FinalNumerator + "/" + FinalDenominator;
	}

	public static String whole(String fraction) {
		String whole = "";
		if (fraction.indexOf("/") == -1) {
			whole = fraction;
		} else if (fraction.indexOf("_") != -1) {
			int numsBeforeUnderscore = fraction.indexOf("_");
			for (int i = 0; i < numsBeforeUnderscore; i++) {
				whole = whole + fraction.charAt(i);
			}
		} else if (fraction.indexOf("_") == -1) {
			whole = "0";
		}
		return whole;
	}

	public static String numerator(String fraction) {
		String numerator = "";
		if (fraction.indexOf("/") == -1) {
			numerator = "0";
		} else if (fraction.indexOf("_") != -1) {
			int numsBeforeSlash = fraction.indexOf("/");
			int numsBeforeUnderscore = fraction.indexOf("_");
			for (int i = 0; i < numsBeforeSlash - numsBeforeUnderscore - 1; i++) {
				numerator = numerator + fraction.charAt(numsBeforeUnderscore + 1 + i);
			}
		} else if (fraction.indexOf("_") == -1) {
			int numsBeforeSlash = fraction.indexOf("/");
			for (int i = 0; i < numsBeforeSlash; i++) {
				numerator = numerator + fraction.charAt(i);
			}
		}
		return numerator;
	}

	public static String denominator(String fraction) {
		String denominator = "";
		if (fraction.indexOf("/") == -1) {
			denominator = "1";
		} else if (fraction.indexOf("_") != -1) {
			int numsBeforeSlash = fraction.indexOf("/");
			for (int i = 0; i < fraction.length() - numsBeforeSlash - 1; i++) {
				denominator = denominator + fraction.charAt(numsBeforeSlash + 1 + i);
			}
		} else if (fraction.indexOf("_") == -1) {
			int numsBeforeSlash = fraction.indexOf("/");
			for (int i = 0; i < fraction.length() - numsBeforeSlash - 1; i++) {
				denominator = denominator + fraction.charAt(numsBeforeSlash + 1 + i);
			}
		}
		return denominator;
	}
	

}
