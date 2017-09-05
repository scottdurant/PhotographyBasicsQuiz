package com.example.android.photographybasicsquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calculateScore(View view) {
        // question one
        RadioButton rbOne = (RadioButton) findViewById(R.id.correct_answer_one_radio_button);
        boolean questionOne = rbOne.isChecked();

        // question two
        RadioButton rbTwo = (RadioButton) findViewById(R.id.correct_answer_two_radio_button);
        boolean questionTwo = rbTwo.isChecked();

        // question three
        boolean questionThree;
        CheckBox cbOne = (CheckBox) findViewById(R.id.nikon_check_box);
        CheckBox cbTwo = (CheckBox) findViewById(R.id.tamron_check_box);
        CheckBox cbThree = (CheckBox) findViewById(R.id.canon_check_box);
        CheckBox cbFour = (CheckBox) findViewById(R.id.sony_check_box);
        CheckBox cbFive = (CheckBox) findViewById(R.id.sigma_check_box);

        if (cbOne.isChecked() || cbThree.isChecked() || cbFour.isChecked()) {
            questionThree = false;
        } else if (cbTwo.isChecked() && cbFive.isChecked()) {
            questionThree = true;
        } else {
            questionThree = false;
        }

        // question four
        RadioButton rbFour = (RadioButton) findViewById(R.id.correct_answer_four_radio_button);
        boolean questionFour = rbFour.isChecked();

        // question five
        boolean questionFive;
        EditText questionFiveTextBox = (EditText) findViewById(R.id.q5_answer_box);
        String questionFiveAnswer = questionFiveTextBox.getText().toString();
        if (questionFiveAnswer.equalsIgnoreCase("raw")) {
            questionFive = true;
        } else {
            questionFive = false;
        }

        int score = 0;

        if (questionOne == true){
            score += 1;
        }
        if (questionTwo == true){
            score += 1;
        }
        if (questionThree == true){
            score += 1;
        }
        if (questionFour == true){
            score += 1;
        }
        if (questionFive == true){
            score += 1;
        }


        Button myButton = (Button) findViewById(R.id.calculateScoreButton);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent scoreIntent = new Intent(MainActivity.this, score.class);
                startActivity(scoreIntent);

            }
        });

        //Toast.makeText(this, "You scored " + score + "/5", Toast.LENGTH_LONG).show();

    }
}