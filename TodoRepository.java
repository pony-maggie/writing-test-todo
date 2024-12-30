import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TodoRepository extends JpaRepository<TodoItem, Integer> {
    List<TodoItem> findByUserIdOrderByScoreDesc(int userId);
}