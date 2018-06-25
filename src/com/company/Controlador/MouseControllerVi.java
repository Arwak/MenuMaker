package com.company.Controlador;

import com.company.Vista.Custom.HRCheckBoxList;
import com.company.Vista.Custom.HRCheckBoxListVins;
import com.company.Vista.MainView;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by xavierromacastells on 4/8/17.
 */
public class MouseControllerVi implements MouseListener, ChangeListener {
    private MainView view;
    private int pane;
    private GestorMenu gm;

    public MouseControllerVi (MainView view,GestorMenu gm) {
        this.view = view;
        this.gm = gm;
        pane = 0;
    }
    @Override
    public void mouseClicked (MouseEvent e) {
        //view.getLlista()
        PaquetVi paquetVi = view.viClicat((JList <HRCheckBoxListVins.CheckboxListVi>)e.getSource(), e.getPoint());

        if ( paquetVi.isSeleccionat() ) {
            view.setDades(paquetVi.getVi().getNom(),MainView.VINS);
            gm.addVi(paquetVi.getVi());
        } else {
            view.deleteDades(paquetVi.getVi().getNom(),MainView.VINS);
            gm.removeVi(paquetVi.getVi());
        }


    }

    @Override
    public void mousePressed (MouseEvent e) {

    }

    @Override
    public void mouseReleased (MouseEvent e) {

    }

    @Override
    public void mouseEntered (MouseEvent e) {

    }

    @Override
    public void mouseExited (MouseEvent e) {

    }

    @Override
    public void stateChanged (ChangeEvent e) {
        pane = view.getSelectedPane();
        System.out.println(pane);
    }
}
