package com.company.Vista.Custom;

import com.company.Controlador.MouseController;
import com.company.Model.Plat;
import com.company.Vista.CrearPlat;
import com.company.Vista.MainView;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.*;

/**
 * Created by xavierromacastells on 24/7/17.
 */
public class HRCheckBoxList extends JPanel {
    protected ArrayList <Plat> selectedItems;
    protected JList <CheckboxListItem> items;
    protected ArrayList <CheckboxListItem> itemsRaw;

    public HRCheckBoxList (Plat[] aux2, ArrayList<Plat> selected) {

        selectedItems = new ArrayList <> (selected);
        items = new JList <> ();
        itemsRaw = new ArrayList <>();
        for ( int i = 0;i < aux2.length;i++ ) {
            CheckboxListItem checkboxListItem = new CheckboxListItem(aux2[i]);
            checkboxListItem.setSelected(isHere(aux2[i], selected));
            itemsRaw.add (checkboxListItem);
        }
        CheckboxListItem[] arr = new CheckboxListItem[itemsRaw.size()];
        arr = itemsRaw.toArray(arr);
        items.setListData (arr);
        items.setCellRenderer (new CheckboxListRenderer ());
        items.setSelectionMode (ListSelectionModel.SINGLE_SELECTION);


        JScrollPane jsp = new JScrollPane(items);
        jsp.setPreferredSize(new Dimension(400, 500));
        this.add(jsp);
        this.setVisible(true);
    }

    private boolean isHere (Plat plat,ArrayList<Plat> selected) {
        for ( int i = 0; i < selected.size(); i++ ) {
            if (selected.get(i).getNomCat().equals(plat.getNomCat()))
                return true;
        }
        return false;
    }


    public void registreControlador(MouseController mc) {
        items.addMouseListener (mc);
    }

    public CheckboxListItem platClicat (JList <CheckboxListItem> list , Point point) {

        // Get index of item clicked

        int index = list.locationToIndex (point);
        CheckboxListItem item = (CheckboxListItem)list.getModel().getElementAt (index);

        // Toggle selected state

        item.setSelected(!item.isSelected());

        // Repaint cell

        list.repaint (list.getCellBounds (index,index));

        return item;
    }

    public ArrayList <Plat> getSelectedItems () {
        return selectedItems;
    }

    public void refreshItems (Plat plat) {
        itemsRaw.add (new CheckboxListItem (plat));
        CheckboxListItem[] arr = new CheckboxListItem[itemsRaw.size()];
        arr = itemsRaw.toArray(arr);
        items.setListData (arr);

    }

    public void refreshItems (Plat[] plats, ArrayList<Plat> selected) {
        itemsRaw.clear();
        selectedItems.clear();
        for ( int i = 0; i < plats.length; i++ ) {
            CheckboxListItem checkboxListItem = new CheckboxListItem(plats[i]);
            if (isHere(plats[i], selected)) {
                checkboxListItem.setSelected(true);
                selectedItems.add(plats[i]);
            }
            itemsRaw.add (checkboxListItem);
        }

        CheckboxListItem[] arr = new CheckboxListItem[itemsRaw.size()];
        arr = itemsRaw.toArray(arr);
        items.setListData (arr);

    }


// Represents items in the list that can be selected

    public class CheckboxListItem {
        private Plat plat;

        private boolean isSelected = false;

        public CheckboxListItem (Plat plat) {
            this.plat = plat;
        }

        public boolean isSelected () {
            return isSelected;
        }

        public void setSelected (boolean isSelected) {
            this.isSelected = isSelected;
            if ( isSelected ) {
                selectedItems.add (plat);

            } else {
                selectedItems.remove (plat);

            }

        }

        public String toString () {
            return plat.getNomCat ();
        }

        public ArrayList getSelected () {
            return selectedItems;
        }


        public Plat getInfo () {
            return plat;
        }
    }

// Handles rendering cells in the list using a check box

    protected class CheckboxListRenderer extends JCheckBox implements ListCellRenderer <CheckboxListItem> {

        @Override
        public Component getListCellRendererComponent (JList <? extends CheckboxListItem> list,CheckboxListItem value,int index,boolean isSelected,boolean cellHasFocus) {
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
