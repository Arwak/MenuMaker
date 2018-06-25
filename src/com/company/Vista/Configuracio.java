package com.company.Vista;

import com.company.Controlador.Controlador;
import com.company.Controlador.DataManager;
import com.company.Model.Plat;
import com.company.Model.Vi;
import com.company.Vista.Custom.JListPlats;
import com.company.Vista.Custom.JListVi;
import com.company.Vista.Custom.JNumberField;
import com.company.Vista.Exceptions.CampsBuitsException;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.text.NumberFormatter;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

/**
 * Created by xavierromacastells on 28/7/17.
 */
public class Configuracio extends JPanel {
    public static final String CARD_MENU = "Configuracio";
    public static final String CARD_MOD_CARCT = "Modificar Caracteristiques";
    public static final String CARD_MOD_PLATS = "Modificar Plats";
    public static final String CARD_ADD_PLATS = "Afegir Plats";
    public static final String CARD_ADD_VINS = "Afegir Vins";
    public static final String CARD_MOD_VINS = "Modificar Vins";

    public static final String BTN_CONFIG_ENRERE = "201";
    public static final String BTN_CONFIG_GUARDAR_NOU_PLAT = "202";
    public static final String BTN_CONFIG_CANCELAR_NOU_PLAT = "203";
    public static final String BTN_FILTRE = "204";
    public static final String BTN_GUARDAR_NOU_PREU = "205";
    public static final String BTN_CANCELAR_NOU_PREU = "206";
    public static final String BTN_CONFIG_ENRERE_MOD_PLAT = "207";
    public static final String BTN_CONFIG_ENRERE_MOD_PREU = "208";
    public static final String BTN_CONFIG_ENRERE_NOU_PLAT = "209";
    public static final String BTN_ADD_PLATS_CONFIG = "210";
    public static final String BTN_MOD_CARACT_CONFIG = "211";
    public static final String BTN_MOD_PLATS_CONFIG = "212";
    public static final String BTN_CANCELAR_BRAND_NEW = "213";
    public static final String BTN_GUARDAR_BRAND_NEW = "214";
    public static final String BTN_MOD_VINS = "215";
    public static final String BTN_ADD_VINS = "216";
    public static final String BTN_ATRAS_MOD_VINS = "217";
    public static final String BTN_ATRAS_ADD_VINS = "218";
    public static final String BTN_GUARDAR_NOU_VI = "219";
    public static final String BTN_GUARDAR_MOD_VINS = "220";
    public static final String BTN_CANCELAR_MOD_VINS = "221";
    public static final String BTN_ELIMINAR_PLAT = "222";
    public static final String BTN_BRAND_NEW_VI = "223";
    public static final String BTN_DELETE_VI = "224";


    private JListPlats jlPlats;

    private JComboBox<String> jcbFiltre;

    private ButtonGroup bgVisible;

    private JRadioButton jrbVisibleY, jrbVisibleN;

    private JButton jbGuardar;
    private JButton jbCancelar;

    private CrearPlat cp;

    private JNumberField jnfPreuMenuNoFest;
    private JNumberField jnfPreuMenuFest;

    private JNumberField jnfPreuMenuNoFestLleguer;
    private JNumberField jnfPreuMenuFestLleuger;

    private JNumberField jnfPreuMenuNoFestExpres;
    private JNumberField jnfPreuMenuFestExpres;

    private JNumberField jnfPreuMenuNoFestInfantil;
    private JNumberField jnfPreuMenuFestInfantil;


    private JButton jbGuardarPreu;
    private JButton jbCancelarPreu;

    private CrearPlat afegirPlats;

    private CardLayout clMain;
    private JPanel jpMainCardLayout;


    private JButton jbEliminarPlat;

    private JButton jbModificarPlats;
    private JButton jbModificarPreus;
    private JButton jbAfegirPlats;
    private JButton jbAfegirVins;
    private JButton jbModificarVins;

    private JListVi jListVi;
    private JButton jbBrandNewVi;
    private JButton jbDeleteVi;

    private JButton jbAtras;
    private JButton jbAtrasModPlat;
    private JButton jbAtrasModPreu;
    private JButton jbAtrasNouPlat;

