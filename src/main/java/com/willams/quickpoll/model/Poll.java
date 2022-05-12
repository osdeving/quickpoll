package com.willams.quickpoll.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Data
public class Poll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "POLL_ID")
    private Long id;

    @Column(name = "QUESTION")
    @NotEmpty
    private String question;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="POLL_ID")
    @OrderBy
    @Size(min=2,max=6)
    private Set<Option> options;
}
