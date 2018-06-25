package com.company.Vista.Custom;

import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.text.NumberFormat;

/**
 * Created by xavierromacastells on 3/8/17.
 */
public class JNumberField extends JPanel {
    private JFormattedTextField jtfNumEnter;
    private JFormattedTextField jtfNumDec;

    public JNumberField (String title) {
        JPanel jpGeneral = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        NumberFormat format = NumberFormat.getInstance();
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setValueClass(Integer.class);
        formatter.setMinimum(0);
        formatter.setMaximum(Integer.MAX_VALUE);
        formatter.setAllowsInvalid(false);
        jtfNumEnter = new JFormattedTextField(formatter);
        jtfNumDec = new JFormattedTextField(formatter);
        jtfNumEnter.setPreferredSize(new Dimension(40,20));
        jtfNumDec.setPreferredSize(new Dimension(40,20));


        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.gridwidth = 6;
        jpGeneral.add(new JLabel(title), gbc);
        gbc.gridy = 1;
        gbc.gridx = 1;
        gbc.gridwidth = 1;
        jpGeneral.add(jtfNumEnter, gbc);
        gbc.gridx = 2;
        jpGeneral.add(new JLabel(","), gbc);
        gbc.gridx = 3;
        jpGeneral.add(jtfNumDec, gbc);
        gbc.gridx = 4;
        jpGeneral.add(new JLabel("€"), gbc);

        this.add(jpGeneral);
    }

    public float getNumber () {
        float fAux = Float.parseFloat(jtfNumEnter.getText() + "." + jtfNumDec.getText());
        return fAux;
    }

    public void setNumber (float numero) {
        int integer = (int)numero;
        int decimal = (int)(100 * numero - 100 * integer);
        jtfNumEnter.setText(integer + "");
        jtfNumDec.setText(decimal + "");
    }


}
