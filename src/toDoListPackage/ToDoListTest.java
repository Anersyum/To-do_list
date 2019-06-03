package toDoListPackage;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import org.junit.BeforeClass;
import org.junit.Test;

public class ToDoListTest {

	static String list1Name = new String("It's me, list!");
	static String list2Name = new String("It's me, second list!");
	
	@BeforeClass
	public static void createListAndAddTasks() {

		ToDoListManager.createNewToDoList(list1Name);
		ToDoListManager.createNewToDoList(list2Name);
		
		ToDoListManager.getToDoList(list1Name).createNewTask("Task1", "Some desc", LocalDate.now());
		ToDoListManager.getToDoList(list1Name).createNewTask("Task2", "Some desc", LocalDate.of(2018, 12, 18), "tag");

		ToDoListManager.getToDoList(list2Name).createNewTask("Task3", "Some desc", LocalDate.now());
		ToDoListManager.getToDoList(list2Name).createNewTask("Task4", "Some desc", LocalDate.now(), "tag");

	}

	

	@Test
	public void shouldThrowErrorIfThereAreNoTasksInToDoList() {

		ToDoList listToTest = ToDoListManager.getToDoList(list1Name);
		
		assertEquals(2, listToTest.getNumberOfTasks());
	}

	@Test
	public void shouldThrowErrorIfTheMethodReturnsWrongTask() {

		Task task = ToDoListManager.getToDoList(list1Name).getTaskByTaskName("Task1");

		assertEquals("Task1", task.getTaskName());
	}

	@Test
	public void shouldThrowErrorIfTaskIsNotSetToFinished() {

		Task task = ToDoListManager.getToDoList(list1Name).getTaskByTaskName("Task1");

		ToDoListManager.getToDoList(list1Name).markTaskAsFinished(task);

		assertEquals(true, task.isFinished());
	}

	@Test
	public void shouldThrowErrorIfTaskIsNotSetToUnfinished() {

		Task task = ToDoListManager.getToDoList(list1Name).getTaskByTaskName("Task1");

		ToDoListManager.getToDoList(list1Name).markTaskAsUnfinished(task);

		assertEquals(false, task.isFinished());
	}

	@Test
	public void shouldThrowErrorIfDatesNotSorted() {

		ToDoList listToTest = ToDoListManager.getToDoList(list1Name);
		
		listToTest.sortTasksByDueDate();

		Task taskUno = listToTest.getTaskList().get(0);
		Task taskDuo = listToTest.getTaskList().get(1);
		
		int condition = taskUno.getDueDate().compareTo(taskDuo.getDueDate());

		assertEquals(true, (condition < 0));
	}
	
	@Test
	public void shouldThrowErrorIfListDoesntExist() {
		
		assertEquals("It's me, list!", ToDoListManager.getToDoList("It's me, list!").getListName());
	}
	
	@Test
	public void shouldThrowErrorIfThereAreLessThanTwoLists() {
		
		assertEquals(2, ToDoListManager.getToDoLists().size());
	}
	
	@Test
	public void shouldThrowErrorIfThereIsNoTaskWithATag() {
		
		ArrayList<Task> tasksWithTag = ToDoListManager.getToDoList(list1Name).getTasksWithTheTag("tag");
		
		assertEquals(1, tasksWithTag.size());
	}
	
	@Test
	public void shouldThrowErrorIfThereAreNoFinishedTasks() {
		
		ToDoListManager.getToDoList(list2Name).getTaskByTaskName("Task3").setFinished(true);
		
		ArrayList<Task> finishedTasks = ToDoListManager.getToDoList(list2Name).getFinishedTasks();
		
		assertEquals(1, finishedTasks.size());
	}
	
	@Test
	public void shouldThrowErrorIfThereAreNoUnfinishedTasks() {
		
		ArrayList<Task> unfinishedTasks = ToDoListManager.getToDoList(list2Name).getUnfinishedTasks();
		
		assertEquals(1, unfinishedTasks.size());
	}

}
