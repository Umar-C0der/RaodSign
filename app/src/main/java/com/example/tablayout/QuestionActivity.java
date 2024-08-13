package com.example.tablayout;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class QuestionActivity extends AppCompatActivity {

    ImageView img;
    TextView questionNumber, time;
    RadioGroup radioGroup;
    RadioButton check;
    String ans;
    SQLite db = new SQLite(this);
    ArrayList<Datamode> data = new ArrayList<>();
    int count, min, sec, correctAns, randomNumber;
    CountDownTimer countDownTimer;

    ArrayList<Datamode> wrongQuestion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        SQLite db = new SQLite(QuestionActivity.this);
        Handler handler = new Handler();

        count = 1;
        min = 4;
        sec = 60;
        correctAns = 0;

        countDownTimer = new CountDownTimer(240000, 1000) { // 2-second delay with a tick interval of 1 second
            public void onTick(long millisUntilFinished) {
                sec--;
                if (sec == -1)
                    sec = 59;
                if (sec == 59) {
                    min--;
                }

                time.setText("Time: " + min + ":" + sec);
            }

            public void onFinish() {
                moveToResult();
                countDownTimer.cancel();
            }
        }.start();

        radioGroup = findViewById(R.id.radiogroup);
        questionNumber = findViewById(R.id.questionNo);
        time = findViewById(R.id.timer);

        showQuestio();

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                check = findViewById(i);
                count++;
                questionNumber.setText("Question: " + count + "/20");

                if (check.getText().toString().equals(ans)) {
                    correctAns++;
                    if (count == 21)
                        moveToResult();
                    else {

                        showQuestio();
                        check.setChecked(false);
                    }
                } else {

                    Datamode datamode = new Datamode(data.get(randomNumber).dis, data.get(randomNumber).image);
                    db.saveWrongAns(datamode);


                    if (count == 21)
                        moveToResult();
                    else {
                        showQuestio();
                        check.setChecked(false);
                    }
                }
            }
        });


    }

    private void showQuestio() {

        data = db.getRandomData();

        img = findViewById(R.id.roadsign);
        RadioGroup radioGroup = findViewById(R.id.radiogroup);

        Random random = new Random();
        randomNumber = random.nextInt((3 - 0) + 1) + 0;

        int count = radioGroup.getChildCount();

        for (int i = 0; i < count; i++) {
            View view = radioGroup.getChildAt(i);

            if (view instanceof RadioButton) {
                RadioButton radioButton = (RadioButton) view;

                if (i == randomNumber) {
                    img.setImageBitmap(BitmapFactory.decodeByteArray(data.get(randomNumber).image, 0, data.get(randomNumber).image.length));
                    ans = data.get(randomNumber).dis;
                    radioButton.setText(ans);

                } else {
                    radioButton.setText(data.get(i).dis);
                }
            }
        }

    }

    private void moveToResult() {
        countDownTimer.cancel();
        Intent intent = new Intent(QuestionActivity.this, ResultActivity.class);
        intent.putExtra("marks", correctAns);
        startActivity(intent);
        finish();



    }

    @Override
    public void onBackPressed() {
        // Create an AlertDialog.Builder object
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Exit");
        builder.setIcon(R.drawable.baseline_exit_to_app_24);
        builder.setMessage("You have not completed your quiz, do you want to exit?");

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                countDownTimer.cancel();
                QuestionActivity.super.onBackPressed();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Dismiss the dialog and do nothing
                dialog.dismiss();
            }
        });

        // Create and show the dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

}
