package toDoListPackage;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputValidator {

	public static int returnInputIfInputIsInRangeAndIsTypeOfInt(Scanner input, int minInput, int maxInput) {

		int consoleChoice = 0;

		while (true) {

			try {
				consoleChoice = input.nextInt();

				if (consoleChoice < minInput || consoleChoice > maxInput) {

					System.out.println("That's not a valid input! Try again:");
					continue;
				}
				else 
					break;

			} catch (InputMismatchException e) {

				System.out.println("You didn't enter a number! Try again:");
				input.nextLine();
				continue;
			}
		}

		return consoleChoice;

	}
	
	public static String returnEmailIfEmailIsValid(Scanner input) {
		
		String email = new String();
		email = input.next();
		
		while (!isEmailValid(email)) {
			
			System.out.print("That is an invalid email. Try again (the format is text@mail.domain, for example user@gmail.com)."
					+ "\nInput: ");
			email = input.next();
		}
		
		return email;
	}
	
	public static boolean isEmailValid(String email) {
		
		String pattern = "(\\S*)@(\\S*)(\\.)(\\S*)";
		
		if (email.matches(pattern))
			return true;
		
		return false;
	}
	
	public static String returnPasswordIfPasswordIsValid(Scanner input) {
		
		String password = new String();
		password = input.next();
		
		while (!isPasswordValid(password)) {
			
			System.out.print("That is an invalid password. Try again (the password has to have at least one uppercase character and one number. Also it needs to be longer than 8 characters.)."
					+ "\nInput: ");
			password = input.next();
		}
		
		return password;
	}
	
	public static boolean isPasswordValid(String password) {
		
		String pattern = "^(?=.*\\d)(?=.*[A-Z]).{8,}$";
		
		if (password.matches(pattern) && password.length() > 8)
			return true;
		
		return false;
	}

}

