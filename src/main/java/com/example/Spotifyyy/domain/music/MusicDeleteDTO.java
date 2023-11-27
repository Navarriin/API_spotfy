package com.example.Spotifyyy.domain.music;

public record MusicDeleteDTO(Long id) {
    public MusicDeleteDTO(Music music){this(music.getId());}
}
