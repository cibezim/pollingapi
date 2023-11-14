package com.polling.pollingapi.models;

import javax.persistence.*;

@Entity
public class PollOptions {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name="value")
    private String value;

    @ManyToOne
    @JoinColumn(name = "poll_id")
    private Poll poll;

    public PollOptions() {
    }

    public PollOptions(Long id, String value, Poll poll) {
        this.id = id;
        this.value = value;
        this.poll = poll;
    }

    public Poll getPoll() {
        return poll;
    }

    public void setPoll(Poll poll) {
        this.poll = poll;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
