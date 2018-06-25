package com.company.Model;

/**
 * Created by xavierromacastells on 4/8/17.
 */
public class Vi {

    private enum tipusVi {BLANC, NEGRE, ROSAT}
    private String nom;
    private float preu;
    private String bodegues;
    private int tipus;

    public String getNom () {
        return nom;
    }

    public void setNom (String nom) {
        this.nom = nom;
    }

    public float getPreu () {
        return preu;
    }

    public void setPreu (float preu) {
        this.preu = preu;
    }

    public String getBodegues () {
        return bodegues;
    }

    public void setBodegues (String bodegues) {
        this.bodegues = bodegues;
    }

    public int getTipus () {
        return tipus;
    }

    public void setTipus (int tipus) {
        this.tipus = tipus;
    }
}
