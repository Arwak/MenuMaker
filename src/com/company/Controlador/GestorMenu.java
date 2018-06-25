package com.company.Controlador;

import com.company.Model.InfoPackage;
import com.company.Model.Plat;
import com.company.Model.Vi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by xavierromacastells on 2/8/17.
 */
public class GestorMenu {

    private ArrayList<Plat> primers;
    private ArrayList<Plat> segons;
    private ArrayList<Plat> postres;
    private ArrayList<Plat> suggeriments;
    private ArrayList<Vi> vins;
    private boolean festiu;
    private int numCopiesCat;
    private int numCopiesEsp;
    private int numCopiesEng;
    public InfoPackage infoPackage;

    public GestorMenu(InfoPackage infoPackage) {
        primers = new ArrayList <>();
        for (int i = 0; i < infoPackage.lastPrim.size(); i++) {
            primers.add(infoPackage.lastPrim.get(i));
        }
        segons = new ArrayList <>();
        for (int i = 0; i < infoPackage.lastSeg.size(); i++) {
            segons.add(infoPackage.lastSeg.get(i));
        }
        postres = new ArrayList <>();
        for (int i = 0; i < infoPackage.lastPos.size(); i++) {
            postres.add(infoPackage.lastPos.get(i));
        }
        suggeriments = new ArrayList <>();
        for (int i = 0; i < infoPackage.lastSugg.size(); i++) {
            suggeriments.add(infoPackage.lastSugg.get(i));
        }
        vins = new ArrayList <>();
        for (int i = 0; i < infoPackage.lastVins.size(); i++) {
            vins.add(infoPackage.lastVins.get(i));
        }
        this.infoPackage = infoPackage;
    }


    public ArrayList <Plat> getPrimers () {
        return primers;
    }

    public ArrayList <Plat> getSegons () {
        return segons;
    }

    public ArrayList <Plat> getPostres () {
        return postres;
    }

    public ArrayList <Plat> getSuggeriments () {
        return suggeriments;
    }

    public ArrayList <Vi> getVins () {
        return vins;
    }

    public void addPrimer(Plat plat) {
        primers.add(plat);
    }

    public void addSegon(Plat plat) {
        segons.add(plat);
    }

    public void addPostres(Plat plat) {
        postres.add(plat);
    }

    public void addSugg(Plat plat) {
        suggeriments.add(plat);
    }

    public void addVi(Vi vi) {
        vins.add(vi);
    }

    public void removePrimer(Plat plat) {
        for (int i = 0; i < primers.size(); i++) {
            if (primers.get(i).getNomCat().equals(plat.getNomCat()))
                primers.remove(i);
        }

    }

    public void removeSegon(Plat plat) {
        for (int i = 0; i < segons.size(); i++) {
            if (segons.get(i).getNomCat().equals(plat.getNomCat()))
                segons.remove(i);
        }
    }

    public void removePostre(Plat plat) {
        for (int i = 0; i < postres.size(); i++) {
            if (postres.get(i).getNomCat().equals(plat.getNomCat()))
                postres.remove(i);
        }
    }

    public void removeSugg(Plat plat) {
        for (int i = 0; i < suggeriments.size(); i++) {
            if (suggeriments.get(i).getNomCat().equals(plat.getNomCat()))
                suggeriments.remove(i);
        }

    }

    public void removeVi(Vi vi) {
        for (int i = 0; i < vins.size(); i++) {
            if (vins.get(i).getNom().equals(vi.getNom()))
                vins.remove(i);
        }
    }

    public boolean isFestiu () {
        return festiu;
    }

    public void setFestiu (boolean festiu) {
        this.festiu = festiu;
    }

    public int getNumCopiesCat () {
        return numCopiesCat;
    }

    public void setNumCopiesCat (int numCopiesCat) {
        this.numCopiesCat = numCopiesCat;
    }

    public int getNumCopiesEsp () {
        return numCopiesEsp;
    }

    public void setNumCopiesEsp (int numCopiesEsp) {
        this.numCopiesEsp = numCopiesEsp;
    }

    public int getNumCopiesEng () {
        return numCopiesEng;
    }

    public void setNumCopiesEng (int numCopiesEng) {
        this.numCopiesEng = numCopiesEng;
    }

    public void sort() {
        primers.sort(new Comparator <Plat>() {
            @Override
            public int compare (Plat o1,Plat o2) {
                return o2.getEtiqueta() - o1.getEtiqueta();
            }
        });
        segons.sort(new Comparator <Plat>() {
            @Override
            public int compare (Plat o1,Plat o2) {
                return o2.getEtiqueta() - o1.getEtiqueta();
            }
        });
        suggeriments.sort(new Comparator <Plat>() {
            @Override
            public int compare (Plat o1,Plat o2) {
                return o2.getEtiqueta() - o1.getEtiqueta();
            }
        });
        postres.sort(new Comparator <Plat>() {
            @Override
            public int compare (Plat o1,Plat o2) {
                return o2.getEtiqueta() - o1.getEtiqueta();
            }
        });
    }

    public void removeAllPlats () {
        primers.clear();
        segons.clear();
        postres.clear();
        suggeriments.clear();
        vins.clear();

    }

    public void saveSelection () {
        infoPackage.lastPrim = primers;
        infoPackage.lastSeg = segons;
        infoPackage.lastPos = postres;
        infoPackage.lastSugg = suggeriments;
        infoPackage.lastVins = vins;
    }

    public int checkNumbers () {
        if (primers.size() > 13)
            return 1;
        if (segons.size() > 13)
            return 2;
        if (postres.size() > 10)
            return 3;
        if (suggeriments.size() > 5)
            return 4;
        if (vins.size() > 5)
            return 5;
        return 0;
    }
}
