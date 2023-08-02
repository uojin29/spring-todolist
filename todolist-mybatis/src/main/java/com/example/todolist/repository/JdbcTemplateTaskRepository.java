package com.example.todolist.repository;

import com.example.todolist.dto.Task;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class JdbcTemplateTaskRepository implements TaskRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public void save(Task task) {
        jdbcTemplate.update(
                "INSERT INTO task (title) VALUES (?)", task.getTitle()
        );
    }

    @Override
    public Optional<Task> findById(Long id) {
        return jdbcTemplate.query(
                "SELECT * FROM task WHERE id = ?",
                BeanPropertyRowMapper.newInstance(Task.class),
                id).stream().findFirst();
    }

    @Override
    public List<Task> findAll() {
        return jdbcTemplate.query(
                "SELECT * FROM task",
                BeanPropertyRowMapper.newInstance(Task.class)
        );
    }

    @Override
    public void update(Task task) {
        jdbcTemplate.update(
                "UPDATE task SET title = ? WHERE id = ?",
                task.getTitle(), task.getId()
        );
    }

    @Override
    public void remove(Task task) {
        jdbcTemplate.update(
                "DELETE FROM task WHERE id = ?", task.getId()
        );
    }
}
