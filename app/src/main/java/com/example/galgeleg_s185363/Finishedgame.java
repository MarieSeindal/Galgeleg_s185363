package com.example.galgeleg_s185363;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Finishedgame extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView tabt;

        String vinder = getIntent().getStringExtra("vundet");
        if (vinder != null) {
            setContentView(R.layout.vundet);
        }

        String taber = getIntent().getStringExtra("tabt");
        if (taber != null) {
            setContentView(R.layout.tabt);
            tabt = findViewById(R.id.taberBesked);
            tabt.setText("");
            tabt.append(taber);
        }

    }
    @Override
    public void onClick(View v) {

    }
}
