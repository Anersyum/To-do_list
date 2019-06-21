package toDoListPackage;

import java.util.Scanner;

public class ToDoListApp {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int chooseMenuOption = -1;
		
		Menus.showAccountLogInMenu(input);
		ToDoListManager.loadToDoListsFromFile();
		
		while (chooseMenuOption != 0) {

			Menus.showMainMenu();
			chooseMenuOption = InputValidator.getInputIfInputIsInRangeAndIsTypeOfInt(input, 0, 9);
			
			useChoice(chooseMenuOption, input);
		}
		
		ToDoListManager.saveListToAccountExternalFile();
	}
	
	private static void useChoice(int chooseMenuOption, Scanner input) {
		
		input.nextLine();
		
		switch (chooseMenuOption) {

		case 1:

			Menus.showListCreationMenu(input);
			break;

		case 2:

			Menus.showTaskCreationMenu(input);
			break;

		case 3:

			Menus.showTaskInfoMenu(input);
			break;
			
		case 4:
			
			Menus.showUnfinishedTasksMenu(input);
			break;
			
		case 5:
			
			Menus.showFinishedTasksMenu(input);
			break;
			
		case 6:
			
			Menus.showMarkTaskAsFinishedMenu(input);
			break;
		
		case 7:
			
			Menus.showMarkTaskAsUnfinishedMenu(input);
			break;
			
		case 8:
			
			Menus.showEditTaskMenu(input);
			break;
		
		case 9:
			
			Menus.showToDoListsFromAccount();
			break;
		}
	}
}
