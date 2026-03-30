package com.hieudev.ss8_validate_song.controller;

import com.hieudev.ss8_validate_song.dto.SongDto;
import com.hieudev.ss8_validate_song.entity.Song;
import com.hieudev.ss8_validate_song.service.ISongService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class SongController {

    @Autowired
    private ISongService songService;

    @GetMapping("/add-song")
    public String showAddForm(ModelMap model) {
        model.addAttribute("song", new SongDto());
        return "add-song";
    }

    @PostMapping("/save-song")
    public String saveSong(@Valid @ModelAttribute("song") SongDto songDto,
                           BindingResult result,
                           ModelMap model) {
        if (result.hasErrors()) {
            return "add-song";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDto, song);
        songService.save(song);
        model.addAttribute("song", songDto);
        return "song-success";
    }

    @GetMapping("/edit-song/{id}")
    public String showEditForm(@PathVariable("id") Long id, ModelMap model) {
        Song song = songService.findById(id);
        model.addAttribute("song", song);
        return "edit-song";
    }

    @PostMapping("/update-song")
    public String updateSong(@Valid @ModelAttribute("song") SongDto songDto,
                             BindingResult result,
                             ModelMap model) {
        if (result.hasErrors()) {
            return "edit-song";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDto, song);
        songService.save(song);
        model.addAttribute("song", songDto);
        return "song-success";
    }
}