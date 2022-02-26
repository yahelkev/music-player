package com.example.music_player.ui.main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.music_player.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class createPlaylist extends AppCompatActivity {

    FloatingActionButton doneCreatingBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_playlist);

        doneCreatingBtn = findViewById(R.id.done_creating_playlist_button);
        doneCreatingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { createPlaylist.super.onBackPressed(); }
        });
    }
}