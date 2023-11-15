package com.polling.pollingapi.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name="Poll")
public class Poll {

    @Id
    @GeneratedValue
    @Column(name = "POLL_ID")
    private Long id;

    @Column(name = "QUESTION")
    private String question;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "POLL_ID")
    @OrderBy
    @JsonManagedReference
    private Set<PollOptions> options;

    public Poll() {
    }

    public Poll(Long id, String question, Set<PollOptions> options) {
        this.id = id;
        this.question = question;
        this.options = options;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Set<PollOptions> getOptions() {
        return options;
    }

    public void setOptions(Set<PollOptions> options) {
        this.options = options;
    }
}

