package com.polling.pollingapi.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Vote {

    @Id
    @GeneratedValue
    @Column(name = "VOTE_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "OPTION_ID")
    private PollOptions option;

    @Column(name = "POLL_ID")
    private Long pollId;

    public Vote() {
    }

    public Vote(Long id, PollOptions option, Long pollId) {
        this.id = id;
        this.option = option;
        this.pollId = pollId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PollOptions getOption() {
        return option;
    }

    public void setOption(PollOptions option) {
        this.option = option;
    }

    public Long getPollId() {
        return pollId;
    }

    public void setPollId(Long pollId) {
        this.pollId = pollId;
    }
}
