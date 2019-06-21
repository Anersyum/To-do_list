package toDoListPackage;

import java.time.LocalDate;
import java.util.Scanner;

public class Menus {

	public static void showAccountLogInMenu(Scanner input) {

		int option;
		Account account = null;

		while (account == null) {
			
			System.out.print("Welcome to the To Do list app. To exit the log in menu, please input 2." 
					+ "\nIf you have an account, please input 1."
					+ "\nIf you don't have an account and wish to create one, please input 0:" 
					+ "\nInput: ");

			option = InputValidator.getInputIfInputIsInRangeAndIsTypeOfInt(input, 0, 2);

			if (option == 0) {

				showAccountCreationMenu(input);
				
			}
			else if (option == 1) {
				
				String userName = new String();
				String password = new String();
				
				System.out.print("Please, enter your user name: ");
				userName = input.next();

				System.out.print("Please, enter your password: ");
				password = InputValidator.getPasswordIfPasswordIsValid(input);
				
				AccountManager.logIn(userName, password);
				account = AccountManager.getAccount();
				
				if (account == null) {

					System.out.println("This account doesn't exist!");
				} 
				else {
					
					System.out.println("You've successfully logged in!\n");
				}
				
			}
			else {
				
				System.out.println("You closed the app.");
				System.exit(1);
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

		if (password.equals(passwordCheck)) {
			
			AccountManager.saveAccountToExternalFile(new Account(userName, email, password));
		}
		else
			System.out.println("Invalid password!");
	}

	public static void showMainMenu() {

		System.out.print("\nTo Do list:" 
				+ "\n1. Create new to do list" 
				+ "\n2. Create new task" 
				+ "\n3. Show all tasks"
				+ "\n4. Show unfinshed tasks" 
				+ "\n5. Show finished tasks" 
				+ "\n6. Finish task" 
				+ "\n7. Unfinish task"
				+ "\n8. Edit a task"
				+ "\n9. Show all to do lists"
				+ "\n0. Exit" 
				+ "\nInput: ");
	}
	
	public static void showEditTaskMenu(Scanner input) {
		
		String taskName = new String();
		String taskDescription = new String();
		String tag = new String();
		String listName = new String();
		ToDoList selectedList;
		LocalDate dueDate;
		int day, month, year;
		
		
		System.out.print("Enter the name of the list you want to edit: ");
		listName = input.next();
		
		selectedList = ToDoListManager.getToDoList(listName);
		
		if (selectedList != null) {
			
			System.out.println("Here are the tasks of the " + selectedList.getListName() + " ToDo list:");
			
			for (Task task : selectedList.getTaskList()) {
				
				System.out.println(task.getTaskInfo() + "\n");
			}
			
			input.nextLine();
			
			System.out.print("Please, enter the name of the task you want to edit: ");
			taskName = input.nextLine();
			
			Task task = selectedList.getTaskByTaskName(taskName);
			
			if (task != null) {
			
				System.out.print("If you don't want to edit a field, leave it empty."
						+ "\nEdit task name: ");
				taskName = input.nextLine();
				taskName = (taskName.isEmpty()) ? task.getTaskName() : taskName;
				
				System.out.print("Edit the description of the task: ");
				taskDescription = input.nextLine();
				taskDescription = (taskDescription.isEmpty()) ? task.getTaskDescription() : taskDescription;
				
				System.out.print("Edit the tag of the task: ");
				tag = input.nextLine();
				tag = (tag.isEmpty()) ? task.getTag() : tag;
				
				System.out.print("Do you want to edit the due date of the task? (yes = 1, no = 0)");
				int editDueDate = InputValidator.getInputIfInputIsInRangeAndIsTypeOfInt(input, 0, 1);
				
				dueDate = task.getDueDate();
				
				if (editDueDate == 1) {
					
					System.out.print("Edit the date that the task is due: \n");
					
					System.out.print("Day: ");
					day = InputValidator.getInputIfInputIsInRangeAndIsTypeOfInt(input, 1, 31);
					
					System.out.print("Month: ");
					month = InputValidator.getInputIfInputIsInRangeAndIsTypeOfInt(input, 1, 12);
			
					System.out.print("Year: ");
					year = InputValidator.getInputIfInputIsInRangeAndIsTypeOfInt(input, 1990, 10000);
			
					dueDate = LocalDate.of(year, month, day);
				}
				
				selectedList.editTask(taskName, taskDescription, dueDate, tag);
				
				System.out.println("Task successfully edited!");
			}
		} 
		else 
			System.out.println("The list doesn't exist!");
	}

	public static void showListCreationMenu(Scanner input) {

		System.out.print("Please enter the name of the list: ");
		String listName = new String(input.nextLine());

		ToDoListManager.createNewToDoList(listName);
		
		System.out.println("Your list has been created!\n");
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
		
		taskCreation(listName, taskName, taskDescription, dueDate, tag, appendTag);
	}
	
	private static void taskCreation(String listName, String taskName, String taskDescription, LocalDate dueDate, String tag,
				int appendTag) {
		
		ToDoList selectedList = ToDoListManager.getToDoList(listName);

		if (selectedList != null) {

			if (appendTag == 1)
				selectedList.createNewTask(taskName, taskDescription, dueDate, tag);
			else
				selectedList.createNewTask(taskName, taskDescription, dueDate);
			
			System.out.println("\nThe task has been created!");
		} else
			System.out.println("\nThe list is not valid!");
	}

	public static void showTasksInfoMenu(Scanner input) {

		ToDoList selectedList;
		String listName = new String();

		System.out.print("Enter the name of the list you want to get the task info: ");
		listName = input.nextLine();

		System.out.println();

		selectedList = ToDoListManager.getToDoList(listName);
		
		if (selectedList != null)
			selectedList.showTasksInfo();
		else
			System.out.println("That list doesn't exist!");
	}

	public static void showUnfinishedTasksMenu(Scanner input) {

		ToDoList selectedList;
		String listName = new String();

		System.out.print("Enter the name of the list you want to get the task info: ");
		listName = input.nextLine();

		selectedList = ToDoListManager.getToDoList(listName);

		if (selectedList != null)
			selectedList.showUnfinishedTasksInfo();
		else
			System.out.println("That list doesn't exist!");
	}

	public static void showFinishedTasksMenu(Scanner input) {

		ToDoList selectedList;
		String listName = new String();

		System.out.print("Enter the name of the list you want to get the task info: ");
		listName = input.nextLine();

		selectedList = ToDoListManager.getToDoList(listName);

		if (selectedList != null)
			selectedList.showFinishedTasksInfo();
		else
			System.out.println("That list doesn't exist!");
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
	
	public static void showAccountToDoListsMenu() {
		
		System.out.println("Your lists are:\n");
		AccountManager.showToDoListsFromOpenedAccount();
	}
}
