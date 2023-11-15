package com.polling.pollingapi.controller;

import com.polling.pollingapi.exceptions.ResourceNotFoundException;
import com.polling.pollingapi.exceptions.ErrorResponse;
import com.polling.pollingapi.models.Poll;
import com.polling.pollingapi.repositories.PollRepository;
import com.polling.pollingapi.services.PollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Optional;

@RestController
public class PollController {

    private final PollRepository pollRepository;
    private final PollService pollService;

    @Autowired
    public PollController(PollRepository pollRepository, PollService pollService) {
        this.pollRepository = pollRepository;
        this.pollService = pollService;
    }

    @GetMapping("/polls")
    public ResponseEntity<Iterable<Poll>> getAllPolls() {
        return pollService.getAllPolls();
    }

    @PostMapping("/polls")
    public ResponseEntity<?> createPoll(@RequestBody Poll poll) {
        poll = pollService.createPoll(poll);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(poll.getId())
                .toUri());
        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @GetMapping("/polls/{pollId}")
    public ResponseEntity<?> getPoll(@PathVariable Long pollId) {
        Optional<Poll> p = pollService.getPollById(pollId);
        return new ResponseEntity<>(p.orElseThrow(() -> new ResourceNotFoundException("Poll", "id", pollId)), HttpStatus.OK);
    }

    @PutMapping("/polls/{pollId}")
    public ResponseEntity<?> updatePoll(@RequestBody Poll poll, @PathVariable Long pollId) {
        pollService.updatePoll(pollId, poll);
        Optional<Poll> p = pollRepository.findById(pollId);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @DeleteMapping("/polls/{pollId}")
    public ResponseEntity<?> deletePoll(@PathVariable Long pollId) {
        pollService.deletePoll(pollId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
