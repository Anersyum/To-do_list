package toDoListPackage;

import java.util.Date;

public class Task {

	private String taskName, taskDescription, tag = "";
	private boolean finished;
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

	public Date getDueDate() {
		
		return this.dueDate;
	}

	public void setDueDate(Date dueDate) {
		
		this.dueDate = dueDate;
	}
}
