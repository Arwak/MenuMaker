package com.company.Model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

/**
 * Created by xavierromacastells on 24/7/17.
 */
public class Plat implements Comparator{
    public final static String[] ETIQUETES = {"Altres", "Marisc", "Peix",  "Carn", "Pasta", "Amanida"};
    public final static String[] TIPUS = {"Tots" ,"Primer", "Segon", "Postre", "Suggeriment"};
    public final static String TOTS_STR = "Tots";
    public final static String PRIMER_STR = "Primer";
    public final static String SEGON_STR = "Segon";
    public final static String POSTRE_STR = "Postre";
    public final static String SUGG_STR = "Suggeriment";
    public final static int PEIX = 4;
    public final static int CARN = 5;
    public final static int AMANIDA = 6;
    public final static int PRIMER = 0;
    public final static int SEGON = 1;
    public final static int POSTRE = 2;
    public final static int SUGGERIMENT = 3;
    private String nomCat;
    private String nomEsp;
    private String nomEng;
    private HashMap<String, Boolean> alergens;
    private int tipus;
    private int etiqueta;
    private float preu;
    private float cost;
    private float suplement;
    private int comptador;
    private boolean visible;


    public Plat() {
        alergens = new HashMap<>();
        for (int i = 0; i < Alergens.ALERGIES.length; i++) {
            alergens.put(Alergens.ALERGIES[i], false);
        }
        visible = true;

    }
    public Plat(int tipus) {
        alergens = new HashMap<>();
        for (int i = 0; i < Alergens.ALERGIES.length; i++) {
            alergens.put(Alergens.ALERGIES[i], false);
        }
        this.tipus = tipus;
        visible = true;
    }

    public String getNomCat() {
        if (suplement > 0) {
            return nomCat + " (+" + String.format("%2.2f", suplement) + " €)";
        } else {
            return nomCat;
        }
    }

    public void setNomCat(String nomCat) {
        this.nomCat = nomCat;
    }

    public String getNomEsp() {
        if (suplement > 0) {
            return nomEsp + " (" + suplement + ")";
        } else {
            return nomEsp;
        }
    }

    public void setNomEsp(String nomEsp) {
        this.nomEsp = nomEsp;
    }

    public String getNomEng() {
        if (suplement > 0) {
            return nomEng + " (" + suplement + ")";
        } else {
            return nomEng;
        }
    }

    public void setNomEng(String nomEng) {
        this.nomEng = nomEng;
    }

    public void setAlergens(String conte) {
        this.alergens.put(conte, true);
    }

    public ArrayList<String> getAlergens() {
        ArrayList<String> alergies = new ArrayList<>();
        for (int i = 0; i < Alergens.ALERGIES.length; i++) {
            if (alergens.get(Alergens.ALERGIES[i])) {
                alergies.add(Alergens.ALERGIES[i]);
            }
        }
        return alergies;
    }

    public int getTipus() {
        return tipus;
    }

    public void setTipus(int tipus) {
        this.tipus = tipus;
    }

    public float getPreu() {
        return preu;
    }

    public void setPreu(float preu) {
        this.preu = preu;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public float getSuplement() {
        return suplement;
    }

    public void setSuplement(float suplement) {
        this.suplement = suplement;
    }

    public int getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        for (int i = 0; i < ETIQUETES.length; i++){
            if (etiqueta.equals(ETIQUETES[i])) {
                this.etiqueta = i;
                break;
            }
        }
    }

    public void incComptador() {
        comptador++;
    }

    @Override
    public int compare (Object o1,Object o2) {
        Plat p1 = (Plat) o1;
        Plat p2 = (Plat) o2;

        if (p1.comptador < p2.comptador) {
            return -1;
        } else if (p1.comptador == p2.comptador) {
            return 0;
        } else {
            return 1;
        }
    }

    public boolean isVisible () {
        return visible;
    }

    @Override
    public String toString() {

        return nomCat;
    }

    public void setVisible (boolean visible) {
        this.visible = visible;
    }



}
