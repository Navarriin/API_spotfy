package com.example.Spotifyyy.dto.mapper;

import com.example.Spotifyyy.dto.MusicDTO;
import com.example.Spotifyyy.model.Music;
import org.springframework.stereotype.Component;

@Component
public class MusicMapper {
    public MusicDTO toDTO(Music music) {
        if(music == null) return null;

        return new MusicDTO(music);
    }

    public Music toEntity(MusicDTO body) {
        if(body == null) return null;

        Music music = new Music();
        if(body.id() != null) music.setId(body.id());

        music.setAuthor(body.author());
        music.setNameMusic(body.nameMusic());
        return music;
    }
}
