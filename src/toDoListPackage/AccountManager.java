package toDoListPackage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class AccountManager {

	private static Account openedAccount = null;
	private static File accountsFile = new File(System.getProperty("user.dir") + "//accounts//account.txt");

	private static void createAccountFromFile(String name, String pass) {

		if (accountsFile.exists()) {

			try (Scanner readFromFile = new Scanner(accountsFile)) {

				String userName = new String();
				String email = new String();
				String password = new String();

				while (readFromFile.hasNext()) {

					userName = readFromFile.next();
					email = readFromFile.next();
					password = readFromFile.next();

					if (userName.equals(name) && password.equals(pass)) {

						openedAccount = new Account(userName, email, password);

						return;
					}
				}
			} catch (IOException e) {

				System.out.println(e.getMessage());
			}
		}
	}

	public static void logIn(String userName, String password) {

		createAccountFromFile(userName, password);
	}

	public static Account getAccount() {

		return openedAccount;
	}

	public static void saveAccountToExternalFile(Account createdAccount) {

		try (PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter(accountsFile.getPath(), true)))) {

			if (!doesAccountExist(createdAccount.getUserName())) {

				output.append(createdAccount.getUserName() + " ");
				output.append(createdAccount.getEmail() + " ");
				output.append(createdAccount.getPassword());
				output.println();

				System.out.println("Your account has been created!");
			} else {

				System.out.println("That account already exists!");
			}
		} catch (IOException e) {

			System.out.println(e.getMessage());
		}
	}

	private static boolean doesAccountExist(String name) {

		if (accountsFile.exists()) {

			try (Scanner readFromFile = new Scanner(accountsFile)) {

				String userName = new String();

				while (readFromFile.hasNext()) {

					userName = readFromFile.next();

					if (userName.equals(name)) {

						return true;
					}
				}
			} catch (IOException e) {

				System.out.println(e.getMessage());

			}
		}

		return false;
	}
	
	public static void showToDoListsFromOpenedAccount() {
		
		ArrayList<ToDoList> allLists = ToDoListManager.getToDoLists();
		
		allLists.forEach(list -> {System.out.println(list.getListName());});
		System.out.println();
	}
}
