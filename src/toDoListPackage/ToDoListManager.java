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
		
		System.out.println("Your list has been created!\n");
	} 
	
	private static void addToDoListToArrayList(ToDoList list) {
		
		toDoLists.add(list);
	}
	
	public static ToDoList getToDoList(String listName) {
		
		return toDoLists.stream().filter(list -> list.getListName().equals(listName))
					.findFirst().orElse(null);
	}
	
	public static ArrayList<ToDoList> getToDoLists() {
		
		return toDoLists;
	}
	
	public static void saveListToAccountExternalFile() {
		
		Account openedAccount = AccountManager.getAccount();
		File fileToSaveListTo = new File(System.getProperty("user.dir") + "//ToDoLists//" + openedAccount.getUserName() + ".txt");
		
		try (PrintWriter output = new PrintWriter(fileToSaveListTo)) {
			
			for (ToDoList list : toDoLists) {
				
				output.println(list.getListName());
				
				for (Task task : list.getTaskList()) {
					
					output.println(task.getTaskName());
					output.println(task.getTaskDescription());
					output.println(task.getTag());
					output.println(task.getDueDate());
				}
			}
			
			System.out.println("Your changes have been saved!");
		}
		catch (IOException e) {
			
			System.out.println(e.getMessage());
		}
	}
	
	//fix loading from file
	public static void loadToDoListsFromFile() {
		
		Account openedAccount = AccountManager.getAccount();
		File loadListFile = new File(System.getProperty("user.dir") + "//ToDoLists//" + openedAccount.getUserName() + ".txt");
		
		if (loadListFile.exists()) {

			try (Scanner readFromFile = new Scanner(loadListFile)) {
				
				String listName = new String();
				String taskName = new String();
				String taskDes = new String();
				String taskTag = new String();
				LocalDate dueDate;
				String[] time;
				int[] timeInt = new int[3];
				
				while (readFromFile.hasNext()) {

					listName = readFromFile.nextLine();
					System.out.println(listName + " ime liste");
					
					createNewToDoList(listName);
					
					ToDoList list = getToDoList(listName);
					
					taskName = readFromFile.nextLine();
					taskDes = readFromFile.nextLine();
					taskTag = readFromFile.nextLine();
					time = readFromFile.nextLine().split("-");
					
					for (int i = 0; i < 3; i++) {
						
						timeInt[i] = Integer.valueOf(time[i]);
					}
					
					dueDate = LocalDate.of(timeInt[0], timeInt[1], timeInt[2]);
					list.createNewTask(taskName, taskDes, dueDate, taskTag);
				}
			} catch (IOException e) {

				System.out.println(e.getMessage());
			}
		}
	}
	
}