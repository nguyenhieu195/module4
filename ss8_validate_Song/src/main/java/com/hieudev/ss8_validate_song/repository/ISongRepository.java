package com.hieudev.ss8_validate_song.repository;

import com.hieudev.ss8_validate_song.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISongRepository extends JpaRepository<Song, Long> {

}