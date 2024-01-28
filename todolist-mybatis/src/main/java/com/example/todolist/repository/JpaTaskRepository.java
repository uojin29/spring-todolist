package com.example.todolist.repository;

import com.example.todolist.domain.Task;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class JpaTaskRepository implements TaskRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(Task task) {
        em.persist(task);
    }

    @Override
    public Optional<Task> findById(Long id) {
        return Optional.ofNullable(em.find(Task.class, id));
    }

    @Override
    public List<Task> findAll() {
        return em.createQuery("SELECT t FROM Task t", Task.class).getResultList();
    }

    @Override
    public void update(Task task) {
    }

    @Override
    public void delete(Task task) {
        em.remove(task);
    }
}
