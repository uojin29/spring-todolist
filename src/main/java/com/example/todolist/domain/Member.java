package com.example.todolist.domain;

import com.example.todolist.dto.request.MemberRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "memberId")
    private Long memberId;
    private String username;
    private String password;

    public void update(MemberRequest request) {
        this.username = request.getUsername();
        this.password = request.getPassword();
    }

    @OneToMany(mappedBy = "member")
    private List<Task> tasks = new ArrayList<>();
}