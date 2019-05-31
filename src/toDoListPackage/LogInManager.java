package toDoListPackage;

public class LogInManager {

	public static Account logIn(String email, String password) {
		
		if (isValidLogin(email, password)) {
			
			System.out.println("You have been successfully logged in!");
			
			return AccountManager.getAccount(email, password);
		}
		
		return null;
	}
	
	public static void logOut() {
		
		//code to save all changes made to the account
	}
	
	private static boolean isValidLogin(String email, String password) {
		
		if (AccountManager.getAccount(email, password) == null)
			return false;
		
		return true;
	}
}
