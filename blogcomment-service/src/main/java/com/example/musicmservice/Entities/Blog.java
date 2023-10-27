package com.example.musicmservice.Entities;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Blog implements Serializable  {

    @Id
    @GeneratedValue
    private int id;
    private String title;
    private String description;
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy="blog")
    private Set<Comment> comments;

}
