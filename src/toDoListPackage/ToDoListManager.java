package toDoListPackage;

import java.util.ArrayList;

public class ToDoListManager {

	private static ArrayList<ToDoList> toDoLists = new ArrayList<ToDoList>();
	
	public void createNewToDoList(String listName) {
		
		ToDoList list = new ToDoList(listName);
		
		addToDoListToArrayList(list);
	} 
	
	private void addToDoListToArrayList(ToDoList list) {
		
		toDoLists.add(list);
	}
	
	public static ToDoList getToDoList(String listName) {
		
		return toDoLists.stream().filter(list -> list.getListName().equals(listName))
					.findFirst().orElse(null);
	}
}
