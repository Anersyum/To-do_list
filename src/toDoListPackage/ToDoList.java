package toDoListPackage;

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

	public void addNewTask(Task task) {

		this.tasks.add(task);
	}

	public void showAllTasks() {

		for (Task task : this.tasks) {

			System.out.println(task.getTaskName());
		}
	}

	public void showUnfinishedTasks() {

		for (Task task : this.tasks) {

			if (!task.isFinished())
				System.out.println(task.getTaskName());
		}
	}

	public void showFinishedTasks() {

		for (Task task : this.tasks) {

			if (task.isFinished())
				System.out.println(task.getTaskName());
		}
	}

	// the next two methods should be rewritten with lambda expressions or maybe not we'll see
	public void markTaskAsFinished(Task task) {

		task.setFinished(true);
	}

	public void markTaskAsUnfinished(Task task) {

		task.setFinished(false);
	}

	public void showUnfinishedTasksByDueDate() {

		this.tasks.sort((task1, task2) -> task1.getDueDate().compareTo(task2.getDueDate()));
		this.tasks.forEach(task -> System.out.println(task.getTaskName()));
	}

	public Task getTaskByTaskName(String taskName) {

		return this.tasks.stream().filter(task -> task.getTaskName().equals(taskName))
					.findFirst().orElse(null);
	}


	public void showTasksWithTheTag(String tag) {

		this.tasks.forEach(task -> System.out.println(task.getTag().equals(tag) ? task.getTaskName() : ""));
	}
	
	public void sortAndShowUnfinishedTasksByDueDate() {
		
		this.tasks.sort((task1, task2) -> task1.getDueDate().compareTo(task2.getDueDate()));
		
		for (Task task : this.tasks) {
			
			if (!task.isFinished())
				System.out.println(task.getTaskName());
		}
	}
	
	public int getNumberOfTasks() {
		
		return this.tasks.size();
	}
	
	//just for testing purposes
	public ArrayList<Task> getTaskList() {
		
		return this.tasks;
	}
}
