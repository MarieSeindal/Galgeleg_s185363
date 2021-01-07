package com.example.galgeleg_s185363;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Victory extends AppCompatActivity {

    TextView win;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_victory);

        win = findViewById(R.id.winner);


        Intent i = getIntent();
        int gaet = i.getIntExtra("gaet",0);
        win.setText("Du har vundet på "+gaet+" antal gæt :)");


//        win.append("Du har vundet :)");


    }
}