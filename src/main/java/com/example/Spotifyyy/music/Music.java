package com.example.Spotifyyy.music;

import jakarta.persistence.*;

@Table(name = "musics")
@Entity(name = "musics")
public class Music {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String author;
    private String nameMusic;
}
