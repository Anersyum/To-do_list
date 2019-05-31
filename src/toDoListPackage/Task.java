package toDoListPackage;

import java.util.Date;

public class Task {

	private String taskName, taskDescription, tag;
	private boolean isFinished;
	private Date dueDate;
	
	public Task(String taskName, String taskDescription, Date dueDate) {
		
		this.taskName = taskName;
		this.taskDescription = taskDescription;
		this.dueDate = dueDate;
	}
	
	public Task(String taskName, String taskDescription, Date dueDate, String tag) {
		
		this(taskName, taskDescription, dueDate);
		this.tag = tag;
	}

	public String getTaskName() {
		
		return taskName;
	}

	public void setTaskName(String taskName) {
		
		this.taskName = taskName;
	}

	public String getTaskDescription() {
		
		return taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		
		this.taskDescription = taskDescription;
	}

	public String getTag() {
		
		return tag;
	}

	public void setTag(String tag) {
		
		this.tag = tag;
	}

	public boolean isFinished() {
		
		return isFinished;
	}

	public void setFinished(boolean isFinished) {
		
		this.isFinished = isFinished;
	}

	public Date getDueDate() {
		
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		
		this.dueDate = dueDate;
	}
}
