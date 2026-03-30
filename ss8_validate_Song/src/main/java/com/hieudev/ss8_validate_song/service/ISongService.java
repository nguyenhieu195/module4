package com.hieudev.ss8_validate_song.service;

import com.hieudev.ss8_validate_song.entity.Song;

import java.util.List;

public interface ISongService {
    Song save(Song song);
    Song findById(Long id);
    List<Song> findAll();
    void deleteById(Long id);
}