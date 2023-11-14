package com.polling.pollingapi.controller;

import com.polling.pollingapi.dto.OptionCount;
import com.polling.pollingapi.dto.VoteResult;
import com.polling.pollingapi.repositories.VoteRepository;
import com.polling.pollingapi.models.Vote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/computeresult")
public class ComputeResultController {

    private final VoteRepository voteRepository;

    @Autowired
    public ComputeResultController(VoteRepository voteRepository) {
        this.voteRepository = voteRepository;
    }

    @GetMapping
    public ResponseEntity<VoteResult> computeResult(@RequestParam Long pollId) {
        VoteResult voteResult = new VoteResult();
        Iterable<Vote> allVotes = voteRepository.findByPollId(pollId);

        int totalVotes = 0;
        Map<Long, OptionCount> tempMap = new HashMap<>();

        for (Vote v : allVotes) {
            totalVotes++;

            OptionCount optionCount = tempMap.get(v.getOption().getId());
            if (optionCount == null) {
                optionCount = new OptionCount();
                optionCount.setOptionId(v.getOption().getId());
                tempMap.put(v.getOption().getId(), optionCount);
            }

            optionCount.setCount(optionCount.getCount() + 1);
        }

        voteResult.setTotalVotes(totalVotes);
        voteResult.setResults(tempMap.values());

        return new ResponseEntity<>(voteResult, HttpStatus.OK);
    }
}


