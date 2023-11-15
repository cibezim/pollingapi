package com.polling.pollingapi.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name="POLL_OPTION")
public class PollOptions {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="OPTION_ID" )
    private Long id;


    @Column(name="value")
    private String value;

    @ManyToOne
    @JoinColumn(name="POLL_ID")
    @JsonBackReference
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
