package com.company.Model;

import com.company.Controlador.GestorMenu;
import javafx.scene.image.WritableImage;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.jnlp.PrintService;
import javax.print.PrintServiceLookup;
import java.awt.*;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.*;
import java.util.ArrayList;

/**
 * Created by xavierromacastells on 12/8/17.
 */
public class ExcelManager {


    public static final String NOM_MENU_CAT = "Menú complet: ";
    public static final String NOM_MENU_LLEUGER_CAT = "Menú lleuger: ";
    public static final String NOM_MENU_EXPRES_CAT = "Menú expres: ";
    public static final String NOM_MENU_INFANTIL_CAT = "Menú infantil: ";

    public static final String NOM_MENU_ESP = "Menú completo: ";
    public static final String NOM_MENU_LLEUGER_ESP = "Menú ligero: ";
    public static final String NOM_MENU_EXPRES_ESP = "Menú expres: ";
    public static final String NOM_MENU_INFANTIL_ESP = "Menú infantil: ";

    public static final String NOM_MENU_ENG = "Menú complert: ";
    public static final String NOM_MENU_LLEUGER_ENG = "Menú lleuger: ";
    public static final String NOM_MENU_EXPRES_ENG = "Menú expres: ";
    public static final String NOM_MENU_INFANTIL_ENG = "Menú infantil: ";

    private final static int NUM_ALERGENS = 4;
    private final static int INICI_PRIMERS = 3;
    private final static int INICI_SEGONS = 17;
    private final static int INICI_POSTRES = 31;
    private final static int INICI_VINS = 31;
    private final static int INICI_SUGGERIMENTS = 42;
    private final static int INICI_PREUS = 42;
    private final static int INICI_SEGONA_COLUMNA = 22;
    private final static int INICI_PRIMERA_COLUMNA = 5;
    private final static int CATALA = 0;
    private final static int CASTELLA = 1;
    private final static int ANGLES = 2;

    private  XSSFWorkbook workbook;
    private XSSFSheet sheet;

    public ExcelManager(GestorMenu gm) {
        generaMenuCat(gm);
        generaMenuEsp(gm);
    }

