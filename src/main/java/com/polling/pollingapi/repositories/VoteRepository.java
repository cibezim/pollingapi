package com.polling.pollingapi.repositories;

import com.polling.pollingapi.models.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {

    Iterable<Vote> findByPollId(Long pollId);



}