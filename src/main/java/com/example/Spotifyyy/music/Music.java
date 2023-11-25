package com.example.Spotifyyy.music;

import jakarta.persistence.*;
import lombok.Getter;

@Table(name = "musics")
@Entity(name = "musics")
public class Music {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String author;
    private String nameMusic;
}
