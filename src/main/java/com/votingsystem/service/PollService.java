package com.votingsystem.service;

import com.votingsystem.dto.PollDto;
import com.votingsystem.entity.Option;
import com.votingsystem.entity.Poll;
import com.votingsystem.repository.PollRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PollService {
    private final PollRepository pollRepository;

    public Poll createPoll(PollDto pollDto) {
        Poll poll = new Poll();
        poll.setQuestion(pollDto.getQuestion());

        List<Option> options = pollDto.getOptions().stream().map(optionText -> {
            Option option = new Option();
            option.setText(optionText);
            option.setPoll(poll);
            return option;
        }).collect(Collectors.toList());

        poll.setOptions(options);
        return pollRepository.save(poll);
    }

    public List<Poll> getAllPolls() {
        return pollRepository.findAll();
    }

    public Optional<Poll> getPollById(Long id) {
        return pollRepository.findById(id);
    }
}