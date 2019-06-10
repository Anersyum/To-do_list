package toDoListPackage;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
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
	
	public static void saveAccountsToExternalFile() {
		
		File file = new File(System.getProperty("user.dir") + "//accounts//account.txt");
		
		try (PrintWriter output = new PrintWriter(file)) {
			
			for (Account account : listOfAccounts) {
				
				output.print(account.getUserName() + " ");
				output.print(account.getEmail() + " ");
				output.println(account.getPassword());
			}
			
			System.out.println("The changes were saved!");
		}
		catch (IOException e) {
			
			System.out.println(e.getMessage());
		}
	}
}
