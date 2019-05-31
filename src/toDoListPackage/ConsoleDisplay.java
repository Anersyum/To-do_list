package toDoListPackage;

public class ConsoleDisplay {

	public static void showConsole() {
		
		System.out.println("To Do list:"
				+ "\n1. Create new to do list"
				+ "\n2. Create new task"
				+ "\n3. Show all tasks"
				+ "\n4. Show unfinshed tasks"
				+ "\n5. Show finished tasks"
				+ "\n6. Finish task"
				+ "\n7. Unfinish task"
				+ "\n0. Exit");
	}
	
	public static void showLogInText() {
		
		System.out.println("Welcome to the To Do list app.\nIf you have an account, please input 1."
				+ "\nIf you don't have an account and wish to create one, please input 0");
	}
	
	public static void showAccountCreationText() {
		
		System.out.println("Here are the details we need to create you an account:");
	}
}
