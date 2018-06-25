package com.company.Vista.Custom;

import com.company.Controlador.Controlador;
import com.company.Model.Plat;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 * Created by xavierromacastells on 3/8/17.
 */
/* ListDemo.java requires no other files. */
public class JListPlats extends JPanel {
    private JList list;
    private DefaultListModel listModel;

    public JListPlats (Plat[] p) {
        super(new BorderLayout());
        listModel = new DefaultListModel();
        for (int i = 0; i < p.length; i++) {
            listModel.addElement(p[i].getNomCat());
        }

        //Create the list and put it in a scroll pane.
        list = new JList(listModel);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setSelectedIndex(0);
        list.setVisibleRowCount(5);
        JScrollPane listScrollPane = new JScrollPane(list);

        add(listScrollPane, BorderLayout.CENTER);
    }

    public void registreControlador(Controlador controlador) {
        list.addListSelectionListener(controlador);
    }

    public int getSelectedIndex () {
        return list.getSelectedIndex();
    }

    public void refreshData(Plat[] p) {
        listModel.clear();
        for (int i = 0; i < p.length; i++) {
            listModel.addElement(p[i].getNomCat());
        }
    }

    public void select (int selected) {
        list.setSelectedIndex(selected);
    }

}