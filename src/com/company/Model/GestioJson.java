package com.company.Model;

import com.company.Vista.MostradorDialegs;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by xavierromacastells on 22/2/17.
 *
 * Classe que ofereix la possiblitat de llegir un fitxer json i extreuren
 * un arraylist de l'informacio
 */

public class GestioJson {
    public static final String LINK_A_JSON = "./res/plats.json.txt";


    public static InfoPackage lecturaFitxer(){
        InfoPackage infoPackage = null;
        try {
            JsonReader json = new JsonReader(new FileReader(LINK_A_JSON));
            infoPackage = new Gson().fromJson(json, InfoPackage.class);

        } catch (FileNotFoundException e) {
            MostradorDialegs.showError("Avisar al Xavier Roma, guardar el següent numero: ERROR Nº 01", "ERROR 01");
        } catch (NullPointerException e) {
            MostradorDialegs.showError("Avisar al Xavier Roma, guardar el següent numero: ERROR Nº 01", "ERROR 01");
        }
        return infoPackage;
    }

    public static void guardarFitxer(InfoPackage infoPackage){
        Gson g = new Gson();
        String jsonString = g.toJson(infoPackage);
        try {
            FileWriter fw = new FileWriter(LINK_A_JSON);
            fw.append(jsonString);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
