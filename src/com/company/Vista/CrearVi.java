package com.company.Vista;

import com.company.Model.Vi;
import com.company.Vista.Custom.JNumberField;
import javafx.scene.chart.PieChart;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * Created by xavierromacastells on 4/8/17.
 */
public class CrearVi extends JPanel {

    private JTextField jtfNom;
    private JNumberField jnfPreu;
    private JTextField jtfBodegues;
    private JComboBox<String> jcbTipus;

    public CrearVi (String title) {
        this.setBorder(BorderFactory.createTitledBorder(new TitledBorder(title)));
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        jcbTipus = new JComboBox <>(new String[]{"Negre", "Blanc", "Rosat"});
        jtfBodegues = new JTextField();
        jtfBodegues.setPreferredSize(new Dimension(100, 30));
        jtfBodegues.setToolTipText("D.O");
        jnfPreu = new JNumberField("Preu");
        jtfNom = new JTextField();
        jtfNom.setPreferredSize(new Dimension(100, 30));
        jtfNom.setToolTipText("Nom del vi");

        gbc.gridy = 0;
        gbc.gridx = 0;
        add(new JLabel("Nom del vi:"), gbc);
        gbc.gridx = 1;
        add(new JLabel("D.O:"), gbc);

        gbc.gridy = 1;
        gbc.gridx = 0;
        add(jtfNom, gbc);

        gbc.gridx = 1;
        add(jtfBodegues, gbc);

        gbc.gridy = 2;
        gbc.gridx = 0;
        add(jnfPreu, gbc);

        gbc.gridx = 1;
        add(jcbTipus, gbc);

    }
    public void setData(Vi vi) {
        jcbTipus.setSelectedIndex(vi.getTipus());
        jtfNom.setText(vi.getNom());
        jtfBodegues.setText(vi.getBodegues());
        jnfPreu.setNumber(vi.getPreu());
    }

    public Vi getData() {

        Vi vi = new Vi();
        vi.setBodegues(jtfBodegues.getText());
        vi.setNom(jtfNom.getText());
        vi.setTipus(jcbTipus.getSelectedIndex());
        vi.setPreu(jnfPreu.getNumber());

        return vi;
    }

    public void clearData () {
        jtfNom.setText("");
        jtfBodegues.setText("");
        jnfPreu.setNumber((float) 0.0);
    }


}
