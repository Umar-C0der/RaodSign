package com.example.tablayout;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


public class PreparationFragment extends Fragment {
    CardView mandatory, warning, information ;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
         View returned =inflater.inflate(R.layout.fragment_preparation, container, false);

         mandatory = returned.findViewById(R.id.mandatroyCard);
         warning = returned.findViewById(R.id.warningCard);
         information = returned.findViewById(R.id.informationCard);

        Intent intent = new Intent(getContext().getApplicationContext(),ListActivity.class);

         mandatory.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {


                 intent.putExtra("call",1);
                 startActivity(intent);
             }
         });

         warning.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 intent.putExtra("call",2);
                 startActivity(intent);
             }
         });

         information.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 intent.putExtra("call",3);
                 startActivity(intent);
             }
         });



         return  returned;
    }
}