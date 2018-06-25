package com.company;

import com.company.Controlador.*;
import com.company.Model.GestioJson;
import com.company.Model.Plat;
import com.company.Vista.CrearPlat;
import com.company.Vista.MainView;
import com.company.Vista.NouPlat;
import com.google.gson.Gson;

import javax.swing.*;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        System.getProperty("file.encoding");
        DataManager dm = new DataManager();
        GestorMenu gm = new GestorMenu(dm.getInfoPackage());
        MainView view = new MainView(dm);
        Controlador c = new Controlador(view, gm, dm);
        MouseController mc = new MouseController(view, gm);
        MouseControllerVi mc2 = new MouseControllerVi(view, gm);
        view.registreControladors(c, mc, mc2);
    }
}
