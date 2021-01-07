package com.example.galgeleg_s185363;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashSet;
import java.util.Set;

public class Victory extends AppCompatActivity implements View.OnClickListener {

    TextView win;
    Button seHighscore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_victory);

        win = findViewById(R.id.winner);
        seHighscore = findViewById(R.id.seHighscore);


        Intent i = getIntent();
        int gaet = i.getIntExtra("gaet",0);
        int point = i.getIntExtra("point",0);
        String ord = i.getStringExtra("ord");


        win.setText("Du har vundet på "+gaet+" antal gæt og fået "+ point + " antal point :)");

        //Write to shared pref


//        String point2 = ""+point; // konverterer score fra int til string

        SharedPreferences sharedpreferences = getSharedPreferences("pref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();

//        Set<String> set = new HashSet<String>();
//        set.add(point2);
//        editor.putStringSet("key", set);

        String key = "Score";//+ord;
        editor.putInt(key,point);
        editor.putString("word", ord);
        editor.putInt("gaet",gaet);
        editor.commit();

        seHighscore.setOnClickListener(this);


//        win.append("Du har vundet :)");


    }

    public void onClick(View v) {

        if(v == seHighscore){
            Intent i = new Intent(this, Highscore.class);
            startActivity(i);
            finish();
        }

    }

}