    public void generaMenuCat(GestorMenu gestorMenu) {

        FileInputStream plantilla = null;

        try {
            File fitxer = new File("./res/Excel/PlantillaCat.xlsx");
            plantilla = new FileInputStream(fitxer);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            workbook = new XSSFWorkbook(plantilla);
        } catch (IOException e) {
            e.printStackTrace();

        }

        sheet = workbook.getSheet("Sheet1");
        writeData(INICI_PRIMERS,gestorMenu.getPrimers().size(),gestorMenu.getPrimers(), CATALA);
        writeData(INICI_SEGONS,gestorMenu.getSegons().size(),gestorMenu.getSegons(), CATALA);
        writeData(INICI_POSTRES,gestorMenu.getPostres().size(),gestorMenu.getPostres(), CATALA);
        writeData(INICI_SUGGERIMENTS,gestorMenu.getSuggeriments().size(),gestorMenu.getSuggeriments(), CATALA);
        writeVins(INICI_VINS,gestorMenu.getVins().size() ,gestorMenu.getVins(), CATALA);
        writePreus(gestorMenu, CATALA);

        try {
            FileOutputStream out = new FileOutputStream("./res/Excel/OutCatala.xlsx");
            workbook.write(out);
            Desktop.getDesktop().print(new File("./res/Excel/OutCatala.xlsx"));
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void generaMenuEsp(GestorMenu gestorMenu) {

        FileInputStream plantilla = null;

        try {
            File fitxer = new File("./res/Excel/PlantillaEsp.xlsx");
            plantilla = new FileInputStream(fitxer);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            workbook = new XSSFWorkbook(plantilla);
        } catch (IOException e) {
            e.printStackTrace();

        }

        sheet = workbook.getSheet("Sheet1");
        writeData(INICI_PRIMERS,gestorMenu.getPrimers().size(),gestorMenu.getPrimers(), CASTELLA);
        writeData(INICI_SEGONS,gestorMenu.getSegons().size(),gestorMenu.getSegons(), CASTELLA);
        writeData(INICI_POSTRES,gestorMenu.getPostres().size(),gestorMenu.getPostres(), CASTELLA);
        writeData(INICI_SUGGERIMENTS,gestorMenu.getSuggeriments().size(),gestorMenu.getSuggeriments(), CASTELLA);
        writeVins(INICI_VINS,gestorMenu.getVins().size() ,gestorMenu.getVins(), CASTELLA);
        writePreus(gestorMenu, CASTELLA);

        try {
            FileOutputStream out = new FileOutputStream("./res/Excel/OutCastella.xlsx");
            workbook.write(out);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void writeData(int inici, int fi, ArrayList<Plat> plats, int idioma) {
        Cell cell = null;
        WritableImage image;
        ArrayList<String> alergens = null;
        int midaAlergens;
        int desplasPlat = 0;
        for (int i = 0; i < fi; i++){

            alergens = plats.get(i).getAlergens();
            midaAlergens = alergens.size();

            for (int j = 0; j < midaAlergens; j++) {
                if (j <= NUM_ALERGENS) {
                    posaImatge(Math.abs(j - NUM_ALERGENS),i + inici, Alergens.getAlergenImage(alergens.get(j)));
                } else {
                    posaImatge(Math.abs(j),i + inici, Alergens.getAlergenImage(alergens.get(j)));

                    desplasPlat++;
                }
            }
            cell = sheet.getRow(i + inici).getCell(INICI_PRIMERA_COLUMNA + desplasPlat);
            if (cell == null) {
                cell = sheet.getRow(i + inici).createCell(INICI_PRIMERA_COLUMNA + desplasPlat);
            }
            switch (idioma) {

                case CATALA:
                    cell.setCellValue(plats.get(i).getNomCat());
                    break;

                case CASTELLA:
                    cell.setCellValue(plats.get(i).getNomEsp());
                    break;

                case ANGLES:
                    cell.setCellValue(plats.get(i).getNomEng());
                    break;

                default:
                    cell.setCellValue(plats.get(i).getNomCat());
                    break;
            }
            desplasPlat = 0;
        }
    }

    public void writeVins(int inici, int fi, ArrayList<Vi> vins, int idioma) {
        Cell cell = null;
        int desplas = 0;
        for (int i = 0; i < fi; i++){

            cell = sheet.getRow(i + inici + desplas).getCell(INICI_SEGONA_COLUMNA);
            if (cell == null) {
                cell = sheet.getRow(i + inici + desplas).createCell(INICI_SEGONA_COLUMNA);
            }
            cell.setCellValue(vins.get(i).getNom() + " " + String.format("%.2f", vins.get(i).getPreu()) + "€");

            cell = sheet.getRow(i + inici + 1 + desplas).getCell(INICI_SEGONA_COLUMNA);
            if (cell == null) {
                cell = sheet.getRow(i + inici + 1 + desplas).createCell(INICI_SEGONA_COLUMNA);
            }
            cell.setCellValue("    D.O " + vins.get(i).getBodegues());
            desplas++;

        }
    }


    private void writePreus(GestorMenu gm, int idioma) {
        Cell cell = null;
        StringBuilder sb = new StringBuilder();
        String aux;
        for (int i = 0; i < 4; i++) {
            cell = sheet.getRow(INICI_PREUS + i).getCell(INICI_SEGONA_COLUMNA);
            if ( cell == null ) {
                cell = sheet.getRow(INICI_PREUS + i).createCell(INICI_SEGONA_COLUMNA);
            }
            switch (idioma) {

                case CASTELLA:
                    switch (i) {
                        case 0:
                            sb.append(NOM_MENU_ESP);
                            sb.append(" ");

                            if ( gm.isFestiu() ) {
                                sb.append(String.format("%.2f", gm.infoPackage.preuFestiu));
                            } else {
                                sb.append(String.format("%.2f", gm.infoPackage.preuNoFestiu));
                            }
                            break;
                        case 1:
                            sb.append(NOM_MENU_EXPRES_ESP);
                            sb.append(" ");

                            if ( gm.isFestiu() ) {
                                sb.append(String.format("%.2f", gm.infoPackage.preuFestiuExpress));
                            } else {
                                sb.append(String.format("%.2f", gm.infoPackage.preuNoFestiuExpress));
                            }
                            break;
                        case 2:
                            sb.append(NOM_MENU_LLEUGER_ESP);
                            sb.append(" ");

                            if ( gm.isFestiu() ) {
                                sb.append(String.format("%.2f", gm.infoPackage.preuFestiuLleuger));
                            } else {
                                sb.append(String.format("%.2f", gm.infoPackage.preuNoFestiuLleuger));
                            }

                            break;
                        case 3:
                            sb.append(NOM_MENU_INFANTIL_ESP);
                            sb.append(" ");

                            if ( gm.isFestiu() ) {
                                sb.append(String.format("%.2f", gm.infoPackage.preuFestiuInfantil));
                            } else {
                                sb.append(String.format("%.2f", gm.infoPackage.preuNoFestiuInfantil));
                            }
                            break;
                    }
                    break;

                case ANGLES:
                    switch (i) {
                        case 0:
                            sb.append(NOM_MENU_ENG);
                            sb.append(" ");

                            if ( gm.isFestiu() ) {
                                sb.append(String.format("%.2f", gm.infoPackage.preuFestiu));
                            } else {
                                sb.append(String.format("%.2f", gm.infoPackage.preuNoFestiu));
                            }
                            break;
                        case 1:
                            sb.append(NOM_MENU_EXPRES_ENG);
                            sb.append(" ");

                            if ( gm.isFestiu() ) {
                                sb.append(String.format("%.2f", gm.infoPackage.preuFestiuExpress));
                            } else {
                                sb.append(String.format("%.2f", gm.infoPackage.preuNoFestiuExpress));
                            }
                            break;
                        case 2:
                            sb.append(NOM_MENU_LLEUGER_ENG);
                            sb.append(" ");

                            if ( gm.isFestiu() ) {
                                sb.append(String.format("%.2f", gm.infoPackage.preuFestiuLleuger));
                            } else {
                                sb.append(String.format("%.2f", gm.infoPackage.preuNoFestiuLleuger));
                            }
                            break;
                        case 3:
                            sb.append(NOM_MENU_INFANTIL_ENG);
                            sb.append(" ");

                            if ( gm.isFestiu() ) {
                                sb.append(String.format("%.2f", gm.infoPackage.preuFestiuInfantil));
                            } else {
                                sb.append(String.format("%.2f", gm.infoPackage.preuNoFestiuInfantil));
                            }

                            break;
                    }
                    break;

                case CATALA:
                default:
                    switch (i) {
                        case 0:
                            sb.append(NOM_MENU_CAT);
                            sb.append(" ");

                            if ( gm.isFestiu() ) {
                                sb.append(String.format("%.2f", gm.infoPackage.preuFestiu));
                            } else {
                                sb.append(String.format("%.2f", gm.infoPackage.preuNoFestiu));
                            }
                            break;
                        case 1:
                            sb.append(NOM_MENU_EXPRES_CAT);
                            sb.append(" ");

                            if ( gm.isFestiu() ) {
                                sb.append(String.format("%.2f", gm.infoPackage.preuFestiuExpress));
                            } else {
                                sb.append(String.format("%.2f", gm.infoPackage.preuNoFestiuExpress));
                            }
                            break;
                        case 2:
                            sb.append(NOM_MENU_LLEUGER_CAT);
                            sb.append(" ");
                            if ( gm.isFestiu() ) {
                                sb.append(String.format("%.2f", gm.infoPackage.preuFestiuLleuger));
                            } else {
                                sb.append(String.format("%.2f", gm.infoPackage.preuNoFestiuLleuger));
                            }
                            break;
                        case 3:
                            sb.append(NOM_MENU_INFANTIL_CAT);
                            sb.append(" ");

                            if ( gm.isFestiu() ) {
                                sb.append(String.format("%.2f", gm.infoPackage.preuFestiuInfantil));
                            } else {
                                sb.append(String.format("%.2f", gm.infoPackage.preuNoFestiuInfantil));
                            }
                            break;
                    }
                    break;

            }

            sb.append(" €");
            cell.setCellValue(sb.toString());
            sb.setLength(0);
        }
    }

    private void posaImatge(int col, int row, String pathAImg) {

            //FileInputStream obtains input bytes from the image file
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(pathAImg);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //Get the contents of an InputStream as a byte[].
        byte[] bytes = new byte[0];
        try {
            bytes = IOUtils.toByteArray(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Adds a picture to the workbook
            int pictureIdx = workbook.addPicture(bytes, Workbook.PICTURE_TYPE_PNG);
            //close the input stream
        try {
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Returns an object that handles instantiating concrete classes
            CreationHelper helper = workbook.getCreationHelper();

            //Creates the top-level drawing patriarch.
            Drawing drawing = sheet.createDrawingPatriarch();

            //Create an anchor that is attached to the worksheet
            ClientAnchor anchor = helper.createClientAnchor();

            //set top-left corner for the image

            anchor.setCol1(col);

            anchor.setRow1(row);

            //Creates a picture
            Picture pict = drawing.createPicture(anchor, pictureIdx);
            //Reset the image to the original size
            pict.resize(0.25);

    }
}
