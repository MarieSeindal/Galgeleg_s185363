package com.example.galgeleg_s185363;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

//https://www.youtube.com/watch?v=17NbUcEts9c&ab_channel=CodinginFlow

public class HighscoreAdapter extends RecyclerView.Adapter<HighscoreAdapter.HighscoreViewHolder> {

    private ArrayList<HigscoreItem> mHigscoreList;

    public static class HighscoreViewHolder extends RecyclerView.ViewHolder{

        public TextView mTextView;

        public HighscoreViewHolder(@NonNull View itemView) {

            super(itemView);

            mTextView=itemView.findViewById(R.id.higscoreview);
        }
    }

    public HighscoreAdapter(ArrayList<HigscoreItem> highscoreList){
        mHigscoreList = highscoreList;

    }

    @NonNull
    @Override
    public HighscoreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.highscore_item, parent, false);
        HighscoreViewHolder hvh = new HighscoreViewHolder(v);
        return hvh;
    }

    @Override
    public void onBindViewHolder(@NonNull HighscoreViewHolder holder, int position) {
        HigscoreItem currentsItem = mHigscoreList.get(position);

        holder.mTextView.setText(currentsItem.getmText());

    }

    @Override
    public int getItemCount() {
        return mHigscoreList.size();
    }


}
