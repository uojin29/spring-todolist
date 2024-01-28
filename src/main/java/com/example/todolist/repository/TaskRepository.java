package com.example.todolist.repository;

import com.example.todolist.domain.Task;

import java.util.List;
import java.util.Optional;

public interface TaskRepository {
    void save(Task task);

    Optional<Task> findById(Long id);

    List<Task> findAll();

    void update(Task task);

    void delete(Task task);
}
