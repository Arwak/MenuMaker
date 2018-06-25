package com.company.Vista.Custom;

import com.company.Model.Plat;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by xavierromacastells on 24/7/17.
 */
public class MenuInflator extends JPanel{
    private ArrayList<Plat> plats;

    public MenuInflator () {
        plats = new ArrayList<>();

    }

    public void updateContent (ArrayList<Plat> plats) {
        this.plats = plats;
    }

    public void displayInfo () {

    }




}
