package com.example.galgeleg_s185363;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button fortsat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forside); //

        fortsat = findViewById(R.id.forsat);
        fortsat.setText("Spil");

        fortsat.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Hovedmenu.class);
                startActivity(intent);
            }
        });

    }




    @Override
    public void onClick(View v) {
        if (v == fortsat) {
            Intent i = new Intent(MainActivity.this, Hovedmenu.class);
            MainActivity.this.startActivity(i);
        }

    }
}