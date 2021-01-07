package com.example.galgeleg_s185363;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.*;
import java.util.ArrayList;
import java.util.Set;

public class Highscore extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    //https://www.youtube.com/watch?v=17NbUcEts9c&ab_channel=CodinginFlow



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.highscoreliste);

        SharedPreferences sharedpreferences = getSharedPreferences("pref", Context.MODE_PRIVATE);
//        Set<String> set = sharedpreferences.getStringSet("key", null);
        int highScore = sharedpreferences.getInt("point",0);
        System.out.println(highScore);

        String word = sharedpreferences.getString("word",null);
        System.out.println(word);



        ArrayList<HigscoreItem> highscoreList = new ArrayList<>();

        highscoreList.add(new HigscoreItem("Ord: " +word+ ", Score: " +highScore+ "\n"));
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
