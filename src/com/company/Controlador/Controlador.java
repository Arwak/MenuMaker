package com.company.Controlador;

import com.company.Model.ExcelManager;
import com.company.Model.Plat;
import com.company.Model.Vi;
import com.company.Vista.*;
import com.company.Vista.Exceptions.CampsBuitsException;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by xavierromacastells on 15/6/17.
 */
public class Controlador implements ActionListener, ListSelectionListener {
    private MainView view;
    private NouPlat vista;
    private CrearPlat controladorVista;
    private GestorMenu gm;
    private DataManager dm;
    private Configuracio configuracio;
    private boolean missatgeRecordatoriFet;
    private int tipusSelectedConfig;


    public Controlador(MainView view, GestorMenu gm, DataManager dm) {
        this.view = view;
        this.gm = gm;
        this.dm = dm;
        missatgeRecordatoriFet = true;
        tipusSelectedConfig = 0;

    }
    public void registreVista (NouPlat vista){
        this.vista = vista;
        controladorVista = vista.getController();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()) {

            case MainView.BTN_MENU_FEST:
                view.nextPlayCard(MainView.CARD_BUILDER);
                view.refreshAllItems(dm.getPrimersPlats(), Plat.PRIMER, gm);
                view.refreshAllItems(dm.getSegonsPlats(), Plat.SEGON, gm);
                view.refreshAllItems(dm.getPostres(), Plat.POSTRE, gm);
                view.refreshAllItems(dm.getSuggeriments(), Plat.SUGGERIMENT, gm);
                view.refreshVi(dm.getVins(), gm);
                break;

            case MainView.BTN_MENU_NO_FEST:
                view.nextPlayCard(MainView.CARD_BUILDER);
                view.refreshAllItems(dm.getPrimersPlats(), Plat.PRIMER, gm);
                view.refreshAllItems(dm.getSegonsPlats(), Plat.SEGON, gm);
                view.refreshAllItems(dm.getPostres(), Plat.POSTRE, gm);
                view.refreshAllItems(dm.getSuggeriments(), Plat.SUGGERIMENT, gm);
                view.refreshVi(dm.getVins(), gm);

                break;

            case MainView.BTN_ENRERE_SELECCIO_MENU:
                System.out.println("BTN_ENRERE_SELECCIO_MENU");

                break;

            case MainView.BTN_CONFIG_SELECCIO_MENU:
                System.out.println("BTN_CONFIG_SELECCIO_MENU");
                view.nextPlayCard(MainView.CARD_CONFIG);

                break;

            case MainView.BTN_ENRERE_BUILDER:
                view.nextPlayCard(MainView.CARD_TYPE);
                System.out.println("BTN_ENRERE_BUILDER");
                view.deleteAll();
                //gm.removeAllPlats();

                break;

            case MainView.BTN_SEG_BUILDER:
                System.out.println("BTN_SEG_BUILDER");
                gm.sort();
                gm.saveSelection();
                switch (gm.checkNumbers()){
                    case 1:
                        MostradorDialegs.showError("Has seleccionat més de 13 primers plats", "Error, massa primers");
                        break;
                    case 2:
                        MostradorDialegs.showError("Has seleccionat més de 13 segons plats", "Error, massa segons");
                        break;
                    case 3:
                        MostradorDialegs.showError("Has seleccionat més de 10 postres plats", "Error, massa postres");
                        break;
                    case 4:
                        MostradorDialegs.showError("Has seleccionat més de 5 suggermients plats", "Error, massa suggermients");
                        break;
                    case 5:
                        MostradorDialegs.showError("Has seleccionat més de 5 vins plats", "Error, massa vins");
                        break;
                    default:
                        try {
                            new ExcelManager(gm);
                            MostradorDialegs.showMessage("Fitxers excels generats amb éxit!", "Tasca Finalitzada");
                            view.deleteAll();
                            view.nextPlayCard(MainView.CARD_TYPE);
                        } catch (Exception exc) {
                            MostradorDialegs.showError("Error número 02, NO toquis res i avisa al Xavier Roma, comunica-li el numero d'error", "Error 02");
                        }


                        break;
                }
                break;

            case MainView.BTN_ACCEPT_PRIMER:
                System.out.println("BTN_ACCEPT");

                break;

            case MainView.BTN_NOU_PLAT_PRIMER:
                System.out.println("BTN_NOU_PLAT");
                vista = new NouPlat();
                view.setEnabled(false);
                registreVista(vista);
                vista.registreControladors(this);
                vista.setVisible(true);
                controladorVista.setTipus(Plat.PRIMER);

                break;


            case MainView.BTN_ACCEPT_SEGON:
                System.out.println("BTN_ACCEPT");

                break;

            case MainView.BTN_NOU_PLAT_SEGON:
                System.out.println("BTN_NOU_PLAT");
                vista = new NouPlat();
                view.setEnabled(false);
                registreVista(vista);
                vista.registreControladors(this);
                vista.setVisible(true);
                controladorVista.setTipus(Plat.SEGON);

                break;

            case MainView.BTN_ACCEPT_POSTRE:
                System.out.println("BTN_ACCEPT");

                break;

            case MainView.BTN_NOU_PLAT_POSTRE:
                vista = new NouPlat();
                view.setEnabled(false);
                registreVista(vista);
                vista.registreControladors(this);
                vista.setVisible(true);
                controladorVista.setTipus(Plat.POSTRE);

                break;

            case MainView.BTN_ACCEPT_SUGG:
                System.out.println("BTN_ACCEPT");

                break;

            case MainView.BTN_NOU_PLAT_SUGG:
                System.out.println("BTN_NOU_PLAT");
                vista = new NouPlat();
                view.setEnabled(false);
                registreVista(vista);
                vista.registreControladors(this);
                vista.setVisible(true);
                controladorVista.setTipus(Plat.SUGGERIMENT);

                break;

            case MainView.BTN_ADD_VI:
                System.out.println("BTN_ACCEPT");
                view.getDadesVins();

                break;


            case CrearPlat.BTN_GUARDAR:
                if (MostradorDialegs.showWarningMessage("L'informació dels alergens ÉS MOLT IMPORTANT, assegura't que tota la informació referent a les intolerancies es correcta", "Missatge d'avís", "Si vols revisar l'informació prem No Continuar", "Última oportunitat")) {
                    try {
                        Plat plat = controladorVista.collectInfo();
                        switch (plat.getTipus()) {
                            case Plat.PRIMER:
                                dm.addPrimerPlat(plat);
                                break;
                            case Plat.SEGON:
                                dm.addSegonPlat(plat);
                                break;
                            case Plat.POSTRE:
                                dm.addPostres(plat);
                                break;
                            case Plat.SUGGERIMENT:
                                dm.addSuggeriment(plat);
                                break;
                        }
                        dm.guardarInformacio();
                        vista.sayOK();
                        view.setEnabled(true);
                        view.refreshDishes (plat);
                    } catch (CampsBuitsException exc) {
                        MostradorDialegs.showError(exc.getMessage(), "Error");
                    } catch (NumberFormatException exc2) {
                        MostradorDialegs.showError("Els camps de preus no estan en format correcte, recorda que s'ha d'introduir numeros", "Error");
                    }
                }
                break;

            case CrearPlat.BTN_CANCELAR:

                if (vista.askToClose()) {
                    vista.dispose();
                    view.setEnabled(true);
                }


                break;


        // Accions Configuracio
            case Configuracio.BTN_CONFIG_ENRERE:
                view.nextPlayCard(MainView.CARD_TYPE);


                break;

            case Configuracio.BTN_CONFIG_GUARDAR_NOU_PLAT:
                try {
                    dm.modificarPlat(configuracio.getSelectedIndex(), configuracio.getNouPlat());
                    MostradorDialegs.showMessage("Plat actualitzat amb èxit", "Plat actualitzat");
                    configuracio.refreshData(dm.getPlats());
                } catch (CampsBuitsException e1) {
                    MostradorDialegs.showError(e1.getMessage(), "Error");
                }

                break;

            case Configuracio.BTN_CONFIG_CANCELAR_NOU_PLAT:
                if (MostradorDialegs.showOptionDialog("Descartar", "No Descartar", "Vols descartar els canvis?", "Cancelar canvis")) {
                    configuracio.setData(dm.getPlatsAtIndex(configuracio.getSelectedIndex()));
                }
                break;

            case Configuracio.BTN_FILTRE:
                switch (configuracio.getSelectedFiltre()) {
                    case Plat.TOTS_STR:
                        configuracio.refreshData(dm.getPlats());
                        tipusSelectedConfig = 0;
                        break;
                    case Plat.PRIMER_STR:
                        configuracio.refreshData(dm.getPrimersPlats());
                        tipusSelectedConfig = 1;
                        break;
                    case Plat.SEGON_STR:
                        configuracio.refreshData(dm.getSegonsPlats());
                        tipusSelectedConfig = 2;
                        break;
                    case Plat.POSTRE_STR:
                        configuracio.refreshData(dm.getPostres());
                        tipusSelectedConfig = 3;
                        break;
                    case Plat.SUGG_STR:
                        configuracio.refreshData(dm.getSuggeriments());
                        tipusSelectedConfig = 4;
                        break;

                }

                break;

            case Configuracio.BTN_GUARDAR_NOU_PREU:
                configuracio.guardarPreus(dm);


                break;

            case Configuracio.BTN_CANCELAR_NOU_PREU:
                configuracio.posarPreuGuardat(dm);

                break;

            case Configuracio.BTN_ATRAS_ADD_VINS:
            case Configuracio.BTN_ATRAS_MOD_VINS:
            case Configuracio.BTN_CONFIG_ENRERE_MOD_PLAT:
            case Configuracio.BTN_CONFIG_ENRERE_MOD_PREU:
            case Configuracio.BTN_CONFIG_ENRERE_NOU_PLAT:
                view.nextPlayCardConfig(Configuracio.CARD_MENU);
                break;

            case Configuracio.BTN_MOD_CARACT_CONFIG:
                view.nextPlayCardConfig(Configuracio.CARD_MOD_CARCT);

                break;

            case Configuracio.BTN_MOD_PLATS_CONFIG:
                view.nextPlayCardConfig(Configuracio.CARD_MOD_PLATS);
                configuracio.refreshData(dm.getPlats());
                configuracio.setSelected(0);
                missatgeRecordatoriFet = false;

                break;

            case Configuracio.BTN_ADD_PLATS_CONFIG:
                view.nextPlayCardConfig(Configuracio.CARD_ADD_PLATS);

                break;

            case Configuracio.BTN_CANCELAR_BRAND_NEW:
                if (MostradorDialegs.showOptionDialog("Descartar", "No Descartar", "Vols descartar el nou plat?", "Cancelar nou plat")) {
                    configuracio.clearBrandNewInfo();
                }

                break;

            case Configuracio.BTN_GUARDAR_BRAND_NEW:

                if (MostradorDialegs.showWarningMessage("L'informació dels alergens ÉS MOLT IMPORTANT, assegura't que tota la informació referent a les intolerancies es correcta", "Missatge d'avís", "Si vols revisar l'informació prem No Continuar", "Última oportunitat")) {
                    try {
                        Plat plat = configuracio.getBrandNewPlat();
                        switch (plat.getTipus()) {
                            case Plat.PRIMER:
                                dm.addPrimerPlat(plat);
                                break;
                            case Plat.SEGON:
                                dm.addSegonPlat(plat);
                                break;
                            case Plat.POSTRE:
                                dm.addPostres(plat);
                                break;
                            case Plat.SUGGERIMENT:
                                dm.addSuggeriment(plat);
                                break;
                        }
                        dm.guardarInformacio();
                        configuracio.clearBrandNewInfo();
                        MostradorDialegs.showMessage("Plat guardat amb éxit", "Missatge Informatiu");
                    } catch (CampsBuitsException exc) {
                        MostradorDialegs.showError(exc.getMessage(), "Error");
                    } catch (NumberFormatException exc2) {
                        MostradorDialegs.showError("Els camps de preus no estan en format correcte, recorda que s'ha d'introduir numeros", "Error");
                    }
                }
                break;

            case Configuracio.BTN_MOD_VINS:
                configuracio.nextCard(Configuracio.CARD_MOD_VINS);
                break;

            case Configuracio.BTN_ADD_VINS:
                configuracio.nextCard(Configuracio.CARD_ADD_VINS);
                break;

            case Configuracio.BTN_ELIMINAR_PLAT:
                dm.deletePlat(configuracio.getSelectedIndex());
                MostradorDialegs.showMessage("Plat eliminat amb èxit, aquesta operació no es pot desfer", "Plat eliminat");
                configuracio.refreshData(dm.getPlats());

                break;
            case Configuracio.BTN_GUARDAR_NOU_VI:
                Vi vi = configuracio.getNouVi();
                dm.guardarNouVi(vi);
                MostradorDialegs.showMessage("Vi afegit amb éxit", "Vi afegit");
                configuracio.clearViInfo();
                configuracio.refreshDataVi(dm.getVins());
                break;

            case Configuracio.BTN_DELETE_VI:
                dm.deleteVi(configuracio.getSelectedViIndex());
                configuracio.refreshDataVi(dm.getVins());
                break;


        }
    }

    public void enableOtherView(){
            view.setEnabled(true);
        }

    public void registrarConfiguracio(Configuracio configuracio) {
        this.configuracio = configuracio;
    }

    @Override
    public void valueChanged (ListSelectionEvent e) {
        if (e.getValueIsAdjusting() == false) {

            if (configuracio.getSelectedIndex() == -1) {
                //No selection

            } else {
                //Selection
                if ( missatgeRecordatoriFet || MostradorDialegs.showOptionDialog("Continuar", "Enrere", "Els canvis no és guarden sols, NOMÉS és guarden amb el botó GUARDAR, si vols continuar sense guardar prem Continuar", "Recordatori")) {
                    switch (tipusSelectedConfig) {
                        case 0:
                            configuracio.setData(dm.getPlatsAtIndex(configuracio.getSelectedIndex()));
                            break;
                        case 1:
                            configuracio.setData(dm.getPrimersPlatsAtIndex(configuracio.getSelectedIndex()));
                            break;
                        case 2:
                            configuracio.setData(dm.getSegonsPlatsAtIndex(configuracio.getSelectedIndex()));
                            break;
                        case 3:
                            configuracio.setData(dm.getPostresAtIndex(configuracio.getSelectedIndex()));
                            break;
                        case 4:
                            configuracio.setData(dm.getSuggerimentsAtIndex(configuracio.getSelectedIndex()));
                            break;
                    }

                    missatgeRecordatoriFet = true;
                }
            }
        }
    }


}
