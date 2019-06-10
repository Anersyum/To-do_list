package toDoListPackage;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class AccountManager {

	private static ArrayList<Account> listOfAccounts = new ArrayList<Account>();
	private static File file = new File(System.getProperty("user.dir") + "//accounts//account.txt");
	
	public static void createAccount(String userName, String email, String password) {
		
		Account newAccout = new Account(userName, email, password);
		
		addAccountToAccountsList(newAccout);
		
		System.out.println("Your account has been created!\n");
	}
	
	private static void addAccountToAccountsList(Account account) {
		
		listOfAccounts.add(account);
	}
	
	public static Account getAccount(String userName, String password) {
		
		for (Account account : listOfAccounts) {
			
			if (account.getPassword().equals(password) && account.getUserName().equals(userName)) {
				
				return account;
			}
		}
		
		return null;
	}
	
	public static ArrayList<Account> getAccountList() {
		
		return listOfAccounts;
	}
	
	public static void saveAccountsToExternalFile() {
		
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
	
	public static void readAccountsFromFile() {
		
		if (file.exists()) {
			
			String userName = new String();
			String email = new String();
			String password = new String();
			
			try (Scanner readFromFile = new Scanner(file)) {
				
				while (readFromFile.hasNext()) {
					
					userName = readFromFile.next();
					email = readFromFile.next();
					password = readFromFile.next();
					createAccount(userName, email, password);
				}
			}
			catch (IOException e) {
				
				System.out.println(e.getMessage());
			}
		}
	}
}
