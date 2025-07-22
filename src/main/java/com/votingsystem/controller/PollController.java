package com.votingsystem.controller;

import com.votingsystem.dto.PollDto;
import com.votingsystem.service.PollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/polls")
public class PollController {

    @Autowired
    private PollService pollService;

    @GetMapping("/create")
    public String showCreatePollForm(Model model) {
        model.addAttribute("poll", new PollDto());
        return "poll-create";
    }

    @PostMapping("/create")
    public String createPoll(@ModelAttribute("poll") PollDto pollDto) {
        pollService.createPoll(pollDto);
        return "redirect:/polls";
    }

    @GetMapping
    public String listPolls(Model model) {
        model.addAttribute("polls", pollService.getAllPolls());
        return "poll-list";
    }

    @GetMapping("/{id}")
    public String pollDetails(@PathVariable Long id, Model model) {
        model.addAttribute("poll", pollService.getPollById(id));
        return "poll-detail";
    }
}