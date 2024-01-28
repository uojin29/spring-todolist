package com.example.todolist.controller;

import com.example.todolist.domain.Task;
import com.example.todolist.dto.request.TaskRequest;
import com.example.todolist.exception.TaskNotFoundException;
import com.example.todolist.service.TaskService;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
// @Controller는 Spring MVC에서 Controller로 사용할 클래스에 붙이는 어노테이션이다.
@RequiredArgsConstructor
// RequiredArgsConstructor는 final이나 @NonNull인 필드 값만 파라미터로 받는 생성자(Constructor)를 만들어준다.
public class TaskController {
  // fianl? 불변성을 얻게 되어 안전하게 사용할 수 있기 때문에 service, repository 같은 클래스는 Autowired 대신 private final로 선언한다.
  private final TaskService taskService;

  // ("/")는 URI로 Uniform Resource Identifier의 약자. 주소라고 생각하면 된다. URL(Uniform Resource Locator) = (URI + protocol 정보)
  @GetMapping("/")
  // Model은 컨트롤러 -> 뷰로 정보를 넘기는 역할
  public String displayTasks(Model model) {
    List<Task> tasks = taskService.getAllTasks();
    model.addAttribute("tasks", tasks);
    return "index";
  }
  @PostMapping("/tasks")
  // @RequestParam은 요청의 쿼리 또는 폼데이터를 추출할 때 사용. 주로 문자열에 씀
  public String addTask(@RequestParam String content) {
    taskService.addTask(content);
    return "redirect:/";
  }

  @PutMapping("/tasks/{id}")
  @ResponseBody
  // @RequestBody는 요청의 본문을 추출할 때 사용. 주로 json형태. (restful api에서 많이 사용)
  public Map<String, Task> updateTask(@PathVariable Long id, @RequestBody TaskRequest form) {
    Task task = taskService.updateTask(id, form.getContent());
    return Collections.singletonMap("task", task);
  }

  @DeleteMapping("/tasks/{id}")
  public ResponseEntity<Void> completeTask(@PathVariable Long id) {
    taskService.removeTask(id);
    return ResponseEntity.ok().build();
  }

  @ExceptionHandler(TaskNotFoundException.class)
  public ResponseEntity<String> handleTaskNotFoundException(TaskNotFoundException e) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
  }
}
