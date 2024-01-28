package com.example.todolist.controller;

import com.example.todolist.dto.request.MemberRequest;
import com.example.todolist.domain.Member;
import com.example.todolist.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
// @Controller는 Spring MVC에서 Controller로 사용할 클래스에 붙이는 어노테이션이다.
@RequiredArgsConstructor
// RequiredArgsConstructor는 final이나 @NonNull인 필드 값만 파라미터로 받는 생성자(Constructor)를 만들어준다.
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/member")
    public String memberList(Model model) {
        List<Member> members = memberService.findAll();
        model.addAttribute("members", members);
        return "member";
    }

    @GetMapping("/member/search")
    public String searchMemberByUsername(@RequestParam String username, Model model) {
        Member member = memberService.findByUsername(username);
        model.addAttribute("searchedMember", member);
        return "member";
    }

    @PostMapping("/member/create")
    public String create(@ModelAttribute MemberRequest request) {
        memberService.create(request);
        return "redirect:/member";
    }

    @PostMapping("/member/update")
    public String updateMember(@ModelAttribute MemberRequest request) {
        memberService.update(request);
        return "redirect:/member";
    }

    @GetMapping("/member/delete/{id}")
    public String deleteMember(@PathVariable Long id) {
        memberService.delete(id);
        return "redirect:/member";
    }
}
