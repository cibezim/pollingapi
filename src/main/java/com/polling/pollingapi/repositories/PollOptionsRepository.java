package com.polling.pollingapi.repositories;

import com.polling.pollingapi.models.PollOptions;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PollOptionsRepository extends JpaRepository<PollOptions, Long> {
    }
