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

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn.setBackgroundColor(Color.RED);
                openActivity();
            }

        });
    }

    public void openActivity() {
        // Navigate to the desired layout page
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}