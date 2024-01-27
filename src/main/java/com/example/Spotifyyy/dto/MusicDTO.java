package com.example.Spotifyyy.dto;

import com.example.Spotifyyy.model.Music;

public record MusicDTO(Long id, String author, String nameMusic) {
    public MusicDTO(Music music) {
        this(music.getId(), music.getAuthor(), music.getNameMusic());
    }
}

