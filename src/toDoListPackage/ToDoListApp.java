package toDoListPackage;

import java.util.Scanner;

public class ToDoListApp {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int chooseMenuOption = -1;

		while (chooseMenuOption != 0) {

			Menu.showMainMenu();
			chooseMenuOption = InputValidator.checkInput(input, 0, 6);
			
			useChoice(chooseMenuOption, input);
		}
	}
	
	private static void useChoice(int chooseMenuOption, Scanner input) {
		
		input.nextLine();
		
		switch (chooseMenuOption) {

		case 1:

			Menu.showListCreationMenu(input);
			break;

		case 2:

			Menu.showTaskCreationMenu(input);
			break;

		case 3:

			Menu.showTaskInfoMenu(input);
			break;
			
		case 4:
			
			Menu.showUnfinishedTasksMenu(input);
			break;
			
		case 5:
			
			Menu.showFinishedTasksMenu(input);
			break;
			
		case 6:
			
			Menu.showMarkTaskAsFinishedMenu(input);
			break;
		
		case 7:
			
			Menu.showMarkTaskAsUnfinishedMenu(input);
			break;
		}
	}
}
