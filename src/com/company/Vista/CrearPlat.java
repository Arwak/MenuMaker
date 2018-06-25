package com.company.Vista;

import com.company.Controlador.Controlador;
import com.company.Model.Alergens;
import com.company.Model.Plat;
import com.company.Vista.Custom.HRCheckBoxStringList;
import com.company.Vista.Exceptions.AlergensException;
import com.company.Vista.Exceptions.CampsBuitsException;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.text.NumberFormat;
import java.util.ArrayList;

/**
 * Created by xavierromacastells on 24/7/17.
 */
public class CrearPlat extends JPanel {
    public static final String BTN_GUARDAR = "100";
    public static final String BTN_CANCELAR = "101";

    private int tipus;
    private JTextField nomCat;
    private JTextField nomEsp;
    private JTextField nomEng;
    private JRadioButton jrbPrimer;
    private JRadioButton jrbSegon;
    private JRadioButton jrbTercer;
    private JRadioButton jrbSuggeriment;
    private ButtonGroup bgTipus;
    private HRCheckBoxStringList hrcblAlList;
    private JComboBox<String> jcbEtiqueta;

    private JButton jbGuardar;
    private JButton jbCancelar;


    private JFormattedTextField jtfPreuEscandall;
    private JFormattedTextField jtfPreuPlat;
    private JFormattedTextField jtfPreuEscandallDec;
    private JFormattedTextField jtfPreuPlatDec;
    private JFormattedTextField jtfPreuSuplement;
    private JFormattedTextField jtfPreuSuplementDec;


    public CrearPlat() {
        tipus = -1;
        JPanel jp = new JPanel(new BorderLayout());

        jp.add(buildTop(), BorderLayout.NORTH);
        jp.add(buildCenter(null), BorderLayout.CENTER);

        this.add(jp);
    }
    public CrearPlat(JPanel jpSouth) {
        tipus = -1;
        JPanel jp = new JPanel(new BorderLayout());

        jp.add(buildTop(), BorderLayout.NORTH);
        jp.add(buildCenter(jpSouth), BorderLayout.CENTER);

        this.add(jp);
    }

    public void setTipus(int tipus) {
        this.tipus = tipus;
        switch (tipus) {

            case Plat.PRIMER:
                jrbPrimer.setSelected(true);
                jrbSegon.setEnabled(false);
                jrbTercer.setEnabled(false);
                jrbSuggeriment.setEnabled(false);
                break;

            case Plat.SEGON:
                jrbSegon.setSelected(true);
                jrbPrimer.setEnabled(false);
                jrbTercer.setEnabled(false);
                jrbSuggeriment.setEnabled(false);
                break;

            case Plat.POSTRE:
                jrbTercer.setSelected(true);
                jrbPrimer.setEnabled(false);
                jrbSegon.setEnabled(false);
                jrbSuggeriment.setEnabled(false);
                break;

            case Plat.SUGGERIMENT:
                jrbSuggeriment.setSelected(true);
                jrbPrimer.setEnabled(false);
                jrbSegon.setEnabled(false);
                jrbTercer.setEnabled(false);
                break;

            default:
                break;
        }
    }

    public CrearPlat(int tipus) {
        this.tipus = tipus;
        JPanel jp = new JPanel(new BorderLayout());

        jp.add(buildTop(), BorderLayout.NORTH);
        jp.add(buildCenter(null), BorderLayout.CENTER);

        switch (tipus) {

            case Plat.PRIMER:
                jrbPrimer.setSelected(true);
                jrbSegon.setEnabled(false);
                jrbTercer.setEnabled(false);
                jrbSuggeriment.setEnabled(false);
                break;

            case Plat.SEGON:
                jrbSegon.setSelected(true);
                jrbPrimer.setEnabled(false);
                jrbTercer.setEnabled(false);
                jrbSuggeriment.setEnabled(false);
                break;

            case Plat.POSTRE:
                jrbTercer.setSelected(true);
                jrbPrimer.setEnabled(false);
                jrbSegon.setEnabled(false);
                jrbSuggeriment.setEnabled(false);
                break;

            case Plat.SUGGERIMENT:
                jrbSuggeriment.setSelected(true);
                jrbPrimer.setEnabled(false);
                jrbSegon.setEnabled(false);
                jrbTercer.setEnabled(false);
                break;

            default:
                break;
        }

        this.add(jp);
    }

