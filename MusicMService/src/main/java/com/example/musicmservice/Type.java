package com.example.musicmservice;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;


@Entity
@Getter
@Setter
@AllArgsConstructor

public class Type {

    private static final long serialVersionUID = 6;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;


    @OneToMany(cascade = CascadeType.ALL,mappedBy = "type")
    @JsonIgnore
    private Set<Music> musics;



    public Type() {

    }

    public Type(String name, Set<Music> musics) {
        this.name = name;
        this.musics = musics;
    }



}
