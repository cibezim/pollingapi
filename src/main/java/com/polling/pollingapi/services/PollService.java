package com.polling.pollingapi.services;

import com.polling.pollingapi.models.Poll;
import com.polling.pollingapi.repositories.PollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PollService {

    private final PollRepository pollRepository;

    @Autowired
    public PollService(PollRepository pollRepository) {
        this.pollRepository = pollRepository;
    }

    public ResponseEntity<Iterable<Poll>> getAllPolls() {
        return new ResponseEntity<>(pollRepository.findAll(), HttpStatus.OK);
    }

    public Optional<Poll> getPollById(Long pollId) {
        return pollRepository.findById(pollId);
    }

    public Poll createPoll(Poll poll) {
        return pollRepository.save(poll);
    }

    public void updatePoll(Long pollId, Poll updatedPoll) {
        Poll existingPoll = pollRepository.findById(pollId)
                .orElseThrow(() -> new RuntimeException("Poll not found with id: " + pollId));

        existingPoll.setQuestion(updatedPoll.getQuestion());
        existingPoll.setOptions(updatedPoll.getOptions());

        pollRepository.save(existingPoll);
    }

    public void deletePoll(Long pollId) {
        if (!pollRepository.existsById(pollId)) {
            throw new RuntimeException("Poll not found with id: " + pollId);
        }

        pollRepository.deleteById(pollId);
    }
}

