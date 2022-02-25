package com.example.music_player.ui.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.music_player.R;
import com.example.music_player.Song;

import java.util.ArrayList;
import java.util.Random;

public class playerActivity extends AppCompatActivity {

    ImageView btnBack, btnMenu, btnNext, btnPrev, btnRepeat, btnShuffle, btnPlayPause;
    TextView songTitle, songArtist;
    static MediaPlayer mediaPlayer;
    Integer index;
    Song currentSong;
    Uri uri;
    boolean shuffle = false;
    boolean repeat = false;
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

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        index = bundle.getInt("songIndex",0);
        currentSong = allSongsFrag.songsList.get(index);
        //setting display
        songTitle.setSelected(true);
        songArtist.setSelected(true);
        updateSong();

        btnPlayPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaPlayer.isPlaying()){
                    btnPlayPause.setImageResource(R.drawable.ic_baseline_play);
                    mediaPlayer.pause();
                }else {
                    btnPlayPause.setImageResource(R.drawable.ic_baseline_pause);
                    mediaPlayer.start();
                }
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!repeat) {
                    if (shuffle) {
                        index = new Random().nextInt(allSongsFrag.songsList.size());
                    } else {
                        index = (index + 1) % allSongsFrag.songsList.size();
                    }
                }
                updateSong();
            }
        });
        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                index = ((index-1)<0)?(allSongsFrag.songsList.size()-1):index-1;
                updateSong();
            }
        });
        btnShuffle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shuffle = !shuffle;
                if(shuffle) {
                    btnShuffle.setImageResource(R.drawable.ic_baseline_shuffle_activ);
                }else{
                    btnShuffle.setImageResource(R.drawable.ic_baseline_shuffle);
                }
            }
        });
        btnRepeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                repeat = !repeat;
                if(repeat) {
                    btnRepeat.setImageResource(R.drawable.ic_baseline_repeat_activ);
                }else{
                    btnRepeat.setImageResource(R.drawable.ic_baseline_repeat);
                }
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerActivity.super.onBackPressed();
            }
        });
        //when track ends
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                btnNext.performClick();
            }
        });
    }
    private void updateSong(){
        if(mediaPlayer != null){
            mediaPlayer.stop();
            mediaPlayer.release();
        }

        currentSong = allSongsFrag.songsList.get(index);
        songTitle.setText(currentSong.getTitle());
        songArtist.setText(currentSong.getArtist());

        uri = Uri.parse(currentSong.getPath());
        mediaPlayer = MediaPlayer.create(getApplicationContext(), uri);
        mediaPlayer.start();
        btnPlayPause.setImageResource(R.drawable.ic_baseline_pause);
    }
}