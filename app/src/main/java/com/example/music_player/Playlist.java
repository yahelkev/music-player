package com.example.music_player;

import java.util.ArrayList;

public class Playlist {
    private ArrayList<Song> songs;

    public Playlist() {
    }

    public void addSong(Song song) {
        songs.add(song);

    }
}
