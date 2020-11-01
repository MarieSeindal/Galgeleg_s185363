package com.example.galgeleg_s185363;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Highscore extends AppCompatActivity {

    ListView highscores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.highscoreliste);

        highscores = findViewById(R.id.highscoreList);

        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("Busrute 7 gæt\n");
        arrayList.add("Busrute 6 gæt\n");
        arrayList.add("Busrute 5 gæt\n");
        arrayList.add("Busrute 4 gæt\n");
        arrayList.add("Busrute 3 gæt\n");
        arrayList.add("Busrute 2 gæt\n");
        arrayList.add("Busrute 1 gæt\n");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayList);
        highscores.setAdapter(adapter);

    }


}
