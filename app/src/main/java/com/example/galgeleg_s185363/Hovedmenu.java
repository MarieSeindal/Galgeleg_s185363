package com.example.galgeleg_s185363;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Hovedmenu extends AppCompatActivity implements View.OnClickListener {

    Button spilKnap, indstillingKnap, lukKnap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.hovemenu);

        spilKnap = findViewById(R.id.spilKnap);
        spilKnap.setText("Spil");

        indstillingKnap = findViewById(R.id.indstillingKnap);
        indstillingKnap.setText("Indstillinger");

        lukKnap = findViewById(R.id.lukKnap);
        lukKnap.setText("Luk");

        spilKnap.setOnClickListener(this);
        indstillingKnap.setOnClickListener(this);
        lukKnap.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == spilKnap){

        } else if(v == indstillingKnap){

        } else if(v == lukKnap){

        }


    }
}
