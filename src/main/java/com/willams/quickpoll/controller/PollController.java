package com.willams.quickpoll.controller;

import com.willams.quickpoll.exception.ResourceNotFoundException;
import com.willams.quickpoll.model.Poll;
import com.willams.quickpoll.repository.PollRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.inject.Inject;
import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
public class PollController {
    @Inject
    private PollRepository pollRepository;

    protected Poll verifyPoll(Long pollId) throws ResourceNotFoundException {
        Optional<Poll> poll = pollRepository.findById(pollId);

        if (!poll.isPresent()) {
            throw new ResourceNotFoundException("Poll with id " + pollId + " not found");
        }

        return poll.get();
    }

    @GetMapping("/polls")
    public ResponseEntity<Iterable<Poll>> getAllPolls() {
        Iterable<Poll> allPolls = pollRepository.findAll();

        return new ResponseEntity<>(allPolls, HttpStatus.OK);
    }

    @GetMapping("/polls/{pollId}")
    public ResponseEntity<Poll> getPoll(@PathVariable Long pollId) {
        return new ResponseEntity<>(verifyPoll(pollId), HttpStatus.OK);
    }

    @PutMapping("/polls/{pollId}")
    public ResponseEntity<?> updatePoll(@RequestBody Poll poll, @PathVariable Long pollId) {
        verifyPoll(pollId);
        pollRepository.save(poll);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/polls/{pollId}")
    public ResponseEntity<?> deletePoll(@PathVariable Long pollId) {
        verifyPoll(pollId);
        pollRepository.deleteById(pollId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/polls")
    public ResponseEntity<?> createPoll(@RequestBody @Valid Poll poll) {
        poll = pollRepository.save(poll);

        HttpHeaders responseHeaders = new HttpHeaders();

        URI newPollUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(poll.getId())
                .toUri();

        responseHeaders.setLocation(newPollUri);
        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }
}
