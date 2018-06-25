package com.company.Controlador;

import com.company.Model.GestioJson;
import com.company.Model.InfoPackage;
import com.company.Model.Plat;
import com.company.Model.Vi;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by xavierromacastells on 1/8/17.
 */
public class DataManager {

    private ArrayList<Plat> primers;
    private ArrayList<Plat> segons;
    private ArrayList<Plat> postres;
    private ArrayList<Plat> suggeriments;
    private ArrayList<Vi> vins;
    private InfoPackage infoPackage;

    public DataManager(){
        infoPackage = GestioJson.lecturaFitxer();
        primers = new ArrayList<>();
        segons = new ArrayList<>();
        postres = new ArrayList<>();
        suggeriments = new ArrayList<>();
        vins = new ArrayList <>();
        distribuirPlats();

    }

    public Plat[] getPlats() {
        return toArray(infoPackage.plats);
    }

    public Plat getPlatsAtIndex(int index) {
        return infoPackage.plats.get(index);
    }

    private Plat[] toArray(ArrayList<Plat> plats) {

        Plat[] platArr = new Plat[plats.size()];

        for (int i = 0; i < plats.size(); i++) {
            platArr[i] = plats.get(i);
        }

        return platArr;

    }

    public Plat[] getPrimersPlats() {
        return toArray(primers);
    }

    public Plat[] getSegonsPlats() {
        return toArray(segons);
    }

    public Plat[] getPostres() {
        return toArray(postres);
    }

    public Plat[] getSuggeriments() {
        return toArray(suggeriments);
    }

    public void addPrimerPlat(Plat plat) {
        System.out.println("primer plat afegit:" + plat.getNomCat());
        primers.add(plat);
        infoPackage.plats.add(plat);
    }

    public void addSegonPlat(Plat plat) {
        segons.add(plat);
        infoPackage.plats.add(plat);
    }

    public void addPostres(Plat plat) {
        postres.add(plat);
        infoPackage.plats.add(plat);
    }

    public void addSuggeriment(Plat plat) {
        System.out.println("primer plat afegit:" + plat.getNomCat());
        suggeriments.add(plat);
        infoPackage.plats.add(plat);
    }

    public void addPlat(Plat plat) {
        infoPackage.plats.add(plat);
    }

    public void guardarInformacio() {
        GestioJson.guardarFitxer(infoPackage);
        for (Plat plat: infoPackage.plats) {
            System.out.println(plat.getNomCat());
        }
    }


    public float getPreuNoFestiu () {
        return infoPackage.preuNoFestiu;
    }

    public void setPreuNoFestiu (float preuNoFestiu) {
        infoPackage.preuNoFestiu = preuNoFestiu;
    }

    public float getPreuNoFestiuLleuger () {
        return infoPackage.preuNoFestiuLleuger;
    }

    public void setPreuNoFestiuLleuger (float preuNoFestiuLleuger) {
        infoPackage.preuNoFestiuLleuger = preuNoFestiuLleuger;
    }

    public float getPreuNoFestiuExpress () {
        return infoPackage.preuNoFestiuExpress;
    }

    public void setPreuNoFestiuExpress (float preuNoFestiuExpress) {
        infoPackage.preuNoFestiuExpress = preuNoFestiuExpress;
    }

    public float getPreuNoFestiuInfantil () {
        return infoPackage.preuNoFestiuInfantil;
    }

    public void setPreuNoFestiuInfantil (float preuNoFestiuInfantil) {
        infoPackage.preuNoFestiuInfantil = preuNoFestiuInfantil;
    }

    public float getPreuFestiu () {
        return infoPackage.preuFestiu;
    }

    public void setPreuFestiu (float preuFestiu) {
        infoPackage.preuFestiu = preuFestiu;
    }

    public float getPreuFestiuLleuger () {
        return infoPackage.preuFestiuLleuger;
    }

    public void setPreuFestiuLleuger (float preuFestiuLleuger) {
        infoPackage.preuFestiuLleuger = preuFestiuLleuger;
    }

    public float getPreuFestiuExpress () {
        return infoPackage.preuFestiuExpress;
    }

    public void setPreuFestiuExpress (float preuFestiuExpress) {
        infoPackage.preuFestiuExpress = preuFestiuExpress;
    }

    public float getPreuFestiuInfantil () {
        return infoPackage.preuFestiuInfantil;
    }

