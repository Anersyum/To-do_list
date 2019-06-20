package toDoListPackage;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class ToDoListManager {

	private static ArrayList<ToDoList> toDoLists = new ArrayList<ToDoList>();

	public static void createNewToDoList(String listName) {

		ToDoList list = new ToDoList(listName);

		addToDoListToArrayList(list);
	}

	private static void addToDoListToArrayList(ToDoList list) {

		toDoLists.add(list);
	}

	public static ToDoList getToDoList(String listName) {

		return toDoLists.stream().filter(list -> list.getListName().equals(listName)).findFirst().orElse(null);
	}

	public static ArrayList<ToDoList> getToDoLists() {

		return toDoLists;
	}

	public static void saveListToAccountExternalFile() {

		Account openedAccount = AccountManager.getAccount();
		File fileToSaveListTo = new File(
				System.getProperty("user.dir") + "//ToDoLists//" + openedAccount.getUserName() + "//toDoList.txt");

		fileToSaveListTo.getParentFile().mkdirs();
		try (PrintWriter output = new PrintWriter(fileToSaveListTo)) {

			for (ToDoList list : toDoLists) {

				output.println(list.getListName());

				File taskFile = new File(System.getProperty("user.dir") + "//ToDoLists//" + openedAccount.getUserName()
						+ "//" + list.getListName() + ".txt");

				try (PrintWriter taskOutPut = new PrintWriter(taskFile)) {

					for (Task task : list.getTaskList()) {

						taskOutPut.println(task.getTaskName());
						taskOutPut.println(task.getTaskDescription());
						taskOutPut.println(task.getTag());
						taskOutPut.println(task.isFinished());
						taskOutPut.println(task.getDueDate());
					}
				}
			}

			System.out.println("Your changes have been saved!");
		} catch (IOException e) {

			System.out.println(e.getMessage());
		}
	}

	// fix loading from file
	public static void loadToDoListsFromFile() {

		Account openedAccount = AccountManager.getAccount();
		File loadListFile = new File(
				System.getProperty("user.dir") + "//ToDoLists//" + openedAccount.getUserName() + "//toDoList.txt");

		if (loadListFile.exists()) {

			try (Scanner readFromFile = new Scanner(loadListFile)) {

				String listName = new String();
				String taskName = new String();
				String taskDescription = new String();
				String taskTag = new String();
				String isFinished = new String();
				LocalDate dueDate;
				String[] time;
				int[] timeInt = new int[3];

				while (readFromFile.hasNext()) {

					listName = readFromFile.nextLine();

					createNewToDoList(listName);

					ToDoList list = getToDoList(listName);
					File taskFile = new File(System.getProperty("user.dir") + "//ToDoLists//"
							+ openedAccount.getUserName() + "//" + list.getListName() + ".txt");

					try (Scanner readTaskFile = new Scanner(taskFile)) {
						
						while (readTaskFile.hasNext()) {
							
							taskName = readTaskFile.nextLine();
							taskDescription = readTaskFile.nextLine();
							taskTag = readTaskFile.nextLine();
							isFinished = readTaskFile.nextLine();
							time = readTaskFile.nextLine().split("-");
							
							for (int i = 0; i < 3; i++) {

								timeInt[i] = Integer.valueOf(time[i]);
							}

							dueDate = LocalDate.of(timeInt[0], timeInt[1], timeInt[2]);
							list.createNewTask(taskName, taskDescription, dueDate, taskTag);
							
							if (isFinished.equals("true")) {
								list.getTaskByTaskName(taskName).setFinished(true);
							}
						}
					}
				}
			} catch (IOException e) {

				System.out.println(e.getMessage());
			}
		}
	}

}