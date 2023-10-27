package com.example.eventmanagement.Entities;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table (name = "events")
public class Event implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idEvent;
    private String nom;
    private String description;
    private String date;
    private String lieu;
    private String artiste;
    @JsonIgnoreProperties({"event"})
    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private Set<Ticket> tickets;

}
