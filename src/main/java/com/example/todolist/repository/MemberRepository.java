package com.example.todolist.repository;

import com.example.todolist.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface MemberRepository extends JpaRepository<Member, Long> {
//    List<Member> findAll();
    Member findByUsername(String username);
}