    public void setPreuFestiuInfantil (float preuFestiuInfantil) {
        infoPackage.preuFestiuInfantil = preuFestiuInfantil;
    }

    public float getNumPlats1rNoFestiu () {
        return infoPackage.numPlats1rNoFestiu;
    }

    public void setNumPlats1rNoFestiu (float numPlats1rNoFestiu) {
        infoPackage.numPlats1rNoFestiu = numPlats1rNoFestiu;
    }

    public float getNumPlats2nNoFestiu () {
        return infoPackage.numPlats2nNoFestiu;
    }

    public void setNumPlats2nNoFestiu (float numPlats2nNoFestiu) {
        infoPackage.numPlats2nNoFestiu = numPlats2nNoFestiu;
    }

    public float getNumPlats3rNoFestiu () {
        return infoPackage.numPlats3rNoFestiu;
    }

    public void setNumPlats3rNoFestiu (float numPlats3rNoFestiu) {
        infoPackage.numPlats3rNoFestiu = numPlats3rNoFestiu;
    }

    public float getNumPlats1rFestiu () {
        return infoPackage.numPlats1rFestiu;
    }

    public void setNumPlats1rFestiu (float numPlats1rFestiu) {
        infoPackage.numPlats1rFestiu = numPlats1rFestiu;
    }

    public float getNumPlats2nFestiu () {
        return infoPackage.numPlats2nFestiu;
    }

    public void setNumPlats2nFestiu (float numPlats2nFestiu) {
        infoPackage.numPlats2nFestiu = numPlats2nFestiu;
    }

    public float getNumPlats3rFestiu () {
        return infoPackage.numPlats3rFestiu;
    }

    public void setNumPlats3rFestiu (float numPlats3rFestiu) {
        infoPackage.numPlats3rFestiu = numPlats3rFestiu;
    }


    public void modificarPlat (int selectedIndex,Plat nouPlat) {
        infoPackage.plats.set(selectedIndex, nouPlat);
        distribuirPlats();
    }

    public void deletePlat (int selectedIndex) {
        infoPackage.plats.remove(selectedIndex);
        distribuirPlats();
    }

    private void distribuirPlats() {
        primers.clear();
        suggeriments.clear();
        segons.clear();
        postres.clear();
        for (Plat plat: infoPackage.plats) {
            if (plat.isVisible()) {
                switch (plat.getTipus()) {
                    case Plat.PRIMER:
                        primers.add(plat);
                        break;
                    case Plat.SEGON:
                        segons.add(plat);
                        break;
                    case Plat.POSTRE:
                        postres.add(plat);
                        break;
                    case Plat.SUGGERIMENT:
                        suggeriments.add(plat);
                        break;
                }
            }
        }
        primers.sort(new Plat());
        segons.sort(new Plat());
        postres.sort(new Plat());
        suggeriments.sort(new Plat());
    }

    public Plat getPrimersPlatsAtIndex (int selectedIndex) {
        return primers.get(selectedIndex);
    }

    public Plat getSegonsPlatsAtIndex (int selectedIndex) {
        return segons.get(selectedIndex);
    }

    public Plat getPostresAtIndex (int selectedIndex) {
        return postres.get(selectedIndex);
    }

    public Plat getSuggerimentsAtIndex (int selectedIndex) {
        return suggeriments.get(selectedIndex);
    }

    public InfoPackage getInfoPackage () {
        return infoPackage;
    }

    public void setInfoPackage (InfoPackage infoPackage) {
        this.infoPackage = infoPackage;
    }

    public void guardarNouVi (Vi vi) {
        infoPackage.vins.add(vi);
    }

    public void eliminarViDiari (Vi vi) {
        infoPackage.lastVins.remove(vi);
    }

    public void afegirViDiari (Vi vi) {
        infoPackage.lastVins.add(vi);
    }

    public Vi[] getVins() {
        return toViArray(infoPackage.vins);
    }

    private Vi[] toViArray(ArrayList<Vi> vins) {

        Vi[] platArr = new Vi[vins.size()];

        for (int i = 0; i < vins.size(); i++) {
            platArr[i] = vins.get(i);
        }

        return platArr;

    }


    public void deleteVi (int selectedViIndex) {
        infoPackage.vins.remove(selectedViIndex);

    }
}
