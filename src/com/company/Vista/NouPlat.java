package com.company.Vista;

import com.company.Controlador.Controlador;

import javax.swing.*;
import javax.xml.soap.Node;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by xavierromacastells on 1/8/17.
 */
public class NouPlat extends JFrame {
    private CrearPlat cp;
    private Controlador c;
    public NouPlat() {
        cp = new CrearPlat();
        this.add(cp);
        setMinimumSize(new Dimension(650, 750));

        this.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                if(askToClose()) {
                    dispose();
                    c.enableOtherView();
                }
            }
        });
    }

    public CrearPlat getController() {
        return cp;
    }

    public boolean askToClose() {
        return MostradorDialegs.showOptionDialog("Si", "No", "Estas segur que vols tancar sense guardar el plat?", "Creació d'un nou plat");

    }

    public void sayOK() {
        MostradorDialegs.showMessage("Plat Guardat amb éxit", "Missatge");
        dispose();
    }

    public void registreControladors (Controlador c){
        this.c = c;
        cp.registreControladors(c);
    }
}
