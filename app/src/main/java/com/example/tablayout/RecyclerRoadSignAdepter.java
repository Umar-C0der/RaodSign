package com.example.tablayout;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerRoadSignAdepter extends RecyclerView.Adapter<RecyclerRoadSignAdepter.ViewHolder>{

    Context context;
    ArrayList<Datamode> arrContacts;

    public RecyclerRoadSignAdepter(Context context, ArrayList<Datamode> arrContact) {
        this.context =context;
        this.arrContacts=arrContact;
    }

    @NonNull
    @Override
    public RecyclerRoadSignAdepter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v= inflater.inflate(R.layout.row, parent,false);
        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerRoadSignAdepter.ViewHolder holder, int position) {

        holder.discription.setText(arrContacts.get(position).dis);
        holder.img.setImageBitmap(BitmapFactory.decodeByteArray(arrContacts.get(position).image,0,arrContacts.get(position).image.length));
    }

    @Override
    public int getItemCount() {
        return arrContacts.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView discription;
        ImageView img;
        public ViewHolder(View itemView){
            super(itemView);
            discription= itemView.findViewById(R.id.discription);
            img = itemView.findViewById(R.id.sign);

        }

    }
}
