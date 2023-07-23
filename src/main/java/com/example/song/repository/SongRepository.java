package com.example.song.repository;
import com.example.song.model.Song;

import java.util.ArrayList;

public interface SongRepository {
    ArrayList<Song>getSongs();

    Song getSongById(int songId);
    Song addSong(Song song);
    Song updatedSong(int songId,Song song);
    void deleteSong(int songId);

}