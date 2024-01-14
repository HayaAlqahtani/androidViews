package com.joincoded.trueorfalse;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView questionTextView, rightanswer, wronganswer, GradeTextView;
    private Button trueButton, falseButton, nextButton;

    private ArrayList<String> question;
    private ArrayList<Boolean> answers;
    private int currentIndex = 0;

    int grade = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        questionTextView = findViewById(R.id.questionTextView);
        rightanswer = findViewById(R.id.rightanswer);
        wronganswer = findViewById(R.id.Wronganswer);
        trueButton = findViewById(R.id.trueButton);
        falseButton = findViewById(R.id.falseButton);
        nextButton = findViewById(R.id.nextbutton);
        GradeTextView = findViewById(R.id.gradetextview);


        question = new ArrayList<>();
        answers = new ArrayList<>();


        question.add("The Sky is red");
        answers.add(false);

        question.add("the year is 2023");
        answers.add(false);

        question.add("i work for kfh");
        answers.add(true);

        displayQuestion();

        trueButton.setOnClickListener(view -> checkAnswer(true));
        falseButton.setOnClickListener(view -> checkAnswer(false));
        nextButton.setOnClickListener(view -> nextQuestion());
    }

    private void displayQuestion() {
        questionTextView.setText(question.get(currentIndex));

        GradeTextView.setText(String.valueOf(grade));

        rightanswer.setVisibility(View.INVISIBLE);
        wronganswer.setVisibility(View.INVISIBLE);
        nextButton.setVisibility(View.INVISIBLE);
        trueButton.setVisibility(View.VISIBLE);
        falseButton.setVisibility(View.VISIBLE);
    }

    private void checkAnswer(boolean userAnswer) {
        boolean correctAnswer = answers.get(currentIndex);

        if (userAnswer == correctAnswer) {

            rightanswer.setVisibility(View.VISIBLE);
            wronganswer.setVisibility(View.INVISIBLE);
            trueButton.setVisibility(View.INVISIBLE);
            falseButton.setVisibility(View.INVISIBLE);
            nextButton.setVisibility(View.VISIBLE);

            TheGrade();
        } else {

            rightanswer.setVisibility(View.INVISIBLE);
            wronganswer.setVisibility(View.VISIBLE);
            trueButton.setVisibility(View.VISIBLE);
            falseButton.setVisibility(View.VISIBLE);
            nextButton.setVisibility(View.INVISIBLE);
        }
    }

    public void TheGrade() {
        grade++;
        GradeTextView.setText(String.valueOf(grade));
    }

    private void nextQuestion() {
        currentIndex++;
        if (currentIndex < question.size()) {
            displayQuestion();
        } else {

        }
    }
}