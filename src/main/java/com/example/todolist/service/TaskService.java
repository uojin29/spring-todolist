package com.example.todolist.service;

import com.example.todolist.domain.Task;
import com.example.todolist.exception.TaskNotFoundException;
import com.example.todolist.repository.DataJpaTaskRepository;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class TaskService {
  private final DataJpaTaskRepository taskRepository;

  public List<Task> getAllTasks() {
    return taskRepository.findAll();
  }

  public void addTask(String content) {
    Task task = new Task(content);
    taskRepository.save(task);
  }

  public Task updateTask(Long id, String content) {
    Task task = taskRepository.findById(id).orElseThrow(TaskNotFoundException::new);
    task.updateContent(content);
    return task;
  }

  public void removeTask(Long id) {
    Task task = taskRepository.findById(id).orElseThrow(TaskNotFoundException::new);
    taskRepository.delete(task);
  }
}
