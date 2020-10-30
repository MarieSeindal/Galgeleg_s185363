package com.example.galgeleg_s185363;

import java.util.ArrayList;
import java.util.Random;

public class Spillet {

    // initialiser nyttige variabler
    ArrayList<String> muligeOrd = new ArrayList<String>();
    private String ordet;
    private ArrayList<String> brugteBogstaver = new ArrayList<String>();
    private String synligtOrd;
    private int antalForkerteBogstaver;
    private boolean sidsteBogstavVarKorrekt;
    private boolean spilletErVundet;
    private boolean spilletErTabt;

    // Her ses spillets flow


    //Hent ord

    //Start spil
    public void main(String[] args) {
        startNytSpil();

    }


    //

    //

    //

    public void startNytSpil() {
        brugteBogstaver.clear();
        antalForkerteBogstaver = 0;
        spilletErVundet = false;
        spilletErTabt = false;
        if (muligeOrd.isEmpty()) throw new IllegalStateException("Listen over mulige ord er tom!");
        ordet = muligeOrd.get(new Random().nextInt(muligeOrd.size()));
        System.out.println("Nyt spil - det skjulte ord er: "+ordet);
        //opdaterSynligtOrd(); //todo
    }



}
