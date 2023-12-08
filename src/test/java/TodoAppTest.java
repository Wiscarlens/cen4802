import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;


public class TodoAppTest extends TestCase {


    @Test
    public void testAddTodo() {
        TodoApp todoApp = new TodoApp();
        todoApp.addTodo("Buy groceries");
        todoApp.addTodo("Finish homework");

        List<String> todoList = todoApp.getTodoList();

        assertEquals(2, todoList.size());
        assertTrue(todoList.contains("Buy groceries"));
        assertTrue(todoList.contains("Finish homework"));
    }

    @Test
    public void testRemoveTodo() {
        TodoApp todoApp = new TodoApp();
        todoApp.addTodo("Buy groceries");
        todoApp.addTodo("Finish homework");
        todoApp.removeTodo("Buy groceries");

        List<String> todoList = todoApp.getTodoList();

        assertEquals(1, todoList.size());
        assertFalse(todoList.contains("Buy groceries"));
        assertTrue(todoList.contains("Finish homework"));
    }

}