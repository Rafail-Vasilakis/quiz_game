package com.example.quizapp;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class HomePage extends AppCompatActivity {

    private boolean isSoundEnabled;
    private BackgroundMusicService musicService;
    private boolean isServiceBound;

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName className, IBinder service) {
            BackgroundMusicService.LocalBinder binder = (BackgroundMusicService.LocalBinder) service;
            musicService = binder.getService();
            isServiceBound = true;
            if (isSoundEnabled) {
                musicService.startMusic();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName arg0) {
            isServiceBound = false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);

        isSoundEnabled = true; // Set your sound enabled preference here

        Button btn = findViewById(R.id.play_btn);
        Button btn1 = findViewById(R.id.settings_btn);
        Button btn2 = findViewById(R.id.exit_btn);
        Button btn3 = findViewById(R.id.scoreboardButton);
        TextView text = findViewById(R.id.comment_txt);


        if (isSoundEnabled && !isServiceBound) {
            bindMusicService();
        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openchoosequizpage();
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSettings();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Exit();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openScoreBoard();
            }
        });
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openComment();
            }
        });
    }

    private void bindMusicService() {
        Intent intent = new Intent(this, BackgroundMusicService.class);
        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        isSoundEnabled = true; // Get your sound enabled preference here
        if (isSoundEnabled && isServiceBound) {
            musicService.startMusic();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (!isSoundEnabled && isServiceBound) {
            musicService.pauseMusic();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (isServiceBound) {
            unbindService(serviceConnection);
            isServiceBound = false;
        }
    }

    public void openchoosequizpage() {
        // Navigate to the desired layout page
        Intent intent = new Intent(this, ChooseQuizGame.class);
        startActivity(intent);
    }
    public void  openScoreBoard() {
        // Navigate to the desired layout page
        Intent intent = new Intent(this, ScoreboardActivity.class);
        startActivity(intent);
    }
    public void openSettings() {
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
    }
    public void Exit() {
        finishAffinity();
    }
    private void openComment() {
        // Navigate to the desired layout page
        Intent intent = new Intent(this, CommentActivity.class);
        startActivity(intent);
    }

}
