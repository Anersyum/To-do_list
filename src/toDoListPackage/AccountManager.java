package toDoListPackage;

import java.util.ArrayList;

public class AccountManager {

	private static ArrayList<Account> listOfAccounts = new ArrayList<Account>();
	
	public static void createAccount(String userName, String email, String password) {
		
		Account newAccout = new Account(userName, email, password);
		
		addAccountToAccountsList(newAccout);
		
		System.out.println("Your account has been created!\n");
	}
	
	private static void addAccountToAccountsList(Account account) {
		
		listOfAccounts.add(account);
	}
	
	public static Account getAccount(String email, String password) {
		
		for (Account account : listOfAccounts) {
			
			if (account.getPassword().equals(password) && account.getEmail().equals(email)) {
				
				return account;
			}
		}
		
		return null;
	}
	
	public static ArrayList<Account> getAccountList() {
		
		return listOfAccounts;
	}
	
}
