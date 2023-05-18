package com.example.quizapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class HomePage extends AppCompatActivity {

    Button movies, games, sports, history;

    Button exitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);

        Button btn = findViewById(R.id.movies_btn);
        Button btn1 = findViewById(R.id.games_btn);
        Button btn2 = findViewById(R.id.sports_btn);
        Button btn3 = findViewById(R.id.history_btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn.setBackgroundColor(Color.MAGENTA);
                openMain();
            }

        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn1.setBackgroundColor(Color.MAGENTA);
                openGameQuiz();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn2.setBackgroundColor(Color.MAGENTA);
                openSportsQuiz();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn3.setBackgroundColor(Color.MAGENTA);
                openHistoryQuiz();
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
}