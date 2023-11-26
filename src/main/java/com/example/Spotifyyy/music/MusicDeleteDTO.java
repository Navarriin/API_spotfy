package com.example.Spotifyyy.music;

public record MusicDeleteDTO(Long id) {
    public MusicDeleteDTO(Music music){this(music.getId());}
}
