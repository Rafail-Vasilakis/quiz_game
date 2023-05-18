package com.example.quizapp;

import android.app.AlertDialog;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SportsQuiz extends AppCompatActivity implements View.OnClickListener {

    TextView totalQuestionsTextView;
    TextView questionTextView;
    Button ansA, ansB, ansC, ansD;
    Button submitBtn;

    int score = 0;
    int totalQuestion = QuestionAnswer.sport_questions.length;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        totalQuestionsTextView = findViewById(R.id.total_questions);
        questionTextView = findViewById(R.id.question);
        ansA = findViewById(R.id.ans_A);
        ansB = findViewById(R.id.ans_B);
        ansC = findViewById(R.id.ans_C);
        ansD = findViewById(R.id.ans_D);
        submitBtn = findViewById(R.id.submit_btn);

        ansA.setOnClickListener(this);
        ansB.setOnClickListener(this);
        ansC.setOnClickListener(this);
        ansD.setOnClickListener(this);
        submitBtn.setOnClickListener(this);

        totalQuestionsTextView.setText("Total questions : " + totalQuestion);

        loadNewQuestion();
    }

    @Override
    public void onClick(View view) {
        ansA.setBackgroundColor(Color.WHITE);
        ansB.setBackgroundColor(Color.WHITE);
        ansC.setBackgroundColor(Color.WHITE);
        ansD.setBackgroundColor(Color.WHITE);

        Button clickedButton = (Button) view;
        if (clickedButton.getId() == R.id.submit_btn) {
            if (selectedAnswer.equals(QuestionAnswer.sport_correctAnswers[currentQuestionIndex])) {
                score++;
            }
            currentQuestionIndex++;

            if (currentQuestionIndex == totalQuestion) {
                saveScore();
                finishQuiz();
            } else {
                loadNewQuestion();
            }
        } else {
            //choices button clicked
            selectedAnswer = clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.MAGENTA);
        }
    }

    private void saveScore() {
        SharedPreferences sharedPreferences = getSharedPreferences("Scores", MODE_PRIVATE);
        int previousScore = sharedPreferences.getInt("Quiz3Score", 0);

        if (score > previousScore) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt("Quiz3Score", score);
            editor.apply();
        }
    }

    void loadNewQuestion() {

        if (currentQuestionIndex == totalQuestion) {
            finishQuiz();
            return;
        }

        questionTextView.setText(QuestionAnswer.sport_questions[currentQuestionIndex]);
        ansA.setText(QuestionAnswer.sport_choices[currentQuestionIndex][0]);
        ansB.setText(QuestionAnswer.sport_choices[currentQuestionIndex][1]);
        ansC.setText(QuestionAnswer.sport_choices[currentQuestionIndex][2]);
        ansD.setText(QuestionAnswer.sport_choices[currentQuestionIndex][3]);

    }

    void finishQuiz() {
        String passStatus = "";
        if (score > totalQuestion * 0.60) {
            passStatus = "Passed";
        } else {
            passStatus = "Failed";
        }

        new AlertDialog.Builder(this)
                .setTitle(passStatus)
                .setMessage("Score is " + score + " out of " + totalQuestion)
                .setPositiveButton("Restart", (dialogInterface, i) -> restartQuiz())
                .setCancelable(false)
                .show();


    }

    void restartQuiz() {
        score = 0;
        currentQuestionIndex = 0;
        loadNewQuestion();
    }
}
