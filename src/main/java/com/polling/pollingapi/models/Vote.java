package com.polling.pollingapi.models;

import javax.persistence.*;

@Entity
@Table(name = "Vote")
public class Vote {

    @Id
    @GeneratedValue
    @Column(name = "VOTE_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "OPTION_ID")
    private PollOptions option;



    public Vote() {
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


}
