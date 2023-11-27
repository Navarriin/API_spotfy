package com.example.Spotifyyy.music;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "musics")
@Entity(name = "musics")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Music {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String author;
    private String nameMusic;

    public Music(MusicRequestDTO data){
        this.author = data.author();
        this.nameMusic = data.nameMusic();
    }

    public Music(MusicDeleteDTO data){
        this.id = data.id();
    }
}
