package com.polling.pollingapi.repositories;

import com.polling.pollingapi.models.Poll;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PollRepository extends JpaRepository<Poll, Long> {
}


