package com.example.Spotifyyy.service;

import com.example.Spotifyyy.dto.MusicDTO;
import com.example.Spotifyyy.dto.mapper.MusicMapper;
import com.example.Spotifyyy.repository.MusicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MusicServiceImpl implements MusicService {

    private final MusicRepository musicRepository;
    private final MusicMapper musicMapper;

    @Override
    public List<MusicDTO> listAll() {
        return musicRepository.findAll()
                .stream().map(musicMapper::toDTO)
                .sorted((music1, music2) -> music1.id().compareTo(music2.id()))
                .collect(Collectors.toList());
    }

    @Override
    public MusicDTO getById(Long id) {
        return musicRepository.findById(id)
                .map(musicMapper::toDTO)
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public MusicDTO createMusic(MusicDTO body) {
        return musicMapper.toDTO(musicRepository.save(musicMapper.toEntity(body)));
    }

    @Override
    public MusicDTO updateMusic(Long id, MusicDTO body) {
        return musicRepository.findById(id)
                .map(data -> {
                    data.setAuthor(body.author());
                    data.setNameMusic(body.nameMusic());
                    return musicMapper.toDTO(data);
                }).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public void deleteMusic(Long id) {
        musicRepository.delete(musicRepository.findById(id)
                .orElseThrow(NoSuchElementException::new));
    }
}
