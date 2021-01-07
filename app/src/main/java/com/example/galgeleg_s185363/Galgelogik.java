package com.example.galgeleg_s185363;

import android.os.Handler;
import android.os.Looper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import com.example.galgeleg_s185363.HentOrd.*;

public class Galgelogik {
    /** AHT afprøvning er muligeOrd synlig på pakkeniveau */
    ArrayList<String> muligeOrd = new ArrayList<String>();
    private String ordet;
    private ArrayList<String> brugteBogstaver = new ArrayList<String>();
    private String synligtOrd;
    private int antalForkerteBogstaver;
    private boolean sidsteBogstavVarKorrekt;
    private boolean spilletErVundet;
    private boolean spilletErTabt;

    public Galgelogik() throws Exception {
        //todo her sættes valget om metoden til indhentning af ord. Ansvaret for dette ligger hos Hentord-klassen.

        Executor backgroundThread = Executors.newSingleThreadExecutor();
        Handler uiThread = new Handler();


        // 1= manuel liste, 2 = regne ark, 3 = Dr.

        int choice = 1;
        String difficulty = "";

        switch (choice) {
            case 1:
                HentOrd.hentOrdFraManuelListe(muligeOrd);
                break;
            case 2:
                HentOrd.hentOrdFraRegneark(difficulty,muligeOrd);
                break;
            case 3:
                backgroundThread.execute(() -> {
                    try {
                        HentOrd.hentOrdFraDr(muligeOrd);
                        System.out.println("Hej fra backgroundthread");
                        uiThread.post(() -> {
                            ArrayList<String> listen2 = muligeOrd;
                        });
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
                break;
        }

        startNytSpil();
    }

    public ArrayList<String> getBrugteBogstaver() {
        return brugteBogstaver;
    }
    public String getSynligtOrd() {
        return synligtOrd;
    }
    public String getOrdet() {
        return ordet;
    }
    public int getAntalForkerteBogstaver() {
        return antalForkerteBogstaver;
    }

    public boolean erSidsteBogstavKorrekt() {
        return sidsteBogstavVarKorrekt;
    }
    public boolean erSpilletVundet() {
        return spilletErVundet;
    }
    public boolean erSpilletTabt() {
        return spilletErTabt;
    }
    public boolean erSpilletSlut() {
        return spilletErTabt || spilletErVundet;
    }

    public void startNytSpil() {
        brugteBogstaver.clear();
        antalForkerteBogstaver = 0;
        spilletErVundet = false;
        spilletErTabt = false;
        if (muligeOrd.isEmpty()) throw new IllegalStateException("Listen over mulige ord er tom!");
        ordet = muligeOrd.get(new Random().nextInt(muligeOrd.size()));
        System.out.println("Nyt spil - det skjulte ord er: "+ordet);
        opdaterSynligtOrd();
    }

    private void opdaterSynligtOrd() {
        synligtOrd = "";
        spilletErVundet = true;
        for (int n = 0; n < ordet.length(); n++) {
            String bogstav = ordet.substring(n, n + 1);
            if (brugteBogstaver.contains(bogstav)) {
                synligtOrd = synligtOrd + bogstav;
            } else {
                synligtOrd = synligtOrd + "*";
                spilletErVundet = false;
            }
        }
    }

    public void gætBogstav(String bogstav) {
        if (bogstav.length() != 1) return;
        System.out.println("Der gættes på bogstavet: " + bogstav);
        if (brugteBogstaver.contains(bogstav)) return;
        if (spilletErVundet || spilletErTabt) return;

        brugteBogstaver.add(bogstav);

        if (ordet.contains(bogstav)) {
            sidsteBogstavVarKorrekt = true;
            System.out.println("Bogstavet var korrekt: " + bogstav);
        } else {
            // Vi gættede på et bogstav der ikke var i ordet.
            sidsteBogstavVarKorrekt = false;
            System.out.println("Bogstavet var IKKE korrekt: " + bogstav);
            antalForkerteBogstaver = antalForkerteBogstaver + 1;
            if (antalForkerteBogstaver > 6) { //todo sæt til 6
                spilletErTabt = true;
            }
        }
        opdaterSynligtOrd();
    }

    public void logStatus() {
        System.out.println("---------- ");
        System.out.println("- ordet (skult) = " + ordet);
        System.out.println("- synligtOrd = " + synligtOrd);
        System.out.println("- forkerteBogstaver = " + antalForkerteBogstaver);
        System.out.println("- brugeBogstaver = " + brugteBogstaver);
        if (spilletErTabt) System.out.println("- SPILLET ER TABT");
        if (spilletErVundet) System.out.println("- SPILLET ER VUNDET");
        System.out.println("---------- ");
    }



    //TODO behøver ikke være her
    public static void main(String[] args) throws Exception {
        //new Galgelogik().hentOrdFraRegneark("2");
    }
}
