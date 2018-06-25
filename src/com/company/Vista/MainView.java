package com.company.Vista;

import com.company.Controlador.*;
import com.company.Model.Plat;
import com.company.Model.Vi;
import com.company.Vista.Custom.HRCheckBoxList;
import com.company.Vista.Custom.HRCheckBoxListVins;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Stack;


/**
 * Created by xavierromacastells on 15/6/17.
 */
public class MainView extends JFrame {
    public static final String BTN_MENU_FEST = "0";
    public static final String BTN_MENU_NO_FEST = "1";
    public static final String BTN_ENRERE_SELECCIO_MENU = "2";
    public static final String BTN_CONFIG_SELECCIO_MENU = "3";
    public static final String BTN_ENRERE_BUILDER = "4";
    public static final String BTN_SEG_BUILDER = "5";

    public static final String BTN_ACCEPT_PRIMER = "8";
    public static final String BTN_NOU_PLAT_PRIMER = "9";
    public static final String BTN_ACCEPT_SEGON = "10";
    public static final String BTN_NOU_PLAT_SEGON = "11";
    public static final String BTN_ACCEPT_POSTRE = "12";
    public static final String BTN_NOU_PLAT_POSTRE = "13";
    public static final String BTN_ACCEPT_SUGG = "14";
    public static final String BTN_NOU_PLAT_SUGG = "15";
    public static final String BTN_ADD_VI = "16";

    public static final int PRIMERS_PLAT = 1;
    public static final int SEGONS_PLAT = 2;
    public static final int POSTRES = 3;
    public static final int SUGGERIMENTS = 4;
    public static final int VINS = 5;
    public static final String TITLE_TRIAR_MENU = "Escull quin tipus de menú vols crear:";
    public static final String MENU_FESTIU = "Menú festiu";
    public static final String MENU_NO_FESTIU = "Menú no festiu";
    public static final String CARD_LOGIN = "HRoma Menu Maker - Entrada";
    public static final String CARD_TYPE = "HRoma Menu Maker - Selecció";
    public static final String CARD_BUILDER = "HRoma Menu Maker - Crear menú";
    public static final String CARD_CONFIG = "HRoma Menu Maker - Configuració";

    private JPanel jpMainCardLayout;
    private CardLayout clMain;

    private JTextField jtfUsuari;
    private JPasswordField jpfUsuari;
    private JButton jbCanviSuper;
    private JButton jbUsuari;
    private JButton jbUsuariEnrere;

    //Elements SelectMenuType
    private JButton jbMenuNoFest;
    private JButton jbMenuFest;
    private JButton jbMenuEnrere;
    private JButton jbConfig;

    //Elements menu builder
    private JButton jbSeg;
    private JButton jbAtras;

    //ELEMENTS BUILDER

    private JTabbedPane tabbedPane;

    //Element build vi
    private JTextField jtfNomVi;
    private JFormattedTextField jtfPreuViEnter;
    private JFormattedTextField jtfPreuViDec;
    private JButton jbAfegirVi;

    //Elements build MainDish
    private JTextField jtfBuscadorPrimer;
    private HRCheckBoxList llistaPrimer;
    private JTextField jtfBuscadorSegon;
    private HRCheckBoxList llistaSegon;
    private JTextField jtfBuscadorPostre;
    private HRCheckBoxList llistaPostre;
    private JTextField jtfBuscadorSugg;
    private HRCheckBoxList llistaSugg;
    private JTextField jtfBuscadorVi;
    private HRCheckBoxListVins llistaVi;
    private JButton jbBuscarPrimer;
    private JButton jbAfegirPlatPrimer;
    private JButton jbBuscarSegon;
    private JButton jbAfegirPlatSegon;
    private JButton jbBuscarPostre;
    private JButton jbAfegirPlatPostre;
    private JButton jbBuscarSugg;
    private JButton jbAfegirPlatSugg;
    private JButton jbBuscarVi;
    private JButton jbAcceptarVi;
    private JButton jbAfegirPlatVi;

