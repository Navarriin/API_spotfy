package com.example.Spotifyyy.controller;

import com.example.Spotifyyy.music.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    @GetMapping("/{id}")
    public ResponseEntity getMusic(@PathVariable Long id){
        Optional<Music> optionalMusic = repository.findById(id);
        if(optionalMusic.isPresent()){
            Music music = optionalMusic.get();
            return ResponseEntity.ok(music);
        }
        return ResponseEntity.notFound().build();
    }
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public ResponseEntity createMusic(@RequestBody MusicRequestDTO data){
        Music musicData = new Music(data);
        repository.save(musicData);
        return ResponseEntity.ok(musicData);
    }
    @PutMapping()
    @Transactional
    public ResponseEntity updateMusic(@RequestBody MusicResponseDTO data){
        Optional<Music> optionalMusic = repository.findById(data.id());
        if(optionalMusic.isPresent()){
            Music music = optionalMusic.get();
            music.setAuthor(data.author());
            music.setNameMusic(data.nameMusic());
            return ResponseEntity.ok(music);
        }
        return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteMusic(@PathVariable Long id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
