package toDoListPackage;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Scanner;

import org.junit.BeforeClass;
import org.junit.Test;

public class InputValidatorTest {

	static Scanner input;
	
	@BeforeClass
	public static void createScanner() {
		
		input = new Scanner(System.in);
	}
	
	@Test
	public void shouldThrowErrorIfPasswordNotValid() {
		
		String password = new String();
		
		System.out.println("Enter password: (at least 8 characters long and contains one uppercase letter and one number)");
		password = input.nextLine();
		
		assertEquals(true, InputValidator.isPasswordValid(password));
	}
	
	@Test
	public void shouldThrowErrorIfEmailNotValid() {
		
		String email = new String("amor@mail.com");
		
		assertEquals(true, InputValidator.isEmailValid(email));
	}
	
	@Test
	public void shouldThrowErrorIfInputNotInRangeAndNotOfTypeInt() {
		
		System.out.print("Enter number between 0 and 10: ");
		int number = InputValidator.returnInputIfInputIsInRangeAndIsTypeOfInt(input, 0, 10);
		
		assertEquals(number, number);
		
		input.nextLine();
	}
}
