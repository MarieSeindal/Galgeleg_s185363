package com.example.galgeleg_s185363;

import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.*;
import java.util.ArrayList;

public class Highscore extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    //https://www.youtube.com/watch?v=17NbUcEts9c&ab_channel=CodinginFlow

    private void writeToFile(String data,Context context) {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("Highscore.txt", Context.MODE_PRIVATE));
            outputStreamWriter.write(data);
            outputStreamWriter.close();
        }
        catch (IOException e) {
            //Log.e("Exception", "File write failed: " + e.toString());
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.highscoreliste);


        ArrayList<HigscoreItem> highscoreList = new ArrayList<>();

        highscoreList.add(new HigscoreItem("Busrute 7 gæt\n"));
        highscoreList.add(new HigscoreItem("Busrute 7 gæt\n"));
        highscoreList.add(new HigscoreItem("Busrute 7 gæt\n"));
        highscoreList.add(new HigscoreItem("Busrute 7 gæt\n"));
        highscoreList.add(new HigscoreItem("Busrute 7 gæt\n"));
        highscoreList.add(new HigscoreItem("Busrute 7 gæt\n"));
        highscoreList.add(new HigscoreItem("Busrute 7 gæt\n"));
        highscoreList.add(new HigscoreItem("Busrute 7 gæt\n"));
        highscoreList.add(new HigscoreItem("Busrute 7 gæt\n"));
        highscoreList.add(new HigscoreItem("Busrute 7 gæt\n"));
        highscoreList.add(new HigscoreItem("Busrute 7 gæt\n"));
        highscoreList.add(new HigscoreItem("Busrute 7 gæt\n"));
        highscoreList.add(new HigscoreItem("Busrute 7 gæt\n"));
        highscoreList.add(new HigscoreItem("Busrute 7 gæt\n"));
        highscoreList.add(new HigscoreItem("Busrute 7 gæt\n"));

        mRecyclerView = findViewById(R.id.recyc);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new HighscoreAdapter(highscoreList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);



        //https://www.youtube.com/watch?v=G5efj1kLuKk&ab_channel=AbhishekSingh
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayList);
//        highscores.setAdapter(adapter);

    }


}
