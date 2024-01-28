package com.example.todolist.repository;

import com.example.todolist.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataJpaTaskRepository extends JpaRepository<Task, Long> {}
