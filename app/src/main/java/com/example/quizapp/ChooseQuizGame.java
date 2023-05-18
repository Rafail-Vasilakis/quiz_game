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

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ChooseQuizGame extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_quiz_game);


        Button btn = findViewById(R.id.movies_btn);
        Button btn1 = findViewById(R.id.games_btn);
        Button btn2 = findViewById(R.id.sports_btn);
        Button btn3 = findViewById(R.id.history_btn);
        Button btn4 = findViewById(R.id.back_btn);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMain();
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGameQuiz();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSportsQuiz();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHistoryQuiz();
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHomePage();
            }
        });
    }


    public void openMain() {
        // Navigate to the desired layout page
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void openGameQuiz() {
        Intent intent = new Intent(this, GamesQuiz.class);
        startActivity(intent);
    }

    public void openSportsQuiz() {
        Intent intent = new Intent(this, SportsQuiz.class);
        startActivity(intent);
    }

    public void openHistoryQuiz() {
        Intent intent = new Intent(this, HistoryQuiz.class);
        startActivity(intent);
    }

    public void openHomePage() {
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
    }


}
