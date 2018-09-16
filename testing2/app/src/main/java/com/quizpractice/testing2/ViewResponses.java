package com.quizpractice.testing2;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ViewResponses extends AppCompatActivity {

    String [][] answerOptions = new String[][] {
            {"True", "False"},
            {"print(4)", "print(myList[3])", "print(myList[4])"},
            {"display('Hello')", "show('Hello')", "print('Hello')", "run('Hello')"},
            {"True", "False"},
            {"8", "error", "53"},
            {"True", "False"},
            {"1stVar", "my var", "myVar","my-var"},
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_responses);

        ArrayList<String> questionList = new ArrayList<>();
        questionList.add("Python is not case-sensitive.");
        questionList.add("If you have list myList=[2,6,1,4,5], how do you print the number 4 in the list?");
        questionList.add("Which of the following commands do you use to output text?");
        questionList.add("Concatenation is the addition of 2 or more strings.");
        questionList.add("What will be the outcome of '5' + '3'?");
        questionList.add("A variable like x = 2 allows a user to store values.");
        questionList.add("Which of the following is a valid variable format?");

        final TextView textView1 = findViewById(R.id.q1_text);
        final TextView textView2 = findViewById(R.id.q2_text);
        final TextView textView3 = findViewById(R.id.q3_text);
        final TextView textView4 = findViewById(R.id.q4_text);

        final RadioGroup radioGroupResponse1 = findViewById(R.id.q1_radio_group);
        final RadioGroup radioGroupResponse2 = findViewById(R.id.q2_radio_group);
        final RadioGroup radioGroupResponse3 = findViewById(R.id.q3_radio_group);
        final RadioGroup radioGroupResponse4 = findViewById(R.id.q4_radio_group);

        // retrieve shared prefs for each question

        SharedPreferences sharedPrefRetrieveQ1 = getSharedPreferences("question1_display", MODE_PRIVATE);
        String q1retrieved = sharedPrefRetrieveQ1.getString("question1", "defaultQ1");

        SharedPreferences sharedPrefRetrieveQ2 = getSharedPreferences("question2_display", MODE_PRIVATE);
        String q2retrieved = sharedPrefRetrieveQ2.getString("question2", "defaultQ2");

        SharedPreferences sharedPrefRetrieveQ3 = getSharedPreferences("question3_display", MODE_PRIVATE);
        String q3retrieved = sharedPrefRetrieveQ3.getString("question3", "defaultQ3");

        SharedPreferences sharedPrefRetrieveQ4 = getSharedPreferences("question4_display", MODE_PRIVATE);
        String q4retrieved = sharedPrefRetrieveQ4.getString("question4", "defaultQ4");

        // show previously answered questions

        textView1.setText(q1retrieved.toString());

        showQuestionOptions(textView1, radioGroupResponse1);

        textView2.setText(q2retrieved.toString());
        showQuestionOptions(textView2, radioGroupResponse2);

        textView3.setText(q3retrieved.toString());
        showQuestionOptions(textView3, radioGroupResponse3);

        textView4.setText(q4retrieved.toString());
        showQuestionOptions(textView4, radioGroupResponse4);

        // retrieve shared prefs for each answer selected

        SharedPreferences sharedPrefRetrieveA1 = getSharedPreferences("q1_rbChoice", MODE_PRIVATE);
        String answer1_retrieved = sharedPrefRetrieveA1.getString("q1_rb_selected", "default");

        // list for text views to loop through
        List<TextView> textViewsText = new ArrayList<>();
        textViewsText.add(textView1);
        textViewsText.add(textView2);
        textViewsText.add(textView3);
        textViewsText.add(textView4);

        int childCount = radioGroupResponse1.getChildCount();

        for (int i = 0; i < textViewsText.size(); i++) {

            if (textViewsText.get(i).getText().equals("Python is not case-sensitive.")) {

                for (int j = 0; j < childCount; j++) {
                    RadioButton radioButton = (RadioButton) radioGroupResponse1.getChildAt(j);

                    radioButton.setEnabled(false);
                    radioButton.setTextColor(getResources().getColor(R.color.black));

                    if (radioButton.getText().equals(answerOptions[0][1])) {
                        // highlight correct answer green
                        radioButton.setBackgroundColor(getResources().getColor(R.color.lightGreen));
                    }
                    if (radioButton.getText().equals(answer1_retrieved)) {
                        radioButton.setChecked(true);

                        if (answer1_retrieved.equals(answerOptions[0][1])) {
                           // radioButton.setBackgroundColor(getResources().getColor(R.color.lightGreen));

                        }
                        else {
                            // highlight incorrect response red
                            radioButton.setBackgroundColor(getResources().getColor(R.color.lightRed));
                        }
                    }
                }
            }
        }


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
        else if (textView.getText().equals("What will be the outcome of '5' + '3'?")) {

            RadioButton rb_q_option1 = new RadioButton(getApplicationContext());
            rb_q_option1.setText(answerOptions[4][0]);
            radioGroup.addView(rb_q_option1);

            RadioButton rb_q_option2 = new RadioButton(getApplicationContext());
            rb_q_option2.setText(answerOptions[4][1]);
            radioGroup.addView(rb_q_option2);

            RadioButton rb_q_option3 = new RadioButton(getApplicationContext());
            rb_q_option3.setText(answerOptions[4][2]);
            radioGroup.addView(rb_q_option3);

        }
        else if (textView.getText().equals("A variable like x = 2 allows a user to store values.")) {
            RadioButton rb_q_option1 = new RadioButton(getApplicationContext());
            rb_q_option1.setText(answerOptions[5][0]);
            radioGroup.addView(rb_q_option1);

            RadioButton rb_q_option2 = new RadioButton(getApplicationContext());
            rb_q_option2.setText(answerOptions[5][1]);
            radioGroup.addView(rb_q_option2);

        }
        else if (textView.getText().equals("Which of the following is a valid variable format?")) {
            RadioButton rb_q_option1 = new RadioButton(getApplicationContext());
            rb_q_option1.setText(answerOptions[6][0]);
            radioGroup.addView(rb_q_option1);

            RadioButton rb_q_option2 = new RadioButton(getApplicationContext());
            rb_q_option2.setText(answerOptions[6][1]);
            radioGroup.addView(rb_q_option2);

            RadioButton rb_q_option3 = new RadioButton(getApplicationContext());
            rb_q_option3.setText(answerOptions[6][2]);
            radioGroup.addView(rb_q_option3);

            RadioButton rb_q_option4 = new RadioButton(getApplicationContext());
            rb_q_option4.setText(answerOptions[6][3]);
            radioGroup.addView(rb_q_option4);
        }
    } // end of method
}
