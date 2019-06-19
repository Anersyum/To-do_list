package toDoListPackage;

import java.util.ArrayList;

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
		
		//File fileToSaveListTo = new File(System.getProperty("user.dir"))
	}
}
