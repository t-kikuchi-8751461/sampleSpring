package com.example.demo.web.todo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import com.example.demo.domain.model.Todo;
import com.example.demo.domain.service.todo.TodoService;

@RequestMapping("/todo")
@Controller
public class TodoController {

    @Autowired
    private TodoService todoService;

    @RequestMapping("/")
    public String top(Model model) {
        return UrlBasedViewResolver.REDIRECT_URL_PREFIX + "list";
    }

    @RequestMapping("/list")
    public String list(Model model) {
        List<Todo> todoList = todoService.todoList();
        model.addAttribute(todoList);
        return "todo";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(Model model, TodoForm form, RedirectAttributes redirectAttributes) {
        todoService.newTodo(form.getTitle(), form.getDetails());
        redirectAttributes.addFlashAttribute("message", "登録しました");
        return UrlBasedViewResolver.REDIRECT_URL_PREFIX + "list";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(Model model, TodoUpdateForm form, RedirectAttributes redirectAttributes) {
        todoService.updateTodo(toModel(form.getFormList()));
        redirectAttributes.addFlashAttribute("message", "更新しました");
        return UrlBasedViewResolver.REDIRECT_URL_PREFIX + "list";
    }

    private List<Todo> toModel(List<TodoForm> formList) {
        List<Todo> list = new ArrayList<>();
        for (TodoForm form : formList) {
            Todo todo = new Todo();
            todo.setId(form.getId());
            todo.setTitle(form.getTitle());
            todo.setDetails(form.getDetails());
            todo.setFinished(form.isFinished());
            list.add(todo);
        }
        return list;
    }

}
