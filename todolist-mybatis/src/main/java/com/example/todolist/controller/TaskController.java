package com.example.todolist.controller;

import com.example.todolist.dto.Task;
import com.example.todolist.exception.TaskNotFoundException;
import com.example.todolist.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class TaskController {

    private final TaskRepository taskRepository;

    @GetMapping("/")
    public String displayTasks(Model model) {
        List<Task> tasks = taskRepository.findAll();
        model.addAttribute("tasks", tasks);

        return "index";
    }

    @PostMapping("/tasks")
    public String addTask(Task task) {
        taskRepository.save(task);

        return "redirect:/";
    }

    @PutMapping("/tasks/{id}")
    @ResponseBody
    public Map<String, Task> updateTask(@PathVariable Long id, @RequestBody Task form) {
        taskRepository.findById(id)
                .ifPresentOrElse(
                        t -> {
                            t.setTitle(form.getTitle());
                            taskRepository.update(t);
                        },
                        () -> {
                            throw new TaskNotFoundException("Task not found");
                        }
                );
        return Collections.singletonMap(
                "task", taskRepository.findById(id).orElseThrow()
        );
    }

    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<Void> completeTask(@PathVariable Long id) {
        taskRepository.findById(id)
                .ifPresent(taskRepository::remove);

        return ResponseEntity.ok().build();
    }

    @ExceptionHandler(TaskNotFoundException.class)
    public ResponseEntity<String> handleTaskNotFoundException(TaskNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
}

