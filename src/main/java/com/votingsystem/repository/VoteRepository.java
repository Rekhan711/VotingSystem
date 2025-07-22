package com.votingsystem.repository;

import com.votingsystem.entity.Poll;
import com.votingsystem.entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VoteRepository extends JpaRepository<Vote, Long> {
    List<Vote> findByPoll(Poll poll);
}