    private CrearVi cvModVi;
    private CrearVi cvAddVi;

    private JButton jbNouVi;
    private JButton jbAtrasNouVi;
    private JButton jbAtrasModVi;
    private JButton jbGuardarCanvisVi;
    private JButton jbCancelarCanvisVi;

    public Configuracio (DataManager dataManager) {
        clMain = new CardLayout();
        jpMainCardLayout = new JPanel(clMain);

        jpMainCardLayout.add(buildConfigMenu(), CARD_MENU);
        jpMainCardLayout.add(buildModificarPlats(dataManager), CARD_MOD_PLATS);
        jpMainCardLayout.add(buildModificarCaracteristiques(dataManager),CARD_MOD_CARCT);
        //jpMainCardLayout.add(buildModificarVins(), CARD_MOD_VINS);
        jpMainCardLayout.add(buildAddVins(dataManager), CARD_ADD_VINS);

        JPanel jpAddDish = new JPanel(new BorderLayout());
        JPanel jpTop = new JPanel(new FlowLayout(FlowLayout.LEFT));
        jbAtrasNouPlat = new JButton("Enrere");
        jpTop.add(jbAtrasNouPlat);
        jpAddDish.add(jpTop, BorderLayout.NORTH);

        afegirPlats = new CrearPlat();
        jpAddDish.add(afegirPlats, BorderLayout.CENTER);

        jpMainCardLayout.add(jpAddDish, CARD_ADD_PLATS);

        setLayout(new BorderLayout());
        setBorder(BorderFactory.createTitledBorder(new TitledBorder("Configuració")));
        add(jpMainCardLayout, BorderLayout.CENTER);


    }

    private JPanel buildModificarVins () {
        JPanel jp = new JPanel(new BorderLayout());
        JPanel jpSouth = new JPanel();
        JPanel jpNorth = new JPanel(new FlowLayout(FlowLayout.LEFT));
        cvModVi = new CrearVi("Modificar vi");
        jp.add(cvModVi, BorderLayout.CENTER);

        jbAtrasModVi = new JButton("Enrere");
        jpNorth.add(jbAtrasModVi);

        jbGuardarCanvisVi = new JButton("Guardar");
        jbCancelarCanvisVi = new JButton("Cancelar");
        jpSouth.add(jbGuardarCanvisVi);
        jpSouth.add(jbCancelarCanvisVi);

        jp.add(jpNorth, BorderLayout.NORTH);
        jp.add(jpSouth, BorderLayout.SOUTH);
        return jp;
    }

    private JPanel buildAddVins (DataManager dm) {
        JPanel jp = new JPanel(new BorderLayout());
        JPanel jpSouth = new JPanel();
        JPanel jpNorth = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel jpWest = new JPanel(new BorderLayout());
        cvAddVi = new CrearVi("Nou vi");
        jp.add(cvAddVi, BorderLayout.CENTER);

        jbAtrasNouVi = new JButton("Enrere");
        jpNorth.add(jbAtrasNouVi);

        jbNouVi = new JButton("Guardar Nou");
        jpSouth.add(jbNouVi);

        jListVi = new JListVi(dm.getVins());

        jbDeleteVi = new JButton("Eliminar Vi");
        jpWest.add(jbDeleteVi, BorderLayout.SOUTH);
        jpWest.add(jListVi, BorderLayout.CENTER);

        jp.add(jpWest, BorderLayout.WEST);
        jp.add(jpNorth, BorderLayout.NORTH);
        jp.add(jpSouth, BorderLayout.SOUTH);

        return jp;
    }

    private JPanel buildConfigMenu() {
        JPanel jp = new JPanel(new BorderLayout());

        JPanel jpNorth = new JPanel(new FlowLayout(FlowLayout.LEFT));
        jbAtras = new JButton("Enrere");
        jpNorth.add(jbAtras);

        JPanel jpCenter = new JPanel();
        jbModificarPreus = new JButton("Modificar Preus");
        jbModificarPlats = new JButton("Modificar Plats");
        jbAfegirPlats = new JButton("Afegir Plats");
        jbModificarVins = new JButton("Modificar Vins");
        jbAfegirVins = new JButton("Afegir Vins");

        jpCenter.add(jbModificarPreus);
        jpCenter.add(jbModificarPlats);
        jpCenter.add(jbAfegirPlats);
        //jpCenter.add(jbModificarVins);
        jpCenter.add(jbAfegirVins);

        jp.add(jpNorth, BorderLayout.NORTH);
        jp.add(jpCenter, BorderLayout.CENTER);
        return jp;
    }

