package com.example.Spotifyyy.controller;

import com.example.Spotifyyy.music.Music;
import com.example.Spotifyyy.music.MusicRepository;
import com.example.Spotifyyy.music.MusicRequestDTO;
import com.example.Spotifyyy.music.MusicResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("musics")
public class MusicController {
    @Autowired
    private MusicRepository repository;

    @PostMapping
    public void createMusic(@RequestBody MusicRequestDTO data){
        Music musicData = new Music(data);
        repository.save(musicData);
        return;
    }
    @GetMapping
    public List<MusicResponseDTO> getAll(){
        List<MusicResponseDTO> musicList = repository.findAll().stream().map(MusicResponseDTO::new).toList();
        return musicList;
    }
}
