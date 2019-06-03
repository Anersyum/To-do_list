package toDoListPackage;

import java.time.LocalDate;

public class Task {

	private String taskName, taskDescription, tag = "";
	private boolean finished;
	private LocalDate dueDate;
	
	public Task(String taskName, String taskDescription, LocalDate dueDate) {
		
		this.taskName = taskName;
		this.taskDescription = taskDescription;
		this.dueDate = dueDate;
	}
	
	public Task(String taskName, String taskDescription, LocalDate dueDate, String tag) {
		
		this(taskName, taskDescription, dueDate);
		this.tag = tag;
	}

	public String getTaskName() {
		
		return this.taskName;
	}

	public void setTaskName(String taskName) {
		
		this.taskName = taskName;
	}

	public String getTaskDescription() {
		
		return this.taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		
		this.taskDescription = taskDescription;
	}

	public String getTag() {
		
		return this.tag;
	}

	public void setTag(String tag) {
		
		this.tag = tag;
	}

	public boolean isFinished() {
		
		return this.finished;
	}

	public void setFinished(boolean isFinished) {
		
		this.finished = isFinished;
	}

	public LocalDate getDueDate() {
		
		return this.dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		
		this.dueDate = dueDate;
	}
	
	public String getTaskInfo() {
		
		String info = new String();
		
		info = "Task name: " + this.taskName 
				+ "\nTask description: " + this.taskDescription
				+ "\nTag: " + this.tag
				+ "\nIs finished: " + this.finished
				+ "\nDue date: \n	Day: " + this.dueDate.getDayOfMonth()
				+ "\n	Month: " + this.dueDate.getMonthValue()
				+ "\n	Year: " + this.dueDate.getYear();
		
		return info;
	}
}
