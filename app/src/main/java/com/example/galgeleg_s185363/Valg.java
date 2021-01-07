package com.example.galgeleg_s185363;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Valg extends AppCompatActivity implements View.OnClickListener {
    Button dr, drive, ownWord;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_valg);

        dr = findViewById(R.id.dr);
        drive = findViewById(R.id.drive);
        ownWord = findViewById(R.id.ownWord);
        editText = findViewById(R.id.editText2);

        dr.setOnClickListener(this);
        drive.setOnClickListener(this);
        ownWord.setOnClickListener(this);




    }

    @Override
    public void onClick(View v) {

        if(v == dr){
            Intent i = new Intent(this, Spillet_akt.class);
            i.putExtra("valg", 1);
            startActivity(i);
        }
        if(v == drive){
            Intent i = new Intent(this, Spillet_akt.class);
            i.putExtra("valg", 2);
            startActivity(i);
        }
        if(v == ownWord){
            String valgtord = editText.getText().toString();

            Intent i = new Intent(this, Spillet_akt.class);
            i.putExtra("valg", 3);
            i.putExtra("valgtord",valgtord);
            startActivity(i);
            finish();
        }


    }
}

//
//    Intent i = new Intent(this,Victory.class);
//            i.putExtra("point",point);

//            Intent i = new Intent(this, Spillet_akt.class);
//            i.putExtra("velkomst", "\n\nVelkommen til spillet Galgeleg\n");
//            startActivity(i);