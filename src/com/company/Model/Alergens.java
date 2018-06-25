package com.company.Model;

import javax.swing.*;

/**
 * Created by xavierromacastells on 24/7/17.
 */
public class Alergens {
    public final static String[] ALERGIES = {"Gluten", "Crustacis", "Ou", "Peix", "Cacauets" , "Soja" , "Làctics" , "Fruits amb clasca", "Api"
    , "Mostasa", "Sèsam", "Dióxido de azufre i sulfits", "Moluscs", "Altramuces"};
    public final static String GLUTEN = "Gluten";
    public final static String CRUSTACIS = "Crustacis";
    public final static String OU = "Ou";
    public final static String PEIX = "Peix";
    public final static String CACAHUETS = "Cacauets";
    public final static String FRUITS_AMB_CASCARA = "Fruits amb clasca";
    public final static String SOJA = "Soja";
    public final static String LACTICS = "Làctics";
    public final static String API = "Api";
    public final static String MOSTASA = "Mostasa";
    public final static String SESAM = "Sèsam";
    public final static String SULFITS = "Dióxido de azufre i sulfits";
    public final static String MOLUSC = "Moluscs";
    public final static String TRAMUSES = "Altramuces";

    private JList<String> jList;

    public Alergens () {
        jList = new JList<>();
    }

    public static String getAlergenImage(String alergen) {
        switch (alergen) {
            case GLUTEN:
                return "./res/AlergensImages/Gluten.png";

            case CACAHUETS:
                return "./res/AlergensImages/Cacahuet.png";

            case CRUSTACIS:
                return "./res/AlergensImages/Crustacis.png";

            case FRUITS_AMB_CASCARA:
                return "./res/AlergensImages/FruitCascara.png";

            case API:
                return "./res/AlergensImages/Api.png";

            case LACTICS:
                return "./res/AlergensImages/lactic.png";

            case MOLUSC:
                return "./res/AlergensImages/Molusc.png";

            case MOSTASA:
                return "./res/AlergensImages/Mostasa.png";

            case OU:
                return "./res/AlergensImages/Ou.png";

            case PEIX:
                return "./res/AlergensImages/Peix.png";

            case SESAM:
                return "./res/AlergensImages/Sesam.png";

            case SOJA:
                return "./res/AlergensImages/Soja.png";

            case SULFITS:
                return "./res/AlergensImages/Sulfits.png";

            case TRAMUSES:
                return "./res/AlergensImages/tramussa.png";

            default:
                return "./res/AlergensImages/Gluten.png";

        }
    }
}
