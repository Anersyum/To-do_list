package toDoListPackage;

import java.time.LocalDate;
import java.util.ArrayList;

public class ToDoList {

	private String listName;
	private ArrayList<Task> tasks = new ArrayList<Task>();

	public ToDoList(String listName) {

		this.listName = listName;
	}

	public String getListName() {

		return listName;
	}

	public void setListName(String listName) {

		this.listName = listName;
	}

	public ArrayList<Task> getTaskList() {
		
		return this.tasks;
	}

	public ArrayList<Task> getUnfinishedTasks() {

		ArrayList<Task> listOfUnfinishedTasks = new ArrayList<Task>();
		
		tasks.forEach(task ->
				{if (!task.isFinished()) listOfUnfinishedTasks.add(task);});
		
		return listOfUnfinishedTasks;
	}

	public ArrayList<Task> getFinishedTasks() {

		ArrayList<Task> listOfFinishedTasks = new ArrayList<Task>();
		
		tasks.forEach(task ->
				{if (task.isFinished()) listOfFinishedTasks.add(task);});
		
		return listOfFinishedTasks;
	}

	public void markTaskAsFinished(Task task) {

		task.setFinished(true);
		
		System.out.println("The task " + task.getTaskName() + " is marked as finished!");
	}

	public void markTaskAsUnfinished(Task task) {

		task.setFinished(false);
		
		System.out.println("The task " + task.getTaskName() + " is marked as unfinished!");
	}

	public void sortTasksByDueDate() {

		this.tasks.sort((task1, task2) -> task1.getDueDate().compareTo(task2.getDueDate()));
	}

	public Task getTaskByTaskName(String taskName) {

		return this.tasks.stream().filter(task -> task.getTaskName().equals(taskName))
					.findFirst().orElse(null);
	}


	public ArrayList<Task> getTasksWithTheTag(String tag) {

		ArrayList<Task> tasksWithTheDesiredTag = new ArrayList<Task>();
		
		this.tasks.forEach(task -> 
			{if (task.getTag().equals(tag)) tasksWithTheDesiredTag.add(task);});
		
		return tasksWithTheDesiredTag;
	}
	
	public int getNumberOfTasks() {
		
		return this.tasks.size();
	}
	
	public void createNewTask(String taskName, String taskDescription, LocalDate dueDate) {
		
		Task task = new Task(taskName, taskDescription, dueDate);
		
		this.tasks.add(task);
	}
	
	public void createNewTask(String taskName, String taskDescription, LocalDate dueDate, String tag) {
		
		Task task = new Task(taskName, taskDescription, dueDate, tag);
		
		this.tasks.add(task);
	}
}
