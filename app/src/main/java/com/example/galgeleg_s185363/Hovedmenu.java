package com.example.galgeleg_s185363;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Hovedmenu extends AppCompatActivity implements View.OnClickListener {

    Button spilKnap, indstillingKnap, lukKnap, highscoreKnap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.hovemenu);

        spilKnap = findViewById(R.id.spilKnap);
        spilKnap.setText("Spil");

        indstillingKnap = findViewById(R.id.indstillingKnap);
        indstillingKnap.setText("Indstillinger");

        highscoreKnap = findViewById(R.id.highscore);
        highscoreKnap.setText("Highscore");

        lukKnap = findViewById(R.id.lukKnap);
        lukKnap.setText("Luk");

        spilKnap.setOnClickListener(this);
        indstillingKnap.setOnClickListener(this);
        highscoreKnap.setOnClickListener(this);
        lukKnap.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == spilKnap){
            Intent i = new Intent(this, Spillet_akt.class);
            i.putExtra("velkomst", "\n\nVelkommen til spillet Galgeleg\n");
            startActivity(i);
        } else if(v == indstillingKnap){
            Intent i = new Intent(this, Indstillinger.class);
            startActivity(i);

        } else if(v == highscoreKnap){
            Intent i = new Intent(this, Highscore.class);
            startActivity(i);

        }
        else if(v == lukKnap){
            finish(); // https://stackoverflow.com/questions/6014028/closing-application-with-exit-button
            System.exit(0);
        }

    }
}