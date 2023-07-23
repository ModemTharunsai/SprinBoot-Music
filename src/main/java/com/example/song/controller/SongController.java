package com.example.song.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
 import org.springframework.web.server.ResponseStatusException;
 import org.springframework.http.HttpStatus;
import java.util.*;
import com.example.song.model.Song;

import com.example.song.service.SongH2Service;


@RestController
class SongController {
    @Autowired
    public SongH2Service songService;


    @GetMapping("/songs")
    public ArrayList<Song> getSongs() {
        return songService.getSongs();
    }

    @GetMapping("/songs/{songId}")
    public Song getSongById(@PathVariable int songId) {
        Song song = songService.getSongById(songId);
        if (song == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return song;
    }
     @PostMapping("/songs")
     public Song addSong(@RequestBody Song song){
return songService.addSong(song);
     }   

     @PutMapping("/songs/{songId}")
    public Song updatedSong(@PathVariable int songId, @RequestBody Song song) {
        Song songs = songService.getSongById(songId);
        if (songs == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return songService.updatedSong(songId, song);
    }
     @DeleteMapping("/songs/{songId}")
     public void deleteSong(@PathVariable("songId")int songId){
        songService.deleteSong(songId);
     }
}