package com.company.Vista.Custom;

import com.company.Controlador.Controlador;
import com.company.Model.Plat;
import com.company.Model.Vi;

import javax.swing.*;
import java.awt.*;

/**
 * Created by xavierromacastells on 3/8/17.
 */
/* ListDemo.java requires no other files. */
public class JListVi extends JPanel {
    private JList list;
    private DefaultListModel listModel;

    public JListVi (Vi[] vins) {
        super(new BorderLayout());
        listModel = new DefaultListModel();
        for (int i = 0; i < vins.length; i++) {
            listModel.addElement(vins[i].getNom());
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

    public void refreshData(Vi[] vins) {
        listModel.clear();
        for (int i = 0; i < vins.length; i++) {
            listModel.addElement(vins[i].getNom());
        }
    }

    public void select (int selected) {

        list.setSelectedIndex(selected);
    }

}