import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class TodoControllerTest {

    @Test
    void testGetTopTodos() {
        TodoController controller = new TodoController();
        List<TodoDTO> result = controller.getTopTodos(1);

        assertNotNull(result);
        assertEquals(10, result.size());
        assertEquals("Task 5", result.get(0).getName()); // Assuming "Task 5" has the highest score for userId 1
        assertTrue(result.get(0).getScore() >= result.get(1).getScore());
    }
}
