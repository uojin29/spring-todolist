package com.example.todolist.repository;

import com.example.todolist.dto.Task;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JdbcTemplateTaskRepository implements TaskRepository {
    @Override
    public void save(Task task) {

    }

    @Override
    public Optional<Task> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Task> findAll() {
        return null;
    }

    @Override
    public void update(Task task) {

    }

    @Override
    public void remove(Task task) {

    }
}