    private JPanel buildModificarCaracteristiques(DataManager dataManager) {
        JPanel jpPare = new JPanel(new BorderLayout());
        JPanel jpTop = new JPanel(new FlowLayout(FlowLayout.LEFT));
        jbAtrasModPreu = new JButton("Enrere");
        jpTop.add(jbAtrasModPreu);
        jpPare.add(jpTop, BorderLayout.NORTH);
        JPanel jpGeneral = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        jpGeneral.setBorder(BorderFactory.createTitledBorder(new TitledBorder("Modificar Característiques")));

        JPanel jpMenu = new JPanel();
        JPanel jpFest = new JPanel();
        jpFest.setLayout(new BoxLayout(jpFest, BoxLayout.Y_AXIS));
        jpFest.setPreferredSize(new Dimension(250, 400));
        jpFest.setBorder(BorderFactory.createTitledBorder(new TitledBorder("Menú Festiu")));
        jnfPreuMenuFest = new JNumberField("Menú");
        jnfPreuMenuFestLleuger = new JNumberField("Menú lleuger");
        jnfPreuMenuFestExpres = new JNumberField("Menú expres");
        jnfPreuMenuFestInfantil = new JNumberField("Menú infantil");

        jpFest.add(jnfPreuMenuFest);
        jpFest.add(jnfPreuMenuFestLleuger);
        jpFest.add(jnfPreuMenuFestExpres);
        jpFest.add(jnfPreuMenuFestInfantil);

        JPanel jpNoFest = new JPanel();
        jpNoFest.setPreferredSize(new Dimension(250, 400));
        jpNoFest.setBorder(BorderFactory.createTitledBorder(new TitledBorder("Menú No Festiu")));
        jpNoFest.setLayout(new BoxLayout(jpNoFest, BoxLayout.Y_AXIS));
        jnfPreuMenuNoFest = new JNumberField("Menú");
        jnfPreuMenuNoFestLleguer = new JNumberField("Menú lleguer");
        jnfPreuMenuNoFestExpres = new JNumberField("Menú expres");
        jnfPreuMenuNoFestInfantil = new JNumberField("Menú infantil");
        jpNoFest.add(jnfPreuMenuNoFest);
        jpNoFest.add(jnfPreuMenuNoFestLleguer);
        jpNoFest.add(jnfPreuMenuNoFestExpres);
        jpNoFest.add(jnfPreuMenuNoFestInfantil);
        posarPreuGuardat(dataManager);
        jpMenu.add(jpNoFest);
        jpMenu.add(jpFest);
        gbc.gridy = 1;
        gbc.gridx = 0;
        jpGeneral.add(jpMenu, gbc);


        jbGuardarPreu = new JButton("Guardar canvis");
        jbCancelarPreu = new JButton("Cancelar canvis");

        gbc.gridy = 3;
        gbc.gridx = 5;
        jpGeneral.add(jbCancelarPreu, gbc);
        gbc.gridx = 6;
        jpGeneral.add(jbGuardarPreu, gbc);
        jpPare.add(jpGeneral, BorderLayout.CENTER);

        return jpPare;
    }

    private JPanel buildModificarPlats(DataManager dataManager) {
        JPanel jpParent = new JPanel(new BorderLayout());
        JPanel jpGeneral = new JPanel(new BorderLayout());
        JPanel jp = new JPanel();
        JPanel jpTop = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel jpWest = new JPanel(new BorderLayout());
        jbAtrasModPlat = new JButton("Enrere");
        jbEliminarPlat = new JButton("Eliminar Plat");
        jpTop.add(jbAtrasModPlat);
        cp = new CrearPlat(buildControls());

        jp.setBorder(BorderFactory.createTitledBorder(new TitledBorder("Atributs del plat")));
        jpGeneral.setBorder(BorderFactory.createTitledBorder(new TitledBorder("Modificar Plats")));

        jpWest.add(buildPlatsList(dataManager), BorderLayout.CENTER);
        jpWest.add(jbEliminarPlat, BorderLayout.SOUTH);

        jpGeneral.add(jpWest, BorderLayout.WEST);
        jp.add(cp, BorderLayout.CENTER);
        jpGeneral.add(jp, BorderLayout.CENTER);
        jpParent.add(jpGeneral, BorderLayout.CENTER);
        jpParent.add(jpTop, BorderLayout.NORTH);
        return jpParent;
    }


    private JPanel buildPlatsList (DataManager dataManager) {
        JPanel jp = new JPanel(new BorderLayout());
        jlPlats = new JListPlats(dataManager.getPlats());
        jcbFiltre = new JComboBox<>(Plat.TIPUS);
        jp.add(jcbFiltre, BorderLayout.NORTH);
        jp.add(jlPlats, BorderLayout.CENTER);



        return jp;
    }


    private JPanel buildControls () {
        JPanel jp = new JPanel();
        jrbVisibleY = new JRadioButton("Si");
        jrbVisibleN = new JRadioButton("No");
        bgVisible = new ButtonGroup();
        bgVisible.add(jrbVisibleY);
        bgVisible.add(jrbVisibleN);
        jrbVisibleY.setSelected(true);

        jbCancelar = new JButton("Cancelar");
        jbGuardar = new JButton("Guardar");

        jp.add(new JLabel("Visible?"));
        jp.add(jrbVisibleY);
        jp.add(jrbVisibleN);
        jp.add(jbCancelar);
        jp.add(jbGuardar);

        return jp;
    }

    public void registreControladors(Controlador c) {
        jbAtras.setActionCommand(BTN_CONFIG_ENRERE);
        jbAtras.addActionListener(c);

        jbGuardar.setActionCommand(BTN_CONFIG_GUARDAR_NOU_PLAT);
        jbGuardar.addActionListener(c);

        jbCancelar.setActionCommand(BTN_CONFIG_CANCELAR_NOU_PLAT);
        jbCancelar.addActionListener(c);

        jcbFiltre.setActionCommand(BTN_FILTRE);
        jcbFiltre.addActionListener(c);

        jbGuardarPreu.setActionCommand(BTN_GUARDAR_NOU_PREU);
        jbGuardarPreu.addActionListener(c);

        jbCancelarPreu.setActionCommand(BTN_CANCELAR_NOU_PREU);
        jbCancelarPreu.addActionListener(c);

        jbAtrasModPlat.setActionCommand(BTN_CONFIG_ENRERE_MOD_PLAT);
        jbAtrasModPlat.addActionListener(c);

        jbAtrasModPreu.setActionCommand(BTN_CONFIG_ENRERE_MOD_PREU);
        jbAtrasModPreu.addActionListener(c);

        jbAtrasNouPlat.setActionCommand(BTN_CONFIG_ENRERE_NOU_PLAT);
        jbAtrasNouPlat.addActionListener(c);

        jbModificarPreus.setActionCommand(BTN_MOD_CARACT_CONFIG);
        jbModificarPreus.addActionListener(c);

        jbModificarPlats.setActionCommand(BTN_MOD_PLATS_CONFIG);
        jbModificarPlats.addActionListener(c);

        jbAfegirPlats.setActionCommand(BTN_ADD_PLATS_CONFIG);
        jbAfegirPlats.addActionListener(c);

        jbAfegirVins.setActionCommand(BTN_ADD_VINS);
        jbAfegirVins.addActionListener(c);

        jbModificarVins.setActionCommand(BTN_MOD_VINS);
        jbModificarVins.addActionListener(c);

        jbNouVi.setActionCommand(BTN_GUARDAR_NOU_VI);
        jbNouVi.addActionListener(c);

        jbAtrasNouVi.setActionCommand(BTN_ATRAS_ADD_VINS);
        jbAtrasNouVi.addActionListener(c);

        jbDeleteVi.setActionCommand(BTN_DELETE_VI);
        jbDeleteVi.addActionListener(c);

        //jbAtrasModVi.setActionCommand(BTN_ATRAS_MOD_VINS);
        //jbAtrasModVi.addActionListener(c);

        //jbGuardarCanvisVi.setActionCommand(BTN_GUARDAR_MOD_VINS);
        //jbGuardarCanvisVi.addActionListener(c);

        //jbCancelarCanvisVi.setActionCommand(BTN_CANCELAR_MOD_VINS);
        //jbCancelarCanvisVi.addActionListener(c);

        jbEliminarPlat.setActionCommand(BTN_ELIMINAR_PLAT);
        jbEliminarPlat.addActionListener(c);

        jlPlats.registreControlador(c);
        jListVi.registreControlador(c);
        afegirPlats.registreControladorsSecundari(c, BTN_GUARDAR_BRAND_NEW, BTN_CANCELAR_BRAND_NEW);

    }