    public JPanel buildTop () {
        JPanel jp = new JPanel(new GridLayout(2,2));
        jp.setBorder(BorderFactory.createTitledBorder(new TitledBorder("Nom del plat")));
        jp.add(new JLabel("Català"));
        jp.add(new JLabel("Castellà"));
        jp.add(new JLabel("Anglès"));
        nomCat = new JTextField();
        nomEsp = new JTextField();
        nomEng = new JTextField();
        jp.add(nomCat);
        jp.add(nomEsp);
        jp.add(nomEng);
        return jp;
    }

    public JPanel buildCenter (JPanel jpSouthern) {
        boolean southDefinit;
        JPanel jp = new JPanel(new BorderLayout());
        JPanel jpNorth = new JPanel(new GridLayout(0,4));
        JPanel jpWest = new JPanel(new BorderLayout());
        JPanel jpCenter = new JPanel(new BorderLayout());
        if (jpSouthern == null) {
            southDefinit = false;
        } else {
            southDefinit = true;
        }
        JPanel jpSouth = new JPanel(new FlowLayout(FlowLayout.RIGHT));


        jpNorth.setBorder(BorderFactory.createTitledBorder(new TitledBorder("Tipus")));
        jrbPrimer = new JRadioButton("Primer");
        jrbSegon = new JRadioButton("Segon");
        jrbTercer = new JRadioButton("Postre");
        jrbSuggeriment = new JRadioButton("Suggeriment");
        bgTipus =  new ButtonGroup();
        bgTipus.add(jrbPrimer);
        bgTipus.add(jrbSegon);
        bgTipus.add(jrbTercer);
        bgTipus.add(jrbSuggeriment);
        jpNorth.add(jrbPrimer);
        jpNorth.add(jrbSegon);
        jpNorth.add(jrbTercer);
        jpNorth.add(jrbSuggeriment);

        jpWest.setBorder(BorderFactory.createTitledBorder(new TitledBorder("Alergens")));
        hrcblAlList =  new HRCheckBoxStringList(Alergens.ALERGIES, this, 100);
        jpWest.add(hrcblAlList, BorderLayout.CENTER);

        jcbEtiqueta = new JComboBox<>(Plat.ETIQUETES);

        JPanel jpEtiqueta = new JPanel();
        jpEtiqueta.setBorder(BorderFactory.createTitledBorder(new TitledBorder("Etiqueta")));
        jpEtiqueta.add(jcbEtiqueta);

        JPanel jpCenterPreuEtiq = new JPanel( new BorderLayout());

        jpCenterPreuEtiq.add(jpEtiqueta, BorderLayout.NORTH);
        JPanel jpAux = new JPanel(new GridBagLayout());
        jpAux.setBorder(BorderFactory.createTitledBorder(new TitledBorder("Preus")));
        GridBagConstraints gbc = new GridBagConstraints();

        NumberFormat format = NumberFormat.getInstance();
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setValueClass(Integer.class);
        formatter.setMinimum(0);
        formatter.setMaximum(Integer.MAX_VALUE);
        formatter.setAllowsInvalid(false);
        jtfPreuEscandall = new JFormattedTextField(formatter);
        jtfPreuEscandallDec = new JFormattedTextField(formatter);
        jtfPreuEscandall.setPreferredSize(new Dimension(40,20));
        jtfPreuEscandallDec.setPreferredSize(new Dimension(40,20));
        jtfPreuPlat = new JFormattedTextField(formatter);
        jtfPreuPlatDec = new JFormattedTextField(formatter);
        jtfPreuPlatDec.setPreferredSize(new Dimension(40,20));
        jtfPreuPlat.setPreferredSize(new Dimension(40,20));
        jtfPreuSuplement = new JFormattedTextField(formatter);
        jtfPreuSuplementDec = new JFormattedTextField(formatter);
        jtfPreuSuplementDec.setPreferredSize(new Dimension(40,20));
        jtfPreuSuplement.setPreferredSize(new Dimension(40,20));

        jtfPreuPlat.setText("00");
        jtfPreuPlatDec.setText("00");
        jtfPreuEscandall.setText("00");
        jtfPreuEscandallDec.setText("00");
        jtfPreuSuplement.setText("00");
        jtfPreuSuplementDec.setText("00");

        gbc.gridx = 0;
        gbc.gridy = 0;
        jpAux.add(new JLabel("Cost escandall"), gbc);
        gbc.gridy = 1;
        JPanel jpMoneda = new JPanel(new FlowLayout(FlowLayout.CENTER));
        jpMoneda.add(jtfPreuEscandall);
        jpMoneda.add(new JLabel("."));
        jpMoneda.add(jtfPreuEscandallDec);
        jpMoneda.add(new JLabel("€"));
        jpAux.add(jpMoneda, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        jpAux.add(new JLabel("Preu plat venta IVA inclòs"), gbc);
        gbc.gridy = 4;
        JPanel jpPreu = new JPanel(new FlowLayout(FlowLayout.CENTER));
        jpPreu.add(jtfPreuPlat);
        jpPreu.add(new JLabel("."));
        jpPreu.add(jtfPreuPlatDec);
        jpPreu.add(new JLabel("€"));
        jpAux.add(jpPreu, gbc);

        gbc.gridy = 5;
        jpAux.add(new JPanel(), gbc);
        gbc.gridx = 0;
        gbc.gridy = 6;
        JLabel jlSupl = new JLabel("Preu suplement");
        jlSupl.setFont(new Font("Arial",Font.BOLD,15));
        jpAux.add(jlSupl, gbc);
        gbc.gridy = 8;
        jpAux.add(new JLabel("(Si no té suplement deixar a 0)"), gbc);
        gbc.gridy = 7;
        JPanel jpSupl = new JPanel(new FlowLayout(FlowLayout.CENTER));
        jpSupl.add(jtfPreuSuplement);
        jpSupl.add(new JLabel("."));
        jpSupl.add(jtfPreuSuplementDec);
        jpSupl.add(new JLabel("€"));
        jpAux.add(jpSupl, gbc);

        jpCenterPreuEtiq.add(jpAux, BorderLayout.CENTER);
        jpCenter.add(jpWest, BorderLayout.WEST);
        jpCenter.add(jpCenterPreuEtiq, BorderLayout.CENTER);



        jbGuardar = new JButton("Guardar");
        jbCancelar = new JButton("Cancelar");

        jpSouth.add(jbCancelar);
        jpSouth.add(jbGuardar);
        jp.add(jpNorth, BorderLayout.NORTH);
        jp.add(jpCenter, BorderLayout.CENTER);
        if (southDefinit) {
            jp.add(jpSouthern,BorderLayout.SOUTH);
        } else {
            jp.add(jpSouth,BorderLayout.SOUTH);
        }
        return jp;
    }

    public Plat collectInfo() throws CampsBuitsException, NumberFormatException {
        Plat plat = new Plat();
        if (jrbPrimer.isSelected())
            tipus = Plat.PRIMER;
        else if (jrbSegon.isSelected())
            tipus = Plat.SEGON;
        else if (jrbTercer.isSelected())
            tipus = Plat.POSTRE;
        else if (jrbSuggeriment.isSelected())
            tipus = Plat.SUGGERIMENT;
        else
            throw new CampsBuitsException("Marqui el tipus de plat (Primer, segon...)");
        String aux = nomCat.getText();
        if (aux.isEmpty()) {
            throw new CampsBuitsException("El nom del plat en català és buit");
        }
        plat.setNomCat(aux);
        aux = nomEsp.getText();
        if (aux.isEmpty()) {
            throw new CampsBuitsException("El nom del plat en castellà és buit");
        }
        plat.setNomEsp(aux);
        aux = nomEng.getText();
        if (aux.isEmpty()) {
            throw new CampsBuitsException("El nom del plat en anglès és buit");
        }
        plat.setNomEng(aux);

        ArrayList<String> selection = hrcblAlList.getSelectedItems();

        for (String s: selection) {
            plat.setAlergens(s);
        }
        plat.setTipus(tipus);

        plat.setEtiqueta((String)jcbEtiqueta.getSelectedItem());
        float auxi = Float.parseFloat(jtfPreuEscandall.getText());
        auxi+= Float.parseFloat(jtfPreuEscandallDec.getText()) /100;
        plat.setCost(auxi);
        auxi = Float.parseFloat(jtfPreuPlat.getText());
        auxi+= Float.parseFloat(jtfPreuPlatDec.getText()) /100;
        plat.setPreu(auxi);
        auxi = Float.parseFloat(jtfPreuSuplement.getText());
        auxi+= Float.parseFloat(jtfPreuSuplementDec.getText()) /100;
        plat.setSuplement(auxi);

        return plat;
    }

    public void registreControladors (Controlador c){
        jbGuardar.addActionListener(c);
        jbGuardar.setActionCommand(BTN_GUARDAR);
        jbCancelar.addActionListener(c);
        jbCancelar.setActionCommand(BTN_CANCELAR);
    }

    public void registreControladorsSecundari (Controlador c, String btn_guardar, String btn_cancelar){
        jbGuardar.addActionListener(c);
        jbGuardar.setActionCommand(btn_guardar);
        jbCancelar.addActionListener(c);
        jbCancelar.setActionCommand(btn_cancelar);
    }



    public void setData (Plat data) {
        nomCat.setText(data.getNomCat());
        nomEsp.setText(data.getNomEsp());
        nomEng.setText(data.getNomEng());
        switch (data.getTipus()) {
            case Plat.PRIMER:
                jrbPrimer.setSelected(true);
                jrbSegon.setSelected(false);
                jrbTercer.setSelected(false);
                jrbSuggeriment.setSelected(false);
                break;

            case Plat.SEGON:
                jrbPrimer.setSelected(false);
                jrbSegon.setSelected(true);
                jrbTercer.setSelected(false);
                jrbSuggeriment.setSelected(false);
                break;

            case Plat.POSTRE:
                jrbPrimer.setSelected(false);
                jrbTercer.setSelected(true);
                jrbSegon.setSelected(false);
                jrbSuggeriment.setSelected(false);
                break;

            case Plat.SUGGERIMENT:
                jrbPrimer.setSelected(false);
                jrbSuggeriment.setSelected(true);
                jrbSegon.setSelected(false);
                jrbTercer.setSelected(false);
                break;
        }
        jcbEtiqueta.setSelectedItem(Plat.ETIQUETES[data.getEtiqueta()]);
        float aux = data.getCost();
        int integer = (int)aux;
        int decimal = (int)(100 * aux - 100 * integer);
        jtfPreuEscandall.setText(integer + "");
        jtfPreuEscandallDec.setText(decimal + "");

        aux = data.getPreu();
        integer = (int)aux;
        decimal = (int)(100 * aux - 100 * integer);
        jtfPreuPlat.setText(integer + "");
        jtfPreuPlatDec.setText(decimal + "");

        aux = data.getSuplement();
        integer = (int)aux;
        decimal = (int)(100 * aux - 100 * integer);
        jtfPreuSuplement.setText(integer + "");
        jtfPreuSuplementDec.setText(decimal + "");

        hrcblAlList.setSelectedItems(Alergens.ALERGIES, data.getAlergens());

    }
}
