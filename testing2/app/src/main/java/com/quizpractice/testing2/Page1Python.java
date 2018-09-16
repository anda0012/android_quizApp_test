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

public class Page1Python extends AppCompatActivity {

    String [][] answerOptions = new String[][] {
            {"True", "False"},
            {"print(4)", "print(myList[3])", "print(myList[4])"},
            {"display('Hello')", "show('Hello')", "print('Hello')", "run('Hello')"},
            {"True", "False"}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page1_python);

        final TextView textView1 = findViewById(R.id.q1_page1);
        final TextView textView2 = findViewById(R.id.q2_page1);

        final RadioGroup radioGroup1 = findViewById(R.id.q1_group1);
        final RadioGroup radioGroup2 = findViewById(R.id.q2_group2);

        ArrayList<String> questionList = new ArrayList<>();

        questionList.add("Python is not case-sensitive.");
        questionList.add("If you have list myList=[2,6,1,4,5], how do you print the number 4 in the list?");
        questionList.add("Which of the following commands do you use to output text?");
        questionList.add("Concatenation is the addition of 2 or more strings.");

        // set question 1 text
        textView1.setText(questionList.get(0));

        // save question asked to shared pref
        SharedPreferences sharedPrefQ1 = getSharedPreferences("question1_display", MODE_PRIVATE);
        SharedPreferences.Editor editorQ1 = sharedPrefQ1.edit();
        editorQ1.putString("question1", textView1.getText().toString());
        editorQ1.commit();

        // display question 1 options
        showQuestionOptions(textView1, radioGroup1);

        textView2.setText(questionList.get(1));

        SharedPreferences sharedPrefQ2 = getSharedPreferences("question2_display", MODE_PRIVATE);
        SharedPreferences.Editor editorQ2 = sharedPrefQ2.edit();
        editorQ2.putString("question2", textView2.getText().toString());
        editorQ2.commit();

        // display question 2 options
        showQuestionOptions(textView2, radioGroup2);

        final Button nextPage2 = findViewById(R.id.btn_next_pg2);

        nextPage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // initial score
                int score = 0;

                final int rbID = radioGroup1.getCheckedRadioButtonId();
                RadioButton radioButtonSelected1 = findViewById(rbID);
                String radioButtonText = radioButtonSelected1.getText().toString();

                final int rbID2 = radioGroup2.getCheckedRadioButtonId();
                RadioButton radioButtonSelected2 = findViewById(rbID2);
                String radioButtonText2 = radioButtonSelected2.getText().toString();

                // save selected radio buttons
                SharedPreferences sharedPrefRB1 = getSharedPreferences("q1_rbChoice", MODE_PRIVATE);
                SharedPreferences.Editor editorQ1_response = sharedPrefRB1.edit();
                editorQ1_response.putString("q1_rb_selected", radioButtonText);
                editorQ1_response.commit();

                SharedPreferences sharedPrefRB2 = getSharedPreferences("q2_rbChoice", MODE_PRIVATE);
                SharedPreferences.Editor editorQ2_response = sharedPrefRB2.edit();
                editorQ2_response.putString("q2_rb_selected", radioButtonText2);
                editorQ2_response.commit();

                // list for text views to loop through
                List<TextView> textViewsText = new ArrayList<>();
                textViewsText.add(textView1);
                textViewsText.add(textView2);

                // list of selected radio buttons to loop through
                List<RadioButton> radioButtonsList = new ArrayList<>();
                radioButtonsList.add(radioButtonSelected1);
                radioButtonsList.add(radioButtonSelected2);

                for (int i = 0; i < textViewsText.size(); i++) {
                    if (textViewsText.get(i).getText().equals("Python is not case-sensitive.")) {

                        for (int j = 0; j < radioButtonsList.size(); j++) {
                            if (radioButtonsList.get(j).getText().equals(answerOptions[0][1])) {
                                // increment score
                                score+=1;
                            }

                        }
                    }
                    if (textViewsText.get(i).getText().equals("If you have list myList=[2,6,1,4,5], how do you print the number 4 in the list?")) {

                        for (int j = 0; j < radioButtonsList.size(); j++) {
                            if (radioButtonsList.get(j).getText().equals(answerOptions[1][1])) {
                                // increment score
                                score+=1;
                            }
                        }

                    }
                }


                // save score to shared preferences
                SharedPreferences sharedPreferences = getSharedPreferences("user_score", 0);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("score", score);
                editor.commit();

                // go to page 2
                Intent goToPage2 = new Intent(Page1Python.this, Page2Python.class);
                Page1Python.this.startActivity(goToPage2);

            }
        });

    }
    

    private void showQuestionOptions(TextView textView, RadioGroup radioGroup) {
        if (textView.getText().equals("Python is not case-sensitive.")) {

            RadioButton rb_q_option1 = new RadioButton(getApplicationContext());
            rb_q_option1.setText(answerOptions[0][0]);
            radioGroup.addView(rb_q_option1);

            RadioButton rb_q1_option2 = new RadioButton(getApplicationContext());
            rb_q1_option2.setText(answerOptions[0][1]);
            radioGroup.addView(rb_q1_option2);
        }
        else if (textView.getText().equals("If you have list myList=[2,6,1,4,5], how do you print the number 4 in the list?")) {
            RadioButton rb_q_option1 = new RadioButton(getApplicationContext());
            rb_q_option1.setText(answerOptions[1][0]);
            radioGroup.addView(rb_q_option1);

            RadioButton rb_q_option2 = new RadioButton(getApplicationContext());
            rb_q_option2.setText(answerOptions[1][1]);
            radioGroup.addView(rb_q_option2);

            RadioButton rb_q_option3 = new RadioButton(getApplicationContext());
            rb_q_option3.setText(answerOptions[1][2]);
            radioGroup.addView(rb_q_option3);
        }
        else if (textView.getText().equals("Which of the following commands do you use to output text?")) {
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
