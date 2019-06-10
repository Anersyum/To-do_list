package toDoListPackage;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

public class AccountTest {

	@BeforeClass
	public static void createTestingEnviroment() {
		
		String userName, password, email;
		
		userName = new String("Anersyum");
		password = new String("password");
		email = new String("amorosmic@gmx.com");
		
		AccountManager.createAccount(userName, email, password);
		
		userName = "DjChupolini";
		password = "Pas_word";
		email = "alexilaiho467@gmail.com";
		
		AccountManager.createAccount(userName, email, password);
	}
	
	@Test
	public void shouldThrowErrorIfThereAreNoAccountsPresent() {
		
		assertEquals(2, AccountManager.getAccountList().size());
	}
	
	@Test
	public void shouldThrowErrorIfAccountIsNull() {
		
		Account account = AccountManager.getAccount("amorosmic@gmx.com", "password");
		
		assertEquals("Anersyum", account.getUserName());
	}
	
	@Test
	public void shouldThrowErrorIfLoginIsInvalid() {
		
		Account account = AccountManager.getAccount("anersyum", "Pas_word");
		
		assertEquals("DjChupolini", account.getUserName());
	}
}
