package com.example.quizapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ScoreboardActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoreboard);

        // Get the shared preferences instance
        sharedPreferences = getSharedPreferences("Scores", MODE_PRIVATE);

        // Display the best scores
        displayBestScores();

        Button btn = findViewById(R.id.back_btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHomePage();
            }
        });
    }

    private void displayBestScores() {
        // Retrieve the best scores from shared preferences and display them
        // Assuming you have stored the scores using keys "Quiz1Score", "Quiz2Score", etc.

        // Find the TextView in the layout to display the scores
        TextView scoresTextView = findViewById(R.id.scoresTextView);

        StringBuilder scoresBuilder = new StringBuilder();

        // Retrieve and display the best score for Quiz 1
        int quiz1Score = sharedPreferences.getInt("Quiz1Score", 0);
        scoresBuilder.append("Movies Best Score: ").append(quiz1Score).append("\n");

        // Retrieve and display the best score for Quiz 2
        int quiz2Score = sharedPreferences.getInt("Quiz2Score", 0);
        scoresBuilder.append("Games Best Score: ").append(quiz2Score).append("\n");

        // Retrieve and display the best score for Quiz 3
        int quiz3Score = sharedPreferences.getInt("Quiz3Score", 0);
        scoresBuilder.append("Sports Best Score: ").append(quiz3Score).append("\n");

        // Retrieve and display the best score for Quiz 3
        int quiz4Score = sharedPreferences.getInt("Quiz4Score", 0);
        scoresBuilder.append("History Best Score: ").append(quiz3Score).append("\n");


        // Display the scores in the TextView
        scoresTextView.setText(scoresBuilder.toString());
    }

    public void openHomePage() {
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
    }

}


