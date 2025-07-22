package com.votingsystem.controller;

import com.votingsystem.dto.VoteDto;
import com.votingsystem.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/votes")
public class VoteController {

    @Autowired
    private VoteService voteService;

    @PostMapping("/submit")
    public String submitVote(@ModelAttribute VoteDto voteDto) {
        voteService.submitVote(voteDto);
        return "redirect:/polls/" + voteDto.getPollId();
    }

    @GetMapping("/results/{pollId}")
    public String viewResults(@PathVariable Long pollId, org.springframework.ui.Model model) {
        model.addAttribute("results", voteService.getResults(pollId));
        return "vote-results";
    }
}