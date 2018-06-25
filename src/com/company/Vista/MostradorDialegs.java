package com.company.Vista;

import javax.swing.*;

/**
 * Created by xavierromacastells on 2/8/17.
 */
public class MostradorDialegs {

    public static boolean showOptionDialog(String trueText, String falseText, String missatge, String title) {

        String ObjButtons[] = {trueText,falseText};
        int PromptResult = JOptionPane.showOptionDialog(null,missatge,
                title, JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, ObjButtons,ObjButtons[1]);
        if(PromptResult==JOptionPane.YES_OPTION) {
            return true;
        }
        return false;
    }

    public static void showError(String missatge, String title) {

        JOptionPane.showMessageDialog(null, missatge, title, JOptionPane.ERROR_MESSAGE);

    }

    public static void showMessage(String missatge, String title) {

        JOptionPane.showMessageDialog(null, missatge, title, JOptionPane.INFORMATION_MESSAGE);

    }

    public static boolean showWarningMessage(String missatge, String title, String missatgeConfirm, String titleConfirm) {
        JOptionPane.showMessageDialog(null, missatge, title, JOptionPane.WARNING_MESSAGE);
        return showOptionDialog("Continuar", "No continuar", missatgeConfirm, titleConfirm);
    }
}
