package com.example.tablayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    TextView heading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        heading = findViewById(R.id.heading);

        ArrayList<Datamode> arrContacts = new ArrayList<>();
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        SQLite db = new SQLite(this);

        int i = getIntent().getIntExtra("call",0);

        if (i==1){
            arrContacts = db.getdata(35,68);
            heading.setText("Mandatory Signs");

        }
        else if (i==2) {
            arrContacts = db.getdata(1,34);
            heading.setText("Warning Signs");


        }
        else {
            arrContacts = db.getdata(69,83);
            heading.setText("Informatory Signs");
        }




        RecyclerRoadSignAdepter adapter = new RecyclerRoadSignAdepter(this,arrContacts);
        recyclerView.setAdapter(adapter);
    }
}