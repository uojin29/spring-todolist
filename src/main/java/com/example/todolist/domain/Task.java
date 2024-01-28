package com.example.todolist.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
// @Entity는 JPA에서 엔티티 클래스를 정의할 때 사용하는 어노테이션이다.
@Getter
@NoArgsConstructor
public class Task {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "task_id")
  private Long id;

  @Column(name = "content", nullable = false)
  private String content;

  public Task(String content) {
    this.content = content;
  }

  public void updateContent(String content) {
    this.content = content;
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "memberId")
  Member member;
}
