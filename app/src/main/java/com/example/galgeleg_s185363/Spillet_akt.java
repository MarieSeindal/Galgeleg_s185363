package com.example.galgeleg_s185363;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Spillet_akt extends AppCompatActivity implements View.OnClickListener {

    Galgelogik logik = new Galgelogik();
    private TextView info;
    private Button spilKnap;
    private EditText et;
    private Button spilIgen;

    public Spillet_akt() throws Exception {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.spillet);

        // Programmatisk layout
        TableLayout tl = new TableLayout(this);

        info = new TextView(this);
        info.setText("Velkommen til mit fantastiske spil." +
                "\nDu skal gætte dette ord: "+logik.getSynligtOrd() +
                "\nSkriv et bogstav herunder og tryk 'Spil'.\n");
/*
  Hovedmenu_akt startede denne aktivitet med
      Intent i = new Intent(this, Spillet_akt.class);
      i.putExtra("velkomst", "\n\nHalløj fra Hovedmenu_akt!\n");
      startActivity(i);
  derfor vil velkomst få værdien 'Halløj fra Hovedmenu_akt!' nedenfor
 */

        String velkomst = getIntent().getStringExtra("velkomst");
        if (velkomst!=null) info.append(velkomst);
        tl.addView(info);

        et = new EditText(this);
        et.setHint("Skriv et bogstav her.");
        tl.addView(et);

        spilKnap = new Button(this);
        spilKnap.setText("Gæt");
        spilKnap.setCompoundDrawablesWithIntrinsicBounds(android.R.drawable.ic_media_play, 0, 0, 0);
        tl.addView(spilKnap);

        spilKnap.setOnClickListener(this);



        setContentView(tl);
        logik.logStatus(); // Så vi kan se det rigtige ord i loggen
    }

    @Override
    public void onClick(View v) {
        String bogstav = et.getText().toString();
        if (bogstav.length() != 1) {
            et.setError("Skriv præcis ét bogstav");
            return;
        }
        logik.gætBogstav(bogstav);
        et.setText("");
        et.setError(null);
        spilKnap.animate().rotationBy(3*360).setInterpolator(new DecelerateInterpolator());
//      spilKnap.animate().translationYBy(30).setInterpolator(new BounceInterpolator());
        opdaterSkærm();
    }


    private void opdaterSkærm() {
        info.setText("Gæt ordet: " + logik.getSynligtOrd());
        info.append("\n\nDu har " + logik.getAntalForkerteBogstaver() + " forkerte:" + logik.getBrugteBogstaver());

        if (logik.erSpilletVundet()) {

            int antalForsoeg =0;
            for (String bogstav: logik.getBrugteBogstaver()) {
                antalForsoeg++;
            }

            String vinderScore = logik.getOrdet()+" "+antalForsoeg+" gæt\n";

            info.append("\nDu har vundet! \n ordet var:"+logik.getOrdet()+"\nDu brugte "+antalForsoeg+" forsøg.\n");
            //Intent i = new Intent(this,Finishedgame.class);
            //i.putExtra("vundet", "\n\nTillykke du har vundet!\n");
            //startActivity(i);

            try { // todo få buffered reader og writer til at virker med higscore listen
                File file = new File("directory/fileName.txt");
                if (!file.exists()) {
                    file.createNewFile();
                }
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("directory/fileName.txt"));
                bufferedWriter.write(vinderScore);
                bufferedWriter.flush();
                bufferedWriter.close();
            } catch (IOException e) {
                System.out.println("Error writing to higscore");
                e.printStackTrace();
            }

        }
        if (logik.erSpilletTabt()) {
//            Intent i = new Intent(Spillet_akt.this,Finishedgame.class);
//            i.putExtra("tabt", "\n\nDu har tabt, ordet var : \n"+ logik.getOrdet());

            int antalForsoeg =0;
            for (String bogstav: logik.getBrugteBogstaver()) {
                antalForsoeg++;
            }
            info.setText("Du har tabt, ordet var : " + logik.getOrdet()+"\nDu brugte "+antalForsoeg+" forsøg.\n");

//            setContentView(R.layout.tabt);
//            Spillet_akt.this.startActivity(i);
        }
    }
}
