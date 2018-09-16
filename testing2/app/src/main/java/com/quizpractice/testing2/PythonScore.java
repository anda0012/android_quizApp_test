package com.quizpractice.testing2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PythonScore extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_python_score);

        final TextView textViewScore = findViewById(R.id.show_score);

        // retrieve final score
        SharedPreferences sharedPreferencesUpdate = getSharedPreferences("user_score", 0);
        int finalScore = sharedPreferencesUpdate.getInt("score", 0);

        textViewScore.setText(String.valueOf(finalScore));

        final Button reviewResponses = findViewById(R.id.btn_review_responses);

        reviewResponses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent seeResponses = new Intent(PythonScore.this, ViewResponses.class);
                PythonScore.this.startActivity(seeResponses);
            }
        });
    }
}
