package com.hieudev.ss8_validate_song.controller;

import com.hieudev.ss8_validate_song.entity.Song;
import com.hieudev.ss8_validate_song.service.ISongService;
import jakarta.validation.Valid;
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
        model.addAttribute("song", new Song());
        return "add-song";
    }

    @PostMapping("/save-song")
    public String saveSong(@Valid @ModelAttribute("song") Song song,
                           BindingResult result,
                           ModelMap model) {
        if (result.hasErrors()) {
            return "add-song";
        }
        songService.save(song);
        model.addAttribute("song", song);
        return "song-success";
    }

    @GetMapping("/edit-song/{id}")
    public String showEditForm(@PathVariable("id") Long id, ModelMap model) {
        Song song = songService.findById(id);
        model.addAttribute("song", song);
        return "edit-song";
    }

    @PostMapping("/update-song")
    public String updateSong(@Valid @ModelAttribute("song") Song song,
                             BindingResult result,
                             ModelMap model) {
        if (result.hasErrors()) {
            return "edit-song";
        }
        songService.save(song);
        model.addAttribute("song", song);
        return "song-success";
    }
}