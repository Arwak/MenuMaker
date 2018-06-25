package com.company.Vista.Custom;

import com.company.Controlador.MouseController;
import com.company.Controlador.MouseControllerVi;
import com.company.Model.Vi;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by xavierromacastells on 24/7/17.
 */
public class HRCheckBoxListVins extends JPanel {
    protected ArrayList <Vi> selectedItems;
    protected JList <CheckboxListVi> items;
    protected ArrayList <CheckboxListVi> itemsRaw;

    public HRCheckBoxListVins (Vi[] aux2,  ArrayList<Vi> selected) {

        selectedItems = new ArrayList <> ();
        items = new JList <> ();
        itemsRaw = new ArrayList <>();
        for ( int i = 0;i < aux2.length;i++ ) {
            CheckboxListVi checkboxListVi = new CheckboxListVi(aux2[i]);
            checkboxListVi.setSelected(isHere(aux2[i], selected));
            itemsRaw.add (checkboxListVi);
        }
        CheckboxListVi[] arr = new CheckboxListVi[itemsRaw.size()];
        arr = itemsRaw.toArray(arr);
        items.setListData (arr);
        items.setCellRenderer (new CheckboxListRenderer ());
        items.setSelectionMode (ListSelectionModel.SINGLE_SELECTION);

        JScrollPane jsp = new JScrollPane(items);
        jsp.setPreferredSize(new Dimension(400, 500));
        this.add(jsp);
        this.setVisible(true);
    }

    private boolean isHere (Vi vi,ArrayList<Vi> selected) {
        for ( int i = 0; i < selected.size(); i++ ) {
            if (selected.get(i).getNom().equals(vi.getNom()))
                return true;
        }
        return false;
    }


    public void registreControlador(MouseControllerVi mc) {
        items.addMouseListener (mc);
    }

    public CheckboxListVi viClicat (JList <CheckboxListVi> list , Point point) {

        // Get index of item clicked

        int index = list.locationToIndex (point);
        CheckboxListVi item = (CheckboxListVi)list.getModel().getElementAt (index);

        // Toggle selected state

        item.setSelected(!item.isSelected());

        // Repaint cell

        list.repaint (list.getCellBounds (index,index));

        return item;
    }

    public ArrayList <Vi> getSelectedItems () {
        return selectedItems;
    }

    public void refreshItems (Vi vi) {
        itemsRaw.add (new CheckboxListVi (vi));
        CheckboxListVi[] arr = new CheckboxListVi[itemsRaw.size()];
        arr = itemsRaw.toArray(arr);
        items.setListData (arr);

    }


    public void refreshItems (Vi[] vins, ArrayList<Vi> selectedVins) {
        itemsRaw.clear();
        selectedItems.clear();
        for ( int i = 0;i < vins.length;i++ ) {
            CheckboxListVi checkboxListVi = new CheckboxListVi(vins[i]);
            if (isHere(vins[i], selectedVins)) {
                checkboxListVi.setSelected(true);
                selectedItems.add(vins[i]);
            }
            itemsRaw.add (checkboxListVi);
        }
        CheckboxListVi[] arr = new CheckboxListVi[itemsRaw.size()];
        arr = itemsRaw.toArray(arr);
        items.setListData (arr);

    }


// Represents items in the list that can be selected

    public class CheckboxListVi {
        private Vi vi;

        private boolean isSelected = false;

        public CheckboxListVi (Vi vi) {
            this.vi = vi;
        }

        public boolean isSelected () {
            return isSelected;
        }

        public void setSelected (boolean isSelected) {
            this.isSelected = isSelected;
            if ( isSelected ) {
                selectedItems.add (vi);

            } else {
                selectedItems.remove (vi);

            }

        }

        public String toString () {
            return vi.getNom();
        }

        public ArrayList getSelected () {
            return selectedItems;
        }


        public Vi getInfo () {
            return vi;
        }
    }

// Handles rendering cells in the list using a check box

    protected class CheckboxListRenderer extends JCheckBox implements ListCellRenderer <CheckboxListVi> {

        @Override
        public Component getListCellRendererComponent (JList <? extends CheckboxListVi> list,CheckboxListVi value,int index,boolean isSelected,boolean cellHasFocus) {
            setEnabled (list.isEnabled ());
            setSelected (value.isSelected ());
            setFont (new Font ("Arial",Font.PLAIN,18));
            setBackground (list.getBackground ());
            setForeground (list.getForeground ());
            setText (value.toString ());
            return this;
        }
    }

}
