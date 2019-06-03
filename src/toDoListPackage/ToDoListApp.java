package toDoListPackage;

import java.util.Scanner;

public class ToDoListApp {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int chooseMenuOption = -1;

		while (chooseMenuOption != 0) {

			Menu.showOptionsMenu();
			chooseMenuOption = InputValidator.checkInput(input, 0, 6);

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
			}
		}
	}

	

	

	
}
