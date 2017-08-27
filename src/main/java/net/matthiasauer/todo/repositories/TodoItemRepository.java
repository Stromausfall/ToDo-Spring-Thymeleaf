package net.matthiasauer.todo.repositories;

import net.matthiasauer.todo.model.TodoItem;
import org.springframework.data.repository.CrudRepository;

public interface TodoItemRepository extends CrudRepository<TodoItem, Long> {
}
