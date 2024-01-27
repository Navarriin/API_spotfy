package com.example.Spotifyyy.controller;

import com.example.Spotifyyy.dto.MusicDTO;
import com.example.Spotifyyy.service.MusicService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("musics")
public class MusicController {

    private final MusicService musicService;

    @GetMapping
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<List<MusicDTO>> getAll(){
        return ResponseEntity.ok().body(musicService.listAll());
    }

    @GetMapping("/{id}")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<MusicDTO> getMusic(@PathVariable Long id){
        return ResponseEntity.ok().body(musicService.getById(id));
    }

    @PostMapping
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<MusicDTO> createMusic(@RequestBody MusicDTO body){
        return ResponseEntity.ok().body(musicService.createMusic(body));
    }

    @Transactional
    @PutMapping("/{id}")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<MusicDTO> updateMusic(@PathVariable Long id, @RequestBody MusicDTO body){
        return ResponseEntity.ok().body(musicService.updateMusic(id, body));
    }

    @DeleteMapping("/{id}")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<Void> deleteMusic(@PathVariable Long id){
        musicService.deleteMusic(id);
        return ResponseEntity.ok().build();
    }
}
