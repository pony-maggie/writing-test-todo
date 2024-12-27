import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;

@RestController
public class TodoController {

    private static final List<TodoItem> MOCK_DATABASE = Arrays.asList(
            new TodoItem(1, "Task 1", "Description 1", 50, "Pending", 1),
            new TodoItem(2, "Task 2", "Description 2", 80, "Completed", 1),
            new TodoItem(3, "Task 3", "Description 3", 30, "Pending", 2),
            new TodoItem(4, "Task 4", "Description 4", 70, "Pending", 1),
            new TodoItem(5, "Task 5", "Description 5", 90, "Completed", 3),
            new TodoItem(6, "Task 6", "Description 6", 40, "Pending", 1),
            new TodoItem(7, "Task 7", "Description 7", 60, "Pending", 2),
            new TodoItem(8, "Task 8", "Description 8", 20, "Completed", 3),
            new TodoItem(9, "Task 9", "Description 9", 85, "Pending", 1),
            new TodoItem(10, "Task 10", "Description 10", 10, "Completed", 1)
    );

    @GetMapping("/top-todos")
    public List<TodoDTO> getTopTodos(@RequestParam int userId) {
        return MOCK_DATABASE.stream()
                .filter(todo -> todo.getUserId() == userId)
                .sorted(Comparator.comparingInt(TodoItem::getScore).reversed())
                .limit(10)
                .map(todo -> new TodoDTO(todo.getId(), todo.getName(), todo.getDescription(), todo.getScore()))
                .collect(Collectors.toList());
    }
}
