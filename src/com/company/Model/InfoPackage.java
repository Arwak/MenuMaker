package com.company.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by xavierromacastells on 3/8/17.
 */
public class InfoPackage {

    public float preuNoFestiu;
    public float preuNoFestiuLleuger;
    public float preuNoFestiuExpress;
    public float preuNoFestiuInfantil;

    public float preuFestiu;
    public float preuFestiuLleuger;
    public float preuFestiuExpress;
    public float preuFestiuInfantil;

    public float numPlats1rNoFestiu;
    public float numPlats2nNoFestiu;
    public float numPlats3rNoFestiu;

    public float numPlats1rFestiu;
    public float numPlats2nFestiu;
    public float numPlats3rFestiu;

    public ArrayList<Plat> plats;
    public ArrayList<Plat> lastSugg;
    public ArrayList<Plat> lastPrim;
    public ArrayList<Plat> lastSeg;
    public ArrayList<Plat> lastPos;

    public ArrayList<Vi> vins;
    public ArrayList<Vi> lastVins;

    public InfoPackage() {

        plats = new ArrayList <>();
        lastSugg = new ArrayList <>();
        lastPrim = new ArrayList <>();
        lastSeg = new ArrayList <>();
        lastPos = new ArrayList <>();
        vins = new ArrayList <>();
        lastVins = new ArrayList <>();
    }
}
