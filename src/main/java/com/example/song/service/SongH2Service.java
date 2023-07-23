package com.example.song.service;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.http.HttpStatus;
 import org.springframework.jdbc.core.JdbcTemplate;
 import org.springframework.stereotype.Service;
 import org.springframework.web.server.ResponseStatusException;
import java.util.ArrayList;
import com.example.song.repository.SongRepository;
import com.example.song.model.Song;
import java.util.*;
import com.example.song.model.SongRowMapper;
@Service
public class SongH2Service implements SongRepository{
    @Autowired
    private JdbcTemplate db;
@Override
public ArrayList<Song>getSongs(){
List<Song>songList=db.query("select * from playlist ",new SongRowMapper());
return new ArrayList<>(songList);

}
@Override
public Song getSongById(int songId){
    try{
Song song=db.queryForObject("select * from playlist where songId = ?", new SongRowMapper(),songId);
          return song;
       }catch (Exception e){
throw new ResponseStatusException(HttpStatus.NOT_FOUND);
}
}
@Override
public Song addSong(Song song){
    db.update("INSERT INTO playlist (songName,lyricist,songSinger,musicDirector)values(?,?,?,?)",song.getsongName(),song.getlyricist(),song.getsongSinger(),song.getmusicDirector());
   
    return getSongById(song.getsongId());
}
@Override
public Song updatedSong(int songId,Song song){
    if(song.getsongName()!=null){
        db.update("UPDATE playlist SET songName=? WHERE songId=?",song.getsongName(),songId);
    }
    if(song.getlyricist()!=null){
        db.update("UPDATE playlist SET lyricist=? WHERE songId=?",song.getlyricist(),songId);
    }
    if(song.getsongSinger()!=null){
        db.update("UPDATE playlist SET songSinger=? WHERE songId=?",song.getsongSinger(),songId);
    }
    if(song.getmusicDirector()!=null){
        db.update("UPDATE playlist SET musicDirector=? WHERE songId=?",song.getmusicDirector(),songId);
    }

    return getSongById(songId);
    }
@Override
public void deleteSong(int songId){
    db.update("DELETE FROM playlist WHERE songId=?",songId);
}
}