package com.example.quizapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class home_page  extends AppCompatActivity{

    Button movies, games, sports, history;

    Button exitBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);
    }

    public void onButtonClick(View view) {
        Button button = (Button) view;
        button.setBackgroundColor(Color.WHITE);

        // Navigate to the desired layout page
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    }
