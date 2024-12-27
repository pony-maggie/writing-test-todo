import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TodoItem {
    private int id;
    private String name;
    private String description;
    private int score;
    private String status;
    private int userId;
}

@Data
@AllArgsConstructor
public class TodoDTO {
    private int id;
    private String name;
    private String description;
    private int score;
}
