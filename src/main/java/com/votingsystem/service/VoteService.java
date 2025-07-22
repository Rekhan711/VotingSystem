package com.votingsystem.service;

import com.votingsystem.dto.VoteDto;
import com.votingsystem.entity.Option;
import com.votingsystem.entity.Poll;
import com.votingsystem.entity.User;
import com.votingsystem.entity.Vote;
import com.votingsystem.repository.VoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VoteService {
    private final VoteRepository voteRepository;

    public Vote castVote(User user, Poll poll, Option option) {
        Vote vote = new Vote();
        vote.setUser(user);
        vote.setPoll(poll);
        vote.setOption(option);
        return voteRepository.save(vote);
    }

    public List<Vote> getVotesByPoll(Poll poll) {
        return voteRepository.findByPoll(poll);
    }

    public void submitVote(VoteDto voteDto) {

    }

    public Object getResults(Long pollId) {
        return null;
    }
}