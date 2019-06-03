package toDoListPackage;

import java.time.LocalDate;
import java.util.Scanner;

public class ToDoListApp {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int chooseMenuOption = -1;

		while (chooseMenuOption != 0) {

			ConsoleDisplay.showConsole();
			chooseMenuOption = InputValidator.checkInput(input, 0, 6);

			input.nextLine();

			switch (chooseMenuOption) {

			case 1:

				listCreationMenu(input);
				break;

			case 2:

				taskCreationMenu(input);
				break;

			case 3:

				showTaskInfoMenu(input);
				break;
			}
		}
	}

	private static void listCreationMenu(Scanner input) {

		System.out.print("Please enter the name of the list: ");
		String listName = new String(input.nextLine());

		ToDoListManager.createNewToDoList(listName);
	}

	private static void taskCreationMenu(Scanner input) {

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
		day = InputValidator.checkInput(input, 1, 31);

		System.out.print("Month: ");
		month = InputValidator.checkInput(input, 1, 12);

		System.out.print("Year: ");
		year = InputValidator.checkInput(input, 1990, 10000);

		dueDate = LocalDate.of(year, month, day);

		System.out.println("Do you want to add a tag to that task? (enter 0 for no | enter 1 for yes)");
		int appendTag = InputValidator.checkInput(input, 0, 1);

		if (appendTag == 1) {

			input.nextLine();
			System.out.print("Please, enter your tag: ");
			tag = input.nextLine();
		}
		else
			input.nextLine();
		
		System.out.print("Lastly, enter the name of the To Do list you want to add this task to: ");
		listName = input.nextLine();

		ToDoList selectedList = ToDoListManager.getToDoList(listName);

		if (selectedList != null) {
			
			if (appendTag == 1)
				selectedList.createNewTask(taskName, taskDescription, dueDate, tag);
			else
				selectedList.createNewTask(taskName, taskDescription, dueDate);
		} 
		else 
			System.out.println("\nThe list is not valid!");
	}

	private static void showTaskInfoMenu(Scanner input) {

		ToDoList selectedList;
		String listName = new String();

		System.out.print("Enter the name of the list you want to get the task info: ");
		listName = input.nextLine();
		
		System.out.println();
		
		selectedList = ToDoListManager.getToDoList(listName);

		selectedList.getTaskList().forEach(task -> System.out.println(task.getTaskInfo() + "\n"));
	}
}
