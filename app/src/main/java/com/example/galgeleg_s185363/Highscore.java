package com.example.galgeleg_s185363;

import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.*;
import java.util.ArrayList;

public class Highscore extends AppCompatActivity {

    ListView highscores;

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

        highscores = findViewById(R.id.highscoreList);

        ArrayList<String> arrayList = new ArrayList<>();

        //writeToFile("crap", );


        arrayList.add("Busrute 7 gæt\n");
        arrayList.add("Busrute 6 gæt\n");
        arrayList.add("Busrute 5 gæt\n");
        arrayList.add("Busrute 4 gæt\n");
        arrayList.add("Busrute 3 gæt\n");
        arrayList.add("Busrute 2 gæt\n");
        arrayList.add("Busrute 1 gæt\n");
        // todo få buffered reader og writer til at virke

        for (int i=0; i > arrayList.size(); i++){
            //writeToFile(arrayList.get(i), this);
        }

        //https://www.youtube.com/watch?v=G5efj1kLuKk&ab_channel=AbhishekSingh
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayList);
//        highscores.setAdapter(adapter);

    }


}
