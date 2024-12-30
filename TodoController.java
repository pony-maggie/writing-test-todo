import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;

    @GetMapping("/top-todos")
    public List<TodoDTO> getTopTodos(@RequestParam int userId) {
        return todoRepository.findByUserIdOrderByScoreDesc(userId)
                .stream()
                .limit(10)
                .map(todo -> new TodoDTO(todo.getId(), todo.getName(), todo.getDescription(), todo.getScore()))
                .collect(Collectors.toList());
    }
}
