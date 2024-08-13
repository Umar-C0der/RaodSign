package com.example.tablayout;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;


public class QuizFragment extends Fragment {

    CheckBox checkBox;
    Button startquiz;
    TextView error;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View returnd = inflater.inflate(R.layout.fragment_quiz, container, false);


        checkBox = returnd.findViewById(R.id.checkbox);
        startquiz = returnd.findViewById(R.id.startquiz);
        error = returnd.findViewById(R.id.error);

        startquiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkBox.isChecked()){
                    error.setVisibility(View.INVISIBLE);
                    Intent intent = new Intent(getContext().getApplicationContext(),QuestionActivity.class);
                    startActivity(intent);
                }
                else {
                    error.setVisibility(View.VISIBLE);
                    error.setText("Please accept the terms and conditions");
                }
            }
        });



        // Inflate the layout for this fragment
        return returnd;
    }
}