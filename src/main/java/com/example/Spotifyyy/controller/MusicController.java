package com.example.Spotifyyy.controller;

import com.example.Spotifyyy.music.Music;
import com.example.Spotifyyy.music.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("musics")
public class MusicController {
    @Autowired
    private MusicRepository repository;
    @GetMapping
    public List<Music> getAll(){
        List<Music> musicList = repository.findAll();
        return musicList;
    }
}
