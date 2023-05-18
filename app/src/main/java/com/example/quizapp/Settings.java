package com.example.quizapp;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Settings extends AppCompatActivity {

    private Switch soundSwitch;
    private CheckBox notificationsCheckbox;
    private SeekBar volumeSeekBar;
    private TextView volumeTextView;

    private BackgroundMusicService musicService;
    private boolean isMusicServiceBound = false;

    private boolean isMusicEnabled = true; // Default value is true for enabled





    private ServiceConnection musicServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            BackgroundMusicService.LocalBinder binder = (BackgroundMusicService.LocalBinder) service;
            musicService = binder.getService();
            isMusicServiceBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            musicService = null;
            isMusicServiceBound = false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_page);

        soundSwitch = findViewById(R.id.soundSwitch);
        notificationsCheckbox = findViewById(R.id.notificationsCheckbox);
        volumeSeekBar = findViewById(R.id.volumeSeekBar);
        volumeTextView = findViewById(R.id.volumeTextView);

        // Set the maximum value of volumeSeekBar to 100
        volumeSeekBar.setMax(100);
        // Set the initial progress of volumeSeekBar to 50
        volumeSeekBar.setProgress(50);
        // Update the volumeTextView with the initial progress value
        volumeTextView.setText(String.valueOf(volumeSeekBar.getProgress()));

        // Bind to the BackgroundMusicService
        Intent musicServiceIntent = new Intent(this, BackgroundMusicService.class);
        bindService(musicServiceIntent, musicServiceConnection, Context.BIND_AUTO_CREATE);



        soundSwitch.setChecked(true); // Set the switch as true initially

        soundSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // Sound is enabled
                    Toast.makeText(Settings.this, "Sound enabled", Toast.LENGTH_SHORT).show();
                    isMusicEnabled = true;
                    musicService.startMusic();
                } else {
                    // Sound is disabled
                    Toast.makeText(Settings.this, "Sound disabled", Toast.LENGTH_SHORT).show();
                    isMusicEnabled = false;
                    musicService.pauseMusic();
                }
            }
        });


        notificationsCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // Handle notifications checkbox state change
                if (isChecked) {
                    // Notifications are enabled
                    Toast.makeText(Settings.this, "Notifications enabled", Toast.LENGTH_SHORT).show();
                } else {
                    // Notifications are disabled
                    Toast.makeText(Settings.this, "Notifications disabled", Toast.LENGTH_SHORT).show();
                }
            }
        });

        volumeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // Update the volume text view based on the seek bar progress
                volumeTextView.setText(String.valueOf(progress));
                if (isMusicServiceBound) {
                    musicService.adjustVolume(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Empty implementation
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Empty implementation
            }
        });

        // Add more code to handle other settings elements
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Unbind from the BackgroundMusicService
        if (isMusicServiceBound) {
            unbindService(musicServiceConnection);
            isMusicServiceBound = false;
        }

        if (!isMusicEnabled) {
            // Pause or stop the music when the activity is destroyed
            musicService.pauseMusic();
        }
    }

    public void applyChanges(View view) {
        // Save the settings and apply the changes
        Toast.makeText(this, "Settings applied", Toast.LENGTH_SHORT).show();

        if (isMusicEnabled) {
            // Start or continue playing music
            musicService.startMusic();
        } else {
            // Pause or stop the music
            musicService.pauseMusic();
        }

        // Add code to save other settings and apply any necessary changes in your app

        if (!isMusicEnabled) {
            // Stop the music
            musicService.stopMusic();
        }

        // Navigate back to the home page
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
        finish(); // Finish the current activity to prevent going back to the settings page
    }


    @Override
    public void onBackPressed() {
        // Stop the music before going back
        if (isMusicServiceBound) {
            musicService.stopMusic();
        }
        super.onBackPressed(); // Continue with the back button functionality
    }


}