    public void nextCard(String card) {
        clMain.show(jpMainCardLayout,card);
    }

    public int getSelectedIndex () {
        return jlPlats.getSelectedIndex();
    }

    public int getSelectedViIndex () {
        return jListVi.getSelectedIndex();
    }

    public void setData (Plat data) {
        cp.setData(data);
        if (data.isVisible()) {
            jrbVisibleY.setSelected(true);
            jrbVisibleN.setSelected(false);
        } else {
            jrbVisibleN.setSelected(true);
            jrbVisibleY.setSelected(false);
        }
    }

    public void posarPreuGuardat(DataManager dataManager){

        jnfPreuMenuFest.setNumber(dataManager.getPreuFestiu());
        jnfPreuMenuFestLleuger.setNumber(dataManager.getPreuFestiuLleuger());
        jnfPreuMenuFestExpres.setNumber(dataManager.getPreuFestiuExpress());
        jnfPreuMenuFestInfantil.setNumber(dataManager.getPreuFestiuInfantil());
        jnfPreuMenuNoFest.setNumber(dataManager.getPreuNoFestiu());
        jnfPreuMenuNoFestLleguer.setNumber(dataManager.getPreuNoFestiuLleuger());
        jnfPreuMenuNoFestExpres.setNumber(dataManager.getPreuNoFestiuExpress());
        jnfPreuMenuNoFestInfantil.setNumber(dataManager.getPreuNoFestiuInfantil());
    }

    public void guardarPreus (DataManager dataManager) {
        dataManager.setPreuFestiu(jnfPreuMenuFest.getNumber());
        dataManager.setPreuFestiuLleuger(jnfPreuMenuFestLleuger.getNumber());
        dataManager.setPreuFestiuExpress(jnfPreuMenuFestExpres.getNumber());
        dataManager.setPreuFestiuInfantil(jnfPreuMenuFestInfantil.getNumber());
        dataManager.setPreuNoFestiu(jnfPreuMenuNoFest.getNumber());
        dataManager.setPreuNoFestiuLleuger(jnfPreuMenuNoFestLleguer.getNumber());
        dataManager.setPreuNoFestiuExpress(jnfPreuMenuNoFestExpres.getNumber());
        dataManager.setPreuNoFestiuInfantil(jnfPreuMenuNoFestInfantil.getNumber());
    }

    public Plat getNouPlat () throws CampsBuitsException {
        Plat p = cp.collectInfo();
        if (jrbVisibleN.isSelected()) {
            p.setVisible(false);
        } else {
            p.setVisible(true);
        }
        return p;
    }

    public void refreshData(Plat [] p){
        jlPlats.refreshData(p);
    }

    public void setSelected (int selected) {
        jlPlats.select(selected);
    }


    public void refreshDataVi (Vi [] v){
        jListVi.refreshData(v);
    }

    public void setSelectedVi (int selected) {
        jListVi.select(selected);
    }

    public String getSelectedFiltre () {
        return (String) jcbFiltre.getSelectedItem();
    }

    public Plat getBrandNewPlat () throws CampsBuitsException {
        Plat p = afegirPlats.collectInfo();
        return p;
    }

    public void clearBrandNewInfo () {
        afegirPlats.setData(new Plat());
    }

    public Vi getNouVi () {
        return cvAddVi.getData();
    }

    public void clearViInfo () {
        cvAddVi.clearData();
    }
}
