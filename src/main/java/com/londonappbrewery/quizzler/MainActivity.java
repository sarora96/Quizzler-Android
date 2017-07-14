package com.londonappbrewery.quizzler;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {


    // TODO: Declare constants here

    Button bTrue;
    Button bFalse;
    int score = 0;
    TextView tScore;
    TextView tQuestion;
    int count = 0;

    // TODO: Declare member variables here:
    ProgressBar pBar;
    boolean answer;
    int mQuestion;


    // TODO: Uncomment to create question bank
    private TrueFalse[] mQuestionBank = new TrueFalse[] {
            new TrueFalse(R.string.question_1, true),
            new TrueFalse(R.string.question_2, true),
            new TrueFalse(R.string.question_3, true),
            new TrueFalse(R.string.question_4, true),
            new TrueFalse(R.string.question_5, true),
            new TrueFalse(R.string.question_6, false),
            new TrueFalse(R.string.question_7, true),
            new TrueFalse(R.string.question_8, false),
            new TrueFalse(R.string.question_9, true),
            new TrueFalse(R.string.question_10, true),
            new TrueFalse(R.string.question_11, false),
            new TrueFalse(R.string.question_12, false),
            new TrueFalse(R.string.question_13,true)
    };

    final int PROGRESS_BAR_UPDATE = (int) Math.ceil(100.0/13);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bTrue = (Button) findViewById(R.id.true_button);
        bFalse = (Button) findViewById(R.id.false_button);

        pBar = (ProgressBar) findViewById(R.id.progress_bar);


        tScore = (TextView) findViewById(R.id.score);

        tQuestion = (TextView) findViewById(R.id.question_text_view);

        bTrue.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(checkAnswer(true))
                    score = score+1;

                updateQuestion();
            }
        });

        bFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkAnswer(false))
                    score = score+1;
                updateQuestion();
            }

        });


    }

    public void updateQuestion(){
        count = (count + 1) % 13;

        if(count == 0){
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("Game Over!");
            alert.setCancelable(false);
            alert.setMessage("You scored " + score + " points!");
            alert.setPositiveButton("Close Application", new DialogInterface.OnClickListener(){
                @Override
                public void onClick(DialogInterface dialog, int which){
                    finish();
                }
            });

            alert.show();
        }

        mQuestion = mQuestionBank[count].getQuestion();
        tQuestion.setText(mQuestion);
        pBar.incrementProgressBy(PROGRESS_BAR_UPDATE);
        tScore.setText("Score " + score + " /13");
    }

    public boolean checkAnswer(boolean answer){
        return mQuestionBank[count].getAnswer() == answer;

    }


}

