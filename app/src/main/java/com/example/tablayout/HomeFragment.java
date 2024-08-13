package com.example.tablayout;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class HomeFragment extends Fragment {

    CardView cardView1,cardView2,cardView3, cardView4;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View returnd = inflater.inflate(R.layout.fragment_home, container, false);

        cardView1 =  returnd.findViewById(R.id.subCard1);
        cardView2 =  returnd.findViewById(R.id.subCard2);
        cardView3 =  returnd.findViewById(R.id.subCard3);
        cardView4 =  returnd.findViewById(R.id.subCard4);

        Intent intent = new Intent(getActivity().getApplicationContext(),WebViewActivity.class);

        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                intent.putExtra("url","https://dlims.punjab.gov.pk/verify/");
                getActivity().startActivity(intent);
            }
        });

        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                intent.putExtra("url","https://dlims.punjab.gov.pk/track/");
                getActivity().startActivity(intent);
            }
        });

        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("url","https://dlims.punjab.gov.pk/howtoapply/");
                getActivity().startActivity(intent);
            }
        });

        cardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newintent = new Intent(getContext().getApplicationContext(),HighwayRulesActivity.class);
                startActivity(newintent);
            }
        });

        return returnd;

    }

}
