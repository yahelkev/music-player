package com.example.music_player.ui.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.music_player.R;
import com.example.music_player.Song;

import java.util.ArrayList;

public class playerActivity extends AppCompatActivity {

    ImageView btnBack, btnMenu, btnNext, btnPrev, btnRepeat, btnShuffle, btnPlayPause;
    TextView songTitle, songArtist;
    static MediaPlayer mediaPlayer;
    Integer index;
    Song currentSong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        btnBack = findViewById(R.id.back_btn);
        btnMenu = findViewById(R.id.menu_btn);
        btnNext = findViewById(R.id.next_btn);
        btnPrev = findViewById(R.id.prev_btn);
        btnRepeat = findViewById(R.id.repeat_btn);
        btnShuffle = findViewById(R.id.shuffle_btn);
        btnPlayPause = findViewById(R.id.play_pause_btn);

        songTitle = findViewById(R.id.song_title);
        songArtist = findViewById(R.id.song_artist);

        if(mediaPlayer != null){
            mediaPlayer.stop();
            mediaPlayer.release();
        }
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        index = bundle.getInt("songIndex",0);
        currentSong = allSongsFrag.songsList.get(index);
        //setting display
        songTitle.setSelected(true);
        songTitle.setText(currentSong.getTitle());
        songArtist.setSelected(true);
        songArtist.setText(currentSong.getArtist());

    }
}