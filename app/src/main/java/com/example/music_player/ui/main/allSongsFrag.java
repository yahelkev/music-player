package com.example.music_player.ui.main;

import android.Manifest;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.music_player.R;

import java.io.File;
import java.util.ArrayList;

public class allSongsFrag extends Fragment {
    ListView listView = null;
    String[] items;
    public allSongsFrag() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_all_songs, container, false);
    }
    public ArrayList<File> findSong (File file) {
        ArrayList<File> arrayList = new ArrayList<>();
        File[] files = file.listFiles();
        for (File singleFile: files){
            if(singleFile.isDirectory() && !singleFile.isHidden()){
                arrayList.addAll((findSong(singleFile)));
            }else{
             if (singleFile.getName().endsWith((".mp3")) || singleFile.getName().endsWith((".m4a"))){
                 arrayList.add(singleFile);
             }
            }
        }
        return arrayList;
    }

    void displaySongs(){
        final ArrayList<File> mySongs = findSong(Environment.getExternalStorageDirectory());
        items = new  String[mySongs.Size()]l
    }
}