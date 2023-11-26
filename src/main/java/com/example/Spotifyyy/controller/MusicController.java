package com.example.Spotifyyy.controller;

import com.example.Spotifyyy.music.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("musics")
public class MusicController {
    @Autowired
    private MusicRepository repository;
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<MusicResponseDTO> getAll(){
        List<MusicResponseDTO> musicList = repository.findAll().stream().map(MusicResponseDTO::new).toList();
        return musicList;
    }
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void createMusic(@RequestBody MusicRequestDTO data){
        Music musicData = new Music(data);
        repository.save(musicData);
        return;
    }
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping
    public void deleteMusic(@RequestBody MusicDeleteDTO data){
        Music musicData = new Music(data);
        repository.delete(musicData);
        return;
    }

}
