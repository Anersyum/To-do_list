package toDoListPackage;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

public class ToDoListTest {

	static ToDoList listToTest;
	static Task task1;
	static Task task2;
	
	@BeforeClass
	public static void createParams() {
		
		String taskDescription = new String("A simple description for the task");
		String taskName = new String("Test task1");
		Date dueDate = new Date();
		Date dueDate2 = new Date(System.currentTimeMillis() - 100000);
		
		listToTest = new ToDoList("List to test");
		task1 = new Task(taskName, taskDescription, dueDate);
		
		taskDescription = "A simple description for the second task";
		taskName = "Test task2";
		
		task2 = new Task(taskName, taskDescription, dueDate2);
		
		listToTest.addNewTask(task1);
		listToTest.addNewTask(task2);
	}
	
	@Test
	public void shouldThrowErrorIfThereAreNoTasksInToDoList() {
		
		assertEquals(2, listToTest.getNumberOfTasks());
	}
	
	@Test
	public void shouldThrowErrorIfTheMethodReturnsWrongTask() {
		
		Task task = listToTest.getTaskByTaskName("Test task2");
		
		assertEquals("Test task2", task.getTaskName());
	}
	
	@Test
	public void shouldThrowErrorIfTaskIsNotSetToFinished() {
		
		Task task = listToTest.getTaskByTaskName("Test task2");
		
		listToTest.markTaskAsFinished(task);
		
		assertEquals(true, task.isFinished());
	}
	
	@Test
	public void shouldThrowErrorIfTaskIsNotSetToUnfinished() {
		
		Task task = listToTest.getTaskByTaskName("Test task2");
		
		listToTest.markTaskAsUnfinished(task);
		
		assertEquals(false, task.isFinished());
	}
	
	@Test
	public void shouldThrowErrorIfDatesNotSorted() {
		
		listToTest.showUnfinishedTasksByDueDate();
		
		Task taskUno = listToTest.getTaskList().get(0);
		Task taskDuo = listToTest.getTaskList().get(1);
		int condition = taskUno.getDueDate().compareTo(taskDuo.getDueDate());
		
		assertEquals(true, condition < 0);
	}
}
