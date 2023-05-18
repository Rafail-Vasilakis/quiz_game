package com.example.quizapp;

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;

public class BackgroundMusicService extends Service {

    private MediaPlayer mediaPlayer;
    private final IBinder binder = new LocalBinder();
    private AudioManager audioManager;
    private int currentVolume = 0;

    @Override
    public void onCreate() {
        super.onCreate();
        mediaPlayer = MediaPlayer.create(this, R.raw.soundapp);
        mediaPlayer.setLooping(true);
        audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
        currentVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mediaPlayer.start();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        mediaPlayer.stop();
        mediaPlayer.release();
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    public void startMusic() {
        mediaPlayer.start();
    }

    public void pauseMusic() {
        mediaPlayer.pause();
    }

    public void adjustVolume(int progress) {
        float volume = (float) progress / 100;
        audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, (int) (volume * audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC)), 0);
        currentVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
    }

    public void stopMusic() {
        mediaPlayer.stop();
        mediaPlayer.prepareAsync();
    }

    public int getCurrentVolume() {
        return currentVolume;
    }


    public class LocalBinder extends Binder {
        public BackgroundMusicService getService() {
            return BackgroundMusicService.this;
        }
    }
}
