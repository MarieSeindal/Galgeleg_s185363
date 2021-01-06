package com.example.galgeleg_s185363;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Lost extends AppCompatActivity implements View.OnClickListener {
    TextView taber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.tabt);

         taber = findViewById(R.id.taberBesked);

//        String vinder = getIntent().getStringExtra("vundet");
//        if (vinder != null) {
//            setContentView(R.layout.vundet);
//        }

//        Intent i = getIntent();
//        String gaet = i.getStringExtra("gaet");
//        taber.setText("Du har tabt \n Du skulle have ordet \""+gaet+"\"");
        taber.setText("Du har tabt :(");

    }
    @Override
    public void onClick(View v) {

    }
}