    //Elements menuInflator
    private DefaultTableModel dtmPrimers;
    private DefaultTableModel dtmSegons;
    private DefaultTableModel dtmPostres;
    private DefaultTableModel dtmSuggeriments;
    private DefaultTableModel dtmVins;
    private JTable jtPrimers;
    private JTable jtSegons;
    private JTable jtPostres;
    private JTable jtSuggeriments;
    private JTable jtVins;

    private String current_card;
    private Configuracio configuracio;

    public MainView (DataManager dataManager) {
        clMain = new CardLayout();
        jpMainCardLayout = new JPanel(clMain);

        clMain = new CardLayout();
        jpMainCardLayout = new JPanel(clMain);
        configuracio = new Configuracio(dataManager);
        jpMainCardLayout.add(buildSelectMenuType(),CARD_TYPE);
        jpMainCardLayout.add(buildMenuBuilder(dataManager),CARD_BUILDER);
        //jpMainCardLayout.add(buildSuperLogin(), CARD_LOGIN);
        jpMainCardLayout.add(configuracio, CARD_CONFIG);

        this.getContentPane().add(jpMainCardLayout,BorderLayout.CENTER);

        setVisible(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing (WindowEvent e) {
                dataManager.guardarInformacio();
                System.exit(0);
            }
        });
    }


    public JPanel buildSuperLogin () {
        GridBagConstraints gbc = new GridBagConstraints();
        JPanel jp = new JPanel(new BorderLayout());
        JPanel jpCenter = new JPanel(new GridBagLayout());
        JPanel jpSouth = new JPanel(new BorderLayout());
        jtfUsuari = new JTextField();
        jbUsuariEnrere = new JButton("Enrere");
        jbUsuari = new JButton("Acceptar");
        jbUsuari.setFont(new Font("Arial",Font.PLAIN,20));
        jpfUsuari = new JPasswordField();
        jtfUsuari.setPreferredSize(new Dimension(100,20));
        jpfUsuari.setPreferredSize(new Dimension(100,20));
        jbUsuari.setPreferredSize(new Dimension(100,50));
        gbc.gridy = 10;
        gbc.gridx = 10;
        jpCenter.add(jtfUsuari,gbc);
        gbc.gridy = 14;
        gbc.gridx = 10;
        jpCenter.add(jpfUsuari,gbc);

        gbc.gridy = 10;
        gbc.gridx = 9;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JLabel jlaux = new JLabel("Usuari: ");
        jlaux.setFont(new Font("Arial",Font.PLAIN,20));
        jpCenter.add(jlaux,gbc);

        gbc.gridy = 14;
        gbc.gridx = 9;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JLabel jlaux1 = new JLabel("Clau de pas: ");
        jlaux1.setFont(new Font("Arial",Font.PLAIN,20));
        jpCenter.add(jlaux1,gbc);

        gbc.gridy = 18;
        gbc.gridx = 10;
        jpCenter.add(jbUsuari,gbc);
        jp.add(jpCenter,BorderLayout.CENTER);

        return jp;
    }

    public JPanel buildSelectMenuType () {
        GridBagConstraints gbc = new GridBagConstraints();
        JPanel jp = new JPanel(new BorderLayout());
        JPanel jpCenter = new JPanel(new GridBagLayout());
        jbMenuFest = new JButton(MENU_FESTIU);
        jbMenuNoFest = new JButton(MENU_NO_FESTIU);
        jbMenuEnrere = new JButton("Enrere");
        jbConfig = new JButton("Configuració");
        jbMenuNoFest.setPreferredSize(new Dimension(250,100));
        jbMenuFest.setPreferredSize(new Dimension(250,100));
        JLabel jlaux1 = new JLabel(TITLE_TRIAR_MENU);
        jlaux1.setFont(new Font("Arial",Font.PLAIN,20));
        gbc.gridy = 6;
        gbc.gridx = 10;
        jpCenter.add(jlaux1,gbc);
        gbc.gridy = 10;
        gbc.gridx = 10;
        jpCenter.add(jbMenuNoFest,gbc);
        gbc.gridy = 14;
        gbc.gridx = 10;
        jpCenter.add(jbMenuFest,gbc);
        JPanel jpNorth = new JPanel(new FlowLayout(FlowLayout.LEFT));
        jpNorth.add(jbMenuEnrere);
        JPanel jpSouth = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        jpSouth.add(jbConfig);
        jp.add(jpNorth,BorderLayout.NORTH);
        jp.add(jpCenter,BorderLayout.CENTER);
        jp.add(jpSouth,BorderLayout.SOUTH);

        return jp;
    }

    public JPanel buildMenuBuilder (DataManager dm) {
        JPanel jp = new JPanel(new BorderLayout());

        tabbedPane = new JTabbedPane();
        tabbedPane.setBorder(BorderFactory.createTitledBorder(new TitledBorder("Selecciona els elements")));
        tabbedPane.addTab("Primer",buildPrimer(8,dm));
        tabbedPane.addTab("Segon",buildSegon(8,dm));
        tabbedPane.addTab("Postre",buildPostre(5,dm));
        tabbedPane.addTab("Suggeriments",buildSuggeriments(1,dm));
        tabbedPane.addTab("Vins",buildVins(dm));
        jp.add(tabbedPane,BorderLayout.CENTER);

        JPanel jpSouth = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        jbSeg = new JButton("Finalitzar menú");
        jbSeg.setFont(new Font("Arial",Font.BOLD,20));
        jpSouth.add(jbSeg);
        jp.add(jpSouth,BorderLayout.SOUTH);

        JPanel jpNorth = new JPanel(new FlowLayout(FlowLayout.LEFT));
        jbAtras = new JButton("Enrere");
        jpNorth.add(jbAtras);
        jp.add(jpNorth,BorderLayout.NORTH);

        JPanel jpEast = new JPanel(new FlowLayout(FlowLayout.LEFT));

        jpEast.add(menuInflator());
        jp.add(jpEast,BorderLayout.EAST);

        return jp;

    }

    private JPanel buildMainDish (int numPlats,int tipus,Plat[] plats, ArrayList<Plat> lastSelection) {
        JPanel jp = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 10;


        JLabel jlTitle = new JLabel();

        jlTitle.setFont(new Font("Arial",Font.PLAIN,25));
        jp.add(jlTitle,gbc);
/*
        gbc.gridwidth = 1;
        gbc.gridx = 1;
        gbc.gridy = 1;

        JLabel jlBuscador = new JLabel("Buscador:");
        jlBuscador.setFont(new Font("Arial", Font.PLAIN, 20));
        jp.add(jlBuscador, gbc);
        */
        switch (tipus) {

            case PRIMERS_PLAT:

                jlTitle.setText("Escull " + numPlats + " primers plats");
                jbAfegirPlatPrimer = new JButton();
                jbAfegirPlatPrimer.setText("Nou plat");

                /*
                gbc.gridx = 2;
                gbc.gridy = 1;
                jtfBuscadorPrimer = new JTextField();
                jtfBuscadorPrimer.setPreferredSize(new Dimension(200, 50));
                jp.add(jtfBuscadorPrimer, gbc);

                gbc.gridx = 3;
                gbc.gridy = 1;
                jbBuscarPrimer = new JButton("Buscar");
                jbBuscarPrimer.setPreferredSize(new Dimension(100, 50));
                jp.add(jbBuscarPrimer, gbc);
                */

                gbc.gridwidth = 3;
                gbc.gridx = 1;
                gbc.gridy = 2;
                gbc.weighty = 1.0;
                llistaPrimer = new HRCheckBoxList(plats, lastSelection);
                jp.add(llistaPrimer,gbc);

                gbc.gridx = 0;
                gbc.gridy = 3;
                jbAfegirPlatPrimer.setPreferredSize(new Dimension(150,50));
                jp.add(jbAfegirPlatPrimer,gbc);

                break;

            case SEGONS_PLAT:
                jlTitle.setText("Escull " + numPlats + " segons plats");
                jbAfegirPlatSegon = new JButton();
                jbAfegirPlatSegon.setText("Nou plat");

                /*
                gbc.gridx = 2;
                gbc.gridy = 1;
                jtfBuscadorSegon = new JTextField();
                jtfBuscadorSegon.setPreferredSize(new Dimension(200, 50));
                jp.add(jtfBuscadorSegon, gbc);

                gbc.gridx = 3;
                gbc.gridy = 1;
                jbBuscarSegon = new JButton("Buscar");
                jbBuscarSegon.setPreferredSize(new Dimension(100, 50));
                jp.add(jbBuscarSegon, gbc);
*/
                gbc.gridwidth = 3;
                gbc.gridx = 1;
                gbc.gridy = 2;
                gbc.weighty = 1.0;
                llistaSegon = new HRCheckBoxList(plats, lastSelection);
                jp.add(llistaSegon,gbc);


                gbc.gridx = 0;
                gbc.gridy = 3;
                jbAfegirPlatSegon.setPreferredSize(new Dimension(150,50));
                jp.add(jbAfegirPlatSegon,gbc);
                break;

            case POSTRES:
                jlTitle.setText("Selecciona els plats de postres");
                jbAfegirPlatPostre = new JButton();
                jbAfegirPlatPostre.setText("Nou postre");

/*
                gbc.gridx = 2;
                gbc.gridy = 1;
                jtfBuscadorPostre = new JTextField();
                jtfBuscadorPostre.setPreferredSize(new Dimension(200, 50));
                jp.add(jtfBuscadorPostre, gbc);

                gbc.gridx = 3;
                gbc.gridy = 1;
                jbBuscarPostre = new JButton("Buscar");
                jbBuscarPostre.setPreferredSize(new Dimension(100, 50));
                jp.add(jbBuscarPostre, gbc);
*/
                gbc.gridwidth = 3;
                gbc.gridx = 1;
                gbc.gridy = 2;
                gbc.weighty = 1.0;
                llistaPostre = new HRCheckBoxList(plats, lastSelection);
                jp.add(llistaPostre,gbc);

                gbc.gridx = 0;
                gbc.gridy = 3;
                jbAfegirPlatPostre.setPreferredSize(new Dimension(150,50));
                jp.add(jbAfegirPlatPostre,gbc);

                break;

            case SUGGERIMENTS:
                jlTitle.setText("Selecciona els plats de suggeriments");
                jbAfegirPlatSugg = new JButton();
                jbAfegirPlatSugg.setText("Nou plat");

/*
                gbc.gridx = 2;
                gbc.gridy = 1;
                jtfBuscadorSugg = new JTextField();
                jtfBuscadorSugg.setPreferredSize(new Dimension(200, 50));
                jp.add(jtfBuscadorSugg, gbc);

                gbc.gridx = 3;
                gbc.gridy = 1;
                jbBuscarSugg = new JButton("Buscar");
                jbBuscarSugg.setPreferredSize(new Dimension(100, 50));
                jp.add(jbBuscarSugg, gbc);
*/
                gbc.gridwidth = 3;
                gbc.gridx = 1;
                gbc.gridy = 2;
                gbc.weighty = 1.0;
                llistaSugg = new HRCheckBoxList(plats, lastSelection);
                jp.add(llistaSugg,gbc);

                gbc.gridx = 0;
                gbc.gridy = 3;
                jbAfegirPlatSugg.setPreferredSize(new Dimension(150,50));
                jp.add(jbAfegirPlatSugg,gbc);

                break;

        }


        return jp;
    }

    private JPanel buildPrimer (int numPlats,DataManager dm) {
        return buildMainDish(numPlats,PRIMERS_PLAT,dm.getPrimersPlats(), dm.getInfoPackage().lastPrim);
    }

    private JPanel buildSegon (int numPlats,DataManager dm) {

        return buildMainDish(numPlats,SEGONS_PLAT,dm.getSegonsPlats(), dm.getInfoPackage().lastSeg);
    }

    private JPanel buildPostre (int numPlats,DataManager dm) {
        ArrayList <Plat> plats = new ArrayList <>();

        return buildMainDish(numPlats,POSTRES,dm.getPostres(), dm.getInfoPackage().lastPos);
    }

    private JPanel buildSuggeriments (int numPlats,DataManager dm) {
        ArrayList <Plat> plats = new ArrayList <>();

        return buildMainDish(numPlats,SUGGERIMENTS,dm.getPlats(), dm.getInfoPackage().lastSugg);
    }

    private JPanel buildVins (DataManager dm) {
        JPanel jp = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        Vi[] vins = dm.getVins();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 10;

        JLabel jlTitle = new JLabel();

        jlTitle.setFont(new Font("Arial",Font.PLAIN,25));
        jp.add(jlTitle,gbc);

        jlTitle.setText("Màxim 5 vins");

        gbc.gridwidth = 3;
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weighty = 1.0;
        llistaVi = new HRCheckBoxListVins(vins, dm.getInfoPackage().lastVins);
        jp.add(llistaVi,gbc);

        return jp;

    }

    private JPanel menuInflator () {
        JPanel jp = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        dtmPrimers = new DefaultTableModel(new String[]{"Primers"},0);
        jtPrimers = new JTable();
        jp.add(inflateTable(dtmPrimers,jtPrimers),gbc);
        gbc.gridx = 1;
        dtmSegons = new DefaultTableModel(new String[]{"Segons"},0);
        jtSegons = new JTable();
        jp.add(inflateTable(dtmSegons,jtSegons),gbc);
        gbc.gridy = 1;
        gbc.gridx = 0;
        dtmPostres = new DefaultTableModel(new String[]{"Postres"},0);
        jtPostres = new JTable();
        jp.add(inflateTable(dtmPostres,jtPostres),gbc);
        gbc.gridx = 1;
        dtmSuggeriments = new DefaultTableModel(new String[]{"Suggeriments"},0);
        jtSuggeriments = new JTable();
        jp.add(inflateTable(dtmSuggeriments,jtSuggeriments),gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        dtmVins = new DefaultTableModel(new String[]{"Vins"},0);
        jtVins = new JTable();
        jp.add(inflateTableVE(dtmVins,jtVins),gbc);
        return jp;

    }

    private JPanel inflateTable (DefaultTableModel dtm, JTable jManage) {

        JPanel card = new JPanel(new BorderLayout());

        jManage.getTableHeader().setFont(new Font("Arial",Font.PLAIN,15));
        jManage.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        jManage.getTableHeader().setPreferredSize(new Dimension(10,18));
        jManage.setModel(dtm);

        jManage.setFillsViewportHeight(true);
        jManage.setPreferredScrollableViewportSize(new Dimension(200,245));


        JPanel jpSouth = new JPanel();
        FlowLayout flowLayout = new FlowLayout();
        flowLayout.setAlignment(FlowLayout.RIGHT);
        jpSouth.setLayout(flowLayout);

        jManage.setEnabled(false);
        card.add(new JScrollPane(jManage),BorderLayout.CENTER);

        card.add(jpSouth,BorderLayout.SOUTH);

        return card;
    }

    private JPanel inflateTableVE (DefaultTableModel defaultTableModel,JTable jManage) {

        JPanel card = new JPanel(new BorderLayout());

        jManage.getTableHeader().setFont(new Font("Arial",Font.PLAIN,15));
        jManage.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        jManage.getTableHeader().setPreferredSize(new Dimension(10,18));
        jManage.setModel(defaultTableModel);

        jManage.setFillsViewportHeight(true);


        if ( jManage == jtVins ) {
            jManage.setPreferredScrollableViewportSize(new Dimension(200,100));
            JPanel jpSouth = new JPanel();
            FlowLayout flowLayout = new FlowLayout();
            flowLayout.setAlignment(FlowLayout.RIGHT);
            jpSouth.setLayout(flowLayout);
            JButton jbDelete = new JButton("Esborrar Vi");
            jbDelete.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed (ActionEvent e) {
                    deleteSelectedVi();
                }
            });
            jpSouth.add(jbDelete);
            card.add(jpSouth,BorderLayout.SOUTH);
        } else {
            jManage.setPreferredScrollableViewportSize(new Dimension(200,140));
        }

        card.add(new JScrollPane(jManage),BorderLayout.CENTER);


        return card;
    }

    public void registreControladors (Controlador c, MouseController mc, MouseControllerVi mc2) {
        jbMenuFest.addActionListener(c);
        jbMenuFest.setActionCommand(BTN_MENU_FEST);
        jbMenuNoFest.addActionListener(c);
        jbMenuNoFest.setActionCommand(BTN_MENU_NO_FEST);
        jbMenuEnrere.addActionListener(c);
        jbMenuEnrere.setActionCommand(BTN_ENRERE_SELECCIO_MENU);
        jbConfig.addActionListener(c);
        jbConfig.setActionCommand(BTN_CONFIG_SELECCIO_MENU);
        jbSeg.addActionListener(c);
        jbSeg.setActionCommand(BTN_SEG_BUILDER);
        jbAtras.addActionListener(c);
        jbAtras.setActionCommand(BTN_ENRERE_BUILDER);

        jbAfegirPlatPrimer.setActionCommand(BTN_NOU_PLAT_PRIMER);
        jbAfegirPlatPrimer.addActionListener(c);

        jbAfegirPlatSegon.setActionCommand(BTN_NOU_PLAT_SEGON);
        jbAfegirPlatSegon.addActionListener(c);

        jbAfegirPlatPostre.setActionCommand(BTN_NOU_PLAT_POSTRE);
        jbAfegirPlatPostre.addActionListener(c);

        jbAfegirPlatSugg.setActionCommand(BTN_NOU_PLAT_SUGG);
        jbAfegirPlatSugg.addActionListener(c);


        configuracio.registreControladors(c);
        c.registrarConfiguracio(configuracio);
        llistaPostre.registreControlador(mc);
        llistaPrimer.registreControlador(mc);
        llistaSugg.registreControlador(mc);
        llistaSegon.registreControlador(mc);
        llistaVi.registreControlador(mc2);
        tabbedPane.addChangeListener(mc);

    }

    public void nextPlayCard (String card) {
        current_card = card;
        clMain.show(jpMainCardLayout,card);
    }

    public void nextPlayCardConfig (String card) {
        configuracio.nextCard(card);

    }

    public void setDades (String info,int type) {

        switch (type) {

            case PRIMERS_PLAT:
                dtmPrimers.addRow(new Object[]{info});

                break;

            case SEGONS_PLAT:
                dtmSegons.addRow(new Object[]{info});
                break;

            case POSTRES:
                dtmPostres.addRow(new Object[]{info});
                break;

            case SUGGERIMENTS:
                dtmSuggeriments.addRow(new Object[]{info});
                break;

            case VINS:
                dtmVins.addRow(new Object[]{info});
                break;

        }

    }
    public void deleteAll () {
        dtmPrimers.setRowCount(0);
        dtmSegons.setRowCount(0);
        dtmPostres.setRowCount(0);
        dtmSuggeriments.setRowCount(0);
        dtmVins.setRowCount(0);


    }

    public void deleteDades (String info,int type) {
        String aux;
        switch (type) {

            case PRIMERS_PLAT:

                for ( int i = dtmPrimers.getRowCount() - 1;i >= 0;i-- ) {

                    aux = (String)dtmPrimers.getValueAt(i,0);

                    if ( aux.equals(info) ) {

                        dtmPrimers.removeRow(i);
                        break;
                    }
                }
                break;

            case SEGONS_PLAT:

                for ( int i = dtmSegons.getRowCount() - 1;i >= 0;i-- ) {

                    aux = (String)dtmSegons.getValueAt(i,0);

                    if ( aux.equals(info) ) {

                        dtmSegons.removeRow(i);
                        break;
                    }
                }

                break;

            case POSTRES:

                for ( int i = dtmPostres.getRowCount() - 1;i >= 0;i-- ) {

                    aux = (String)dtmPostres.getValueAt(i,0);

                    if ( aux.equals(info) ) {

                        dtmPostres.removeRow(i);
                        break;
                    }
                }


                break;

            case SUGGERIMENTS:

                for ( int i = dtmSuggeriments.getRowCount() - 1;i >= 0;i-- ) {

                    aux = (String)dtmSuggeriments.getValueAt(i,0);

                    if ( aux.equals(info) ) {

                        dtmSuggeriments.removeRow(i);
                        break;
                    }
                }


                break;
            case VINS:

                for ( int i = dtmVins.getRowCount() - 1;i >= 0;i-- ) {

                    aux = (String)dtmVins.getValueAt(i,0);

                    if ( aux.equals(info) ) {

                        dtmVins.removeRow(i);
                        break;
                    }
                }


                break;

        }
    }

    public void getDadesVins () {
        dtmVins.addRow(new String[]{jtfNomVi.getText()});
    }

    public void deleteSelectedVi () {
        removeSelectedRows(jtVins,dtmVins);
    }

    public void removeSelectedRows (JTable table,DefaultTableModel model) {
        int[] rows = table.getSelectedRows();
        for ( int i = 0;i < rows.length;i++ ) {
            model.removeRow(rows[i] - i);
        }
    }

    public void refreshDishes (Plat plat) {
        switch (plat.getTipus()) {
            case Plat.PRIMER:
                llistaPrimer.refreshItems(plat);
                break;
            case Plat.SEGON:
                llistaSegon.refreshItems(plat);
                break;
            case Plat.POSTRE:
                llistaPostre.refreshItems(plat);
                break;
            case Plat.SUGGERIMENT:
                llistaSugg.refreshItems(plat);
                break;
        }
    }

    public void refreshAllItems (Plat[] plats, int tipus, GestorMenu gm) {
        DefaultTableModel aux = null;
        ArrayList<Plat> selected = null;
        switch (tipus) {
            case Plat.PRIMER:
                llistaPrimer.refreshItems(plats, gm.getPrimers());
                aux = dtmPrimers;
                selected = gm.getPrimers();
                break;
            case Plat.SEGON:
                aux = dtmSegons;
                llistaSegon.refreshItems(plats, gm.getSegons());
                selected = gm.getSegons();

                break;
            case Plat.POSTRE:
                aux = dtmPostres;
                llistaPostre.refreshItems(plats, gm.getPostres());
                selected = gm.getPostres();
                break;
            case Plat.SUGGERIMENT:
                aux = dtmSuggeriments;
                llistaSugg.refreshItems(plats, gm.getSuggeriments());
                selected = gm.getSuggeriments();
                break;
        }
        if (aux != null) {
            for ( int i = 0; i < selected.size(); i++) {
                aux.addRow(new String[]{selected.get(i).getNomCat()});
            }
        }

    }

    public void refreshVi (Vi[] vins,GestorMenu gm) {
        ArrayList<Vi> selected = gm.getVins();
        llistaVi.refreshItems(vins, selected);

        for ( int i = 0; i < selected.size(); i++) {
            dtmVins.addRow(new String[]{selected.get(i).getNom()});
        }

    }

    public PaquetPlat platClicat (JList <HRCheckBoxList.CheckboxListItem> list,Point point,int pane) {
        HRCheckBoxList.CheckboxListItem item;
        PaquetPlat paquetPlat = new PaquetPlat();
        switch (pane) {
            case 0:
                item = llistaPrimer.platClicat(list, point);
                paquetPlat.setSeleccionat(item.isSelected());
                paquetPlat.setPlat(item.getInfo());

                return paquetPlat;

            case 1:
                item = llistaSegon.platClicat(list, point);
                paquetPlat.setSeleccionat(item.isSelected());
                paquetPlat.setPlat(item.getInfo());
                return paquetPlat;

            case 2:
                item = llistaPostre.platClicat(list, point);
                paquetPlat.setSeleccionat(item.isSelected());
                paquetPlat.setPlat(item.getInfo());
                return paquetPlat;

            case 3:
                item = llistaSugg.platClicat(list, point);
                paquetPlat.setSeleccionat(item.isSelected());
                paquetPlat.setPlat(item.getInfo());
                return paquetPlat;

        }
        return paquetPlat;

    }

    public PaquetVi viClicat (JList <HRCheckBoxListVins.CheckboxListVi> list,Point point) {
        HRCheckBoxListVins.CheckboxListVi item;
        PaquetVi paquetVi = new PaquetVi();
        item = llistaVi.viClicat(list, point);
        paquetVi.setSeleccionat(item.isSelected());
        paquetVi.setVi(item.getInfo());

        return paquetVi;

    }

    public int getSelectedPane () {
        return tabbedPane.getSelectedIndex();
    }



}
