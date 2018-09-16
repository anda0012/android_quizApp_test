package com.quizpractice.testing2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Page2Python extends AppCompatActivity {

    String [][] answerOptions = new String[][] {
            {"8", "error", "53"},
            {"True", "False"},
            {"1stVar", "my var", "myVar","my-var"},
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2_python);

        final TextView textView3 = findViewById(R.id.q3_page2);
        final TextView textView4 = findViewById(R.id.q4_page2);

        final RadioGroup radioGroup3 = findViewById(R.id.q3_group3);
        final RadioGroup radioGroup4 = findViewById(R.id.q4_group4);

        ArrayList<String> questionList = new ArrayList<>();

        questionList.add("What will be the outcome of '5' + '3'?");
        questionList.add("A variable like x = 2 allows a user to store values.");
        questionList.add("Which of the following is a valid variable format?");

        // set question for textView3
        textView3.setText(questionList.get(0));

        // save question asked to shared pref
        SharedPreferences sharedPrefQ3 = getSharedPreferences("question3_display", MODE_PRIVATE);
        SharedPreferences.Editor editorQ3 = sharedPrefQ3.edit();
        editorQ3.putString("question3", textView3.getText().toString());
        editorQ3.commit();

        // display radio button option for displayed question
        showQuestionOptions(textView3, radioGroup3);

        // set question for textView4
        textView4.setText(questionList.get(2));

        // save question asked to shared pref
        SharedPreferences sharedPrefQ4 = getSharedPreferences("question4_display", MODE_PRIVATE);
        SharedPreferences.Editor editorQ4 = sharedPrefQ4.edit();
        editorQ4.putString("question4", textView4.getText().toString());
        editorQ4.commit();

        // display radio button option for displayed question
        showQuestionOptions(textView4, radioGroup4);

        final Button nextPage3 = findViewById(R.id.btn_next_pg3);

        nextPage3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int initialScore = 0;

                // retrieve score from page 1
                SharedPreferences sharedPreferences = getSharedPreferences("user_score", 0);
                int currentScore = sharedPreferences.getInt("score", 0);

                final int rbID3 = radioGroup3.getCheckedRadioButtonId();
                RadioButton radioButtonSelected3 = findViewById(rbID3);

                final int rbID4 = radioGroup4.getCheckedRadioButtonId();
                RadioButton radioButtonSelected4 = findViewById(rbID4);

                // list for textViews to loop through
                List<TextView> textViewsText = new ArrayList<>();
                textViewsText.add(textView3);
                textViewsText.add(textView4);

                // list of selected radio buttons to loop through
                List<RadioButton> radioButtonList = new ArrayList<>();
                radioButtonList.add(radioButtonSelected3);
                radioButtonList.add(radioButtonSelected4);

                for (int i = 0; i < textViewsText.size(); i++) {
                    if (textViewsText.get(i).getText().equals("What will be the outcome of '5' + '3'?")) {

                        for (int j = 0; j < radioButtonList.size(); j++) {
                            if (radioButtonList.get(j).getText().equals(answerOptions[0][2])) {
                                initialScore+=1;
                            }
                        }

                    }
                    if (textViewsText.get(i).getText().equals("Which of the following is a valid variable format?")) {

                        for (int j = 0; j < radioButtonList.size(); j++) {
                            if (radioButtonList.get(j).getText().equals(answerOptions[2][2])) {
                                initialScore+=1;
                            }
                        }

                    }

                } // end of for loop

                // update shared pref score

                SharedPreferences.Editor editor = sharedPreferences.edit();
                int updatedScore = currentScore + initialScore;
                editor.putInt("score", updatedScore);
                editor.commit();

                // go to score page
                Intent goToScore = new Intent(Page2Python.this, PythonScore.class);
                Page2Python.this.startActivity(goToScore);



            }
        });
    }

    private void showQuestionOptions(TextView textView, RadioGroup radioGroup) {
        if (textView.getText().equals("What will be the outcome of '5' + '3'?")) {

            RadioButton rb_q_option1 = new RadioButton(getApplicationContext());
            rb_q_option1.setText(answerOptions[0][0]);
            radioGroup.addView(rb_q_option1);

            RadioButton rb_q_option2 = new RadioButton(getApplicationContext());
            rb_q_option2.setText(answerOptions[0][1]);
            radioGroup.addView(rb_q_option2);

            RadioButton rb_q_option3 = new RadioButton(getApplicationContext());
            rb_q_option3.setText(answerOptions[0][2]);
            radioGroup.addView(rb_q_option3);

        }
        else if (textView.getText().equals("A variable like x = 2 allows a user to store values.")) {
            RadioButton rb_q_option1 = new RadioButton(getApplicationContext());
            rb_q_option1.setText(answerOptions[1][0]);
            radioGroup.addView(rb_q_option1);

            RadioButton rb_q_option2 = new RadioButton(getApplicationContext());
            rb_q_option2.setText(answerOptions[1][1]);
            radioGroup.addView(rb_q_option2);

        }
        else if (textView.getText().equals("Which of the following is a valid variable format?")) {
            RadioButton rb_q_option1 = new RadioButton(getApplicationContext());
            rb_q_option1.setText(answerOptions[2][0]);
            radioGroup.addView(rb_q_option1);

            RadioButton rb_q_option2 = new RadioButton(getApplicationContext());
            rb_q_option2.setText(answerOptions[2][1]);
            radioGroup.addView(rb_q_option2);

            RadioButton rb_q_option3 = new RadioButton(getApplicationContext());
            rb_q_option3.setText(answerOptions[2][2]);
            radioGroup.addView(rb_q_option3);

            RadioButton rb_q_option4 = new RadioButton(getApplicationContext());
            rb_q_option4.setText(answerOptions[2][3]);
            radioGroup.addView(rb_q_option4);
        }
    } // end of method
}
