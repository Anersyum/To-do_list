package toDoListPackage;

import java.time.LocalDate;
import java.util.Scanner;

public class Menus {

	public static void showAccountLogInMenu(Scanner input) {

		int option;
		String userName = new String();
		String password = new String();
		Account account = null;

		while (account == null) {
			
			System.out.print("Welcome to the To Do list app." + "\nIf you have an account, please input 1."
					+ "\nIf you don't have an account and wish to create one, please input 0:" + "\nInput: ");

			option = input.nextInt();

			if (option == 0) {

				showAccountCreationMenu(input);
				
			} else if (option == 1) {
				
				System.out.print("Please, enter your user name: ");
				userName = input.next();

				System.out.print("Please, enter your password: ");
				password = InputValidator.getPasswordIfPasswordIsValid(input);
				
				account = AccountManager.getAccount(userName, password);

				if (account == null) {

					System.out.println("This account doesn't exist!");
				} 
				else {
					
					System.out.println("You've successfuly logged in!\n");
				}
				
			}
		}

	}

	private static void showAccountCreationMenu(Scanner input) {

		String userName = new String();
		String email = new String();
		String password = new String();
		String passwordCheck = new String();

		System.out.print("Please, enter your user name: ");
		userName = input.next();

		System.out.print("Please, enter your email: ");
		email = InputValidator.getEmailIfEmailIsValid(input);

		input.nextLine();

		System.out.print("Please, enter your password: ");
		password = InputValidator.getPasswordIfPasswordIsValid(input);

		input.nextLine();

		System.out.print("Please, enter your password again: ");
		passwordCheck = InputValidator.getPasswordIfPasswordIsValid(input);

		if (password.equals(passwordCheck))
			AccountManager.createAccount(userName, email, password);
		else
			System.out.println("Invalid password!");
	}

	public static void showMainMenu() {

		System.out.print("\nTo Do list:" + "\n1. Create new to do list" + "\n2. Create new task" + "\n3. Show all tasks"
				+ "\n4. Show unfinshed tasks" + "\n5. Show finished tasks" + "\n6. Finish task" + "\n7. Unfinish task"
				+ "\n0. Exit" + "\nInput: ");
	}

	public static void showListCreationMenu(Scanner input) {

		System.out.print("Please enter the name of the list: ");
		String listName = new String(input.nextLine());

		ToDoListManager.createNewToDoList(listName);
	}

	public static void showTaskCreationMenu(Scanner input) {

		String taskName = new String();
		String taskDescription = new String();
		String tag = new String();
		String listName = new String();
		LocalDate dueDate;
		int day, month, year;

		System.out.print("Please enter the name of the task: ");
		taskName = input.nextLine();

		System.out.print("Please enter the description of the task: ");
		taskDescription = input.nextLine();

		System.out.print("Please enter the date that the task is due: \n");

		System.out.print("Day: ");
		day = InputValidator.getInputIfInputIsInRangeAndIsTypeOfInt(input, 1, 31);

		System.out.print("Month: ");
		month = InputValidator.getInputIfInputIsInRangeAndIsTypeOfInt(input, 1, 12);

		System.out.print("Year: ");
		year = InputValidator.getInputIfInputIsInRangeAndIsTypeOfInt(input, 1990, 10000);

		dueDate = LocalDate.of(year, month, day);

		System.out.println("Do you want to add a tag to that task? (enter 0 for no | enter 1 for yes)");
		int appendTag = InputValidator.getInputIfInputIsInRangeAndIsTypeOfInt(input, 0, 1);

		if (appendTag == 1) {

			input.nextLine();

			System.out.print("Please, enter your tag: ");
			tag = input.nextLine();
		} else
			input.nextLine();

		System.out.print("Lastly, enter the name of the To Do list you want to add this task to: ");
		listName = input.nextLine();

		ToDoList selectedList = ToDoListManager.getToDoList(listName);

		if (selectedList != null) {

			if (appendTag == 1)
				selectedList.createNewTask(taskName, taskDescription, dueDate, tag);
			else
				selectedList.createNewTask(taskName, taskDescription, dueDate);
		} else
			System.out.println("\nThe list is not valid!");
	}

	public static void showTaskInfoMenu(Scanner input) {

		ToDoList selectedList;
		String listName = new String();

		System.out.print("Enter the name of the list you want to get the task info: ");
		listName = input.nextLine();

		System.out.println();

		selectedList = ToDoListManager.getToDoList(listName);

		selectedList.getTaskList().forEach(task -> System.out.println(task.getTaskInfo() + "\n"));
	}

	public static void showUnfinishedTasksMenu(Scanner input) {

		ToDoList selectedList;
		String listName = new String();

		System.out.print("Enter the name of the list you want to get the task info: ");
		listName = input.nextLine();

		selectedList = ToDoListManager.getToDoList(listName);

		selectedList.getTaskList().forEach(task -> {
			if (!task.isFinished())
				System.out.println(task.getTaskInfo() + "\n");
		});
	}

	public static void showFinishedTasksMenu(Scanner input) {

		ToDoList selectedList;
		String listName = new String();

		System.out.print("Enter the name of the list you want to get the task info: ");
		listName = input.nextLine();

		selectedList = ToDoListManager.getToDoList(listName);

		selectedList.getTaskList().forEach(task -> {
			if (task.isFinished())
				System.out.println(task.getTaskInfo() + "\n");
		});
	}

	public static void showMarkTaskAsFinishedMenu(Scanner input) {

		ToDoList selectedList;
		String listName = new String();
		Task selectedTask;
		String taskName = new String();

		System.out.print("Enter the name of the list: ");
		listName = input.nextLine();

		System.out.print("Enter the name of the task: ");
		taskName = input.nextLine();

		selectedList = ToDoListManager.getToDoList(listName);
		selectedTask = selectedList.getTaskByTaskName(taskName);

		if (selectedTask.isFinished())
			System.out.println("You have already marked this task as finished!");
		else
			selectedList.markTaskAsFinished(selectedTask);
	}

	public static void showMarkTaskAsUnfinishedMenu(Scanner input) {

		ToDoList selectedList;
		String listName = new String();
		Task selectedTask;
		String taskName = new String();

		System.out.print("Enter the name of the list: ");
		listName = input.nextLine();

		System.out.print("Enter the name of the task: ");
		taskName = input.nextLine();

		selectedList = ToDoListManager.getToDoList(listName);
		selectedTask = selectedList.getTaskByTaskName(taskName);

		if (!selectedTask.isFinished())
			System.out.println("This task is already marked as unfinished!");
		else
			selectedList.markTaskAsUnfinished(selectedTask);
	}
}
