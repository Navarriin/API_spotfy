package com.example.Spotifyyy.service;

import com.example.Spotifyyy.dto.MusicDTO;

import java.util.List;


public interface MusicService {
    public List<MusicDTO> listAll ();
    public MusicDTO getById (Long id);
    public MusicDTO createMusic (MusicDTO body);
    public MusicDTO updateMusic (Long id, MusicDTO body);
    public void deleteMusic (Long id);

}
