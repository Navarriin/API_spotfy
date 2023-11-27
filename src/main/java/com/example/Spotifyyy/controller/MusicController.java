package com.example.Spotifyyy.controller;

import com.example.Spotifyyy.domain.music.Music;
import com.example.Spotifyyy.domain.music.MusicRepository;
import com.example.Spotifyyy.domain.music.MusicRequestDTO;
import com.example.Spotifyyy.domain.music.MusicResponseDTO;
import jakarta.persistence.EntityNotFoundException;
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
        } else {
            throw new EntityNotFoundException();
        }
    }
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public ResponseEntity createMusic(@RequestBody MusicRequestDTO data){
        Music musicData = new Music(data);
        repository.save(musicData);
        return ResponseEntity.ok(musicData);
    }
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity updateMusic(@PathVariable Long id, @RequestBody MusicResponseDTO data){
        Optional<Music> optionalMusic = repository.findById(id);
        if(optionalMusic.isPresent()){
            Music music = optionalMusic.get();
            music.setAuthor(data.author());
            music.setNameMusic(data.nameMusic());
            return ResponseEntity.ok(music);
        }else {
            throw new EntityNotFoundException();
        }

    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteMusic(@PathVariable Long id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
