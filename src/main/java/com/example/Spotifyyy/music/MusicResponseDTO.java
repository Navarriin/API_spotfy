package com.example.Spotifyyy.music;

public record MusicResponseDTO(Long id, String author, String nameMusic) {
    public MusicResponseDTO(Music music) {
        this(music.getId(), music.getAuthor(), music.getNameMusic());
    }
}
