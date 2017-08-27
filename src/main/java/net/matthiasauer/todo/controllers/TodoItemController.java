package net.matthiasauer.todo.controllers;

import net.matthiasauer.todo.model.TodoItem;
import net.matthiasauer.todo.repositories.TodoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TodoItemController {

    private TodoItemRepository repository;

    @Autowired
    public TodoItemController(TodoItemRepository repository) {
        this.repository = repository;
    }

    @RequestMapping({"/", "", "/index", "index", "/overview", "overview"})
    public String getTodoItemOverview(Model model) {
        // add all items
        model.addAttribute("items", this.repository.findAll());

        // return the name of the view to display
        return "overview";
    }

    @RequestMapping({"/create", "create"})
    public String createToDoItem(@RequestParam("description") String description, @RequestParam("title") String title) {
        TodoItem item = new TodoItem(title, description);

        this.repository.save(item);

        return "create";
    }

    @RequestMapping({"/done", "done"})
    public String removeToDoItem(@RequestParam("id") String item) {
        this.repository.deleteById(Long.parseLong(item));

        return "done";
    }
}
