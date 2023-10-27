package com.example.musicmservice;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;




@Entity

@Getter
@Setter
@AllArgsConstructor
public class Music implements Serializable {

    private static final long serialVersionUID = 6;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    private String album;

    private String audio;


    @ManyToOne
    private Type type;



    public Music() {

    }

    public Music(String title, String album, String audio, Type type) {

        this.title = title;
        this.album = album;
        this.audio = audio;
        this.type = type;
    }



}
