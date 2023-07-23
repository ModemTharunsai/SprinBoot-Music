package com.example.song.model;

public class Song {
    private int songId;
    private String songName;
    private String lyricist;
    private String songSinger;
    private String musicDirector;

    public Song(int songId, String songName, String lyricist,String songSinger,String musicDirector) {
        this.songId = songId;
        this.songName = songName;
        this.songSinger=songSinger;
        this.lyricist= lyricist;
        this.musicDirector=musicDirector;
    }

    public int getsongId() {
        return songId;
    }

    public void setsongId(int songId) {
        this.songId = songId;
    }

    public String getsongName() {
        return songName;
    }

    public void setsongName(String songName) {
        this.songName = songName;
    }

    public String getlyricist() {
        return lyricist;
    }

    public void setlyricist(String lyricist) {
        this.lyricist = lyricist;
    }
     public String getsongSinger() {
        return songSinger;
    }

    public void setsongSinger(String songSinger) {
        this.songSinger = songSinger;
    }
    public String getmusicDirector() {
        return musicDirector;
    }

    public void setmusicDirector(String musicDirector) {
        this.musicDirector = musicDirector;
    }
} 