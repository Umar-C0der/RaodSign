package com.example.tablayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {

    TextView  status, marks, percentage,  resultComment;

    int temp_marks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        temp_marks = getIntent().getIntExtra("marks",0);

        wrongAns();

        status = findViewById(R.id.status);
        marks = findViewById(R.id.marks);
        percentage = findViewById(R.id.percentage);
        resultComment = findViewById(R.id.resultComment);


        int temp_marks = getIntent().getIntExtra("marks",0);

        marks.setText(String.valueOf(temp_marks));

        if (temp_marks>11){
            status.setText("Pass");
            resultComment.setText("Good Job you are outstanding");
        }
        else {
            status.setText("Fail");
            resultComment.setText("You have to prepare quiz and try again");
            resultComment.setTextColor(Color.parseColor("#FFF44336"));
        }

        // Percentage calculation
        float per;
        per = (temp_marks*100)/20;

        percentage.setText(String.valueOf(per)+"%");
    }
    private void wrongAns(){
        SQLite db = new SQLite(ResultActivity.this);
        ArrayList<Datamode> data =new ArrayList<>();
        data = db.getWrongAnsData();
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecyclerRoadSignAdepter adapter = new RecyclerRoadSignAdepter(this,data);
        recyclerView.setAdapter(adapter);
        db.deleteWrongAns();

    }
}