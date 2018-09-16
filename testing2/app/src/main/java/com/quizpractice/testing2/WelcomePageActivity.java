package com.quizpractice.testing2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class WelcomePageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page);

        final ImageButton startPython = findViewById(R.id.btnPython);

        startPython.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent pythonQuiz = new Intent(WelcomePageActivity.this, Page1Python.class);
                WelcomePageActivity.this.startActivity(pythonQuiz);
            }
        });
    }
}
