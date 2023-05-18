package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CommentActivity extends AppCompatActivity {

    private EditText commentEditText;
    private Button addCommentButton;
    private TextView commentTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comment_page);

        commentEditText = findViewById(R.id.comment_edit_text);
        addCommentButton = findViewById(R.id.submit_btn);
        commentTextView = findViewById(R.id.comment_text_view);

        addCommentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addComment();
            }
        });

        Button btn = findViewById(R.id.submit_btn);
        Button btn1 = findViewById(R.id.back_btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addComment();
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHomePage();
            }
        });
    }

    private void addComment() {
        String comment = commentEditText.getText().toString().trim();
        if (!comment.isEmpty()) {
            commentTextView.append("\n" + comment + "\n");
            commentEditText.setText("");
        }
    }

    public void openHomePage() {
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
    }
}
