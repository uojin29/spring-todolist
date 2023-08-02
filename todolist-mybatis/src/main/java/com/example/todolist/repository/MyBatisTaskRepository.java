package com.example.todolist.repository;

import com.example.todolist.dto.Task;
import org.apache.ibatis.annotations.*;
import org.springframework.context.annotation.Primary;

import java.util.List;
import java.util.Optional;

@Primary
@Mapper
public interface MyBatisTaskRepository extends TaskRepository {
    @Override
    @Insert("INSERT INTO task (title) " +
            "VALUES (#{title})")
    void save(Task task);

    @Override
    @Select("SELECT * FROM task WHERE id = #{id}")
    Optional<Task> findById(Long id);

    @Override
    @Select("SELECT * FROM task")
    List<Task> findAll();

    @Override
    @Update("UPDATE task " +
            "SET title = #{title} " +
            "WHERE id = #{id}")
    void update(Task task);

    @Override
    @Delete("DELETE FROM task WHERE id = #{id}")
    void remove(Task task);
}
