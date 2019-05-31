package toDoListPackage;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputValidator {

	public static int checkInput(Scanner input, int minInput, int maxInput) {

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

}

