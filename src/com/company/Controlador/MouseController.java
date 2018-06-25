package com.company.Controlador;

import com.company.Model.Plat;
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
public class MouseController implements MouseListener, ChangeListener {
    private MainView view;
    private int pane;
    private GestorMenu gm;

    public MouseController(MainView view, GestorMenu gm) {
        this.view = view;
        this.gm = gm;
        pane = 0;
    }
    @Override
    public void mouseClicked (MouseEvent e) {
        //view.getLlista()
        PaquetPlat paquetPlat = view.platClicat((JList <HRCheckBoxList.CheckboxListItem>)e.getSource(), e.getPoint(), pane);

        switch (pane) {

            case 0:
                if ( paquetPlat.isSeleccionat() ) {
                    view.setDades(paquetPlat.getPlat().getNomCat(),MainView.PRIMERS_PLAT);
                    gm.addPrimer(paquetPlat.getPlat());
                } else {
                    view.deleteDades(paquetPlat.getPlat().getNomCat(),MainView.PRIMERS_PLAT);
                    gm.removePrimer(paquetPlat.getPlat());
                }
                break;

            case 1:
                if ( paquetPlat.isSeleccionat() ) {
                    view.setDades(paquetPlat.getPlat().getNomCat(),MainView.SEGONS_PLAT);
                    gm.addSegon(paquetPlat.getPlat());
                } else {
                    view.deleteDades(paquetPlat.getPlat().getNomCat(),MainView.SEGONS_PLAT);
                    gm.removeSegon(paquetPlat.getPlat());
                }
                break;

            case 2:
                if ( paquetPlat.isSeleccionat() ) {
                    view.setDades(paquetPlat.getPlat().getNomCat(),MainView.POSTRES);
                    gm.addPostres(paquetPlat.getPlat());
                } else {
                    view.deleteDades(paquetPlat.getPlat().getNomCat(),MainView.POSTRES);
                    gm.removePostre(paquetPlat.getPlat());
                }
                break;

            case 3:
                if ( paquetPlat.isSeleccionat() ) {
                    view.setDades(paquetPlat.getPlat().getNomCat(),MainView.SUGGERIMENTS);
                    gm.addSugg(paquetPlat.getPlat());
                } else {
                    view.deleteDades(paquetPlat.getPlat().getNomCat(),MainView.SUGGERIMENTS);
                    gm.removeSugg(paquetPlat.getPlat());
                }

                break;
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
