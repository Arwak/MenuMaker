package com.company.Vista.Custom;

import com.company.Model.Alergens;
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
public class HRCheckBoxStringList extends JPanel {
    protected ArrayList<String> selectedItems;
    protected JList<CheckboxListItem> items;
    protected MainView view;
    protected CrearPlat crear;
    protected int type;

    public HRCheckBoxStringList (String[] aux2, MainView view, int type) {
        this.view = view;
        this.type = type;
        crear = null;
        selectedItems = new ArrayList<>();
        items = new JList<>();
        CheckboxListItem[] aux = new CheckboxListItem[aux2.length];
        for (int i = 0; i < aux2.length; i++) {
            aux[i] = new CheckboxListItem(aux2[i]);
        }
        items.setListData(aux);
        items.setCellRenderer(new CheckboxListRenderer());
        items.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        items.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent event) {
                JList<CheckboxListItem> list =
                        (JList<CheckboxListItem>) event.getSource();

                // Get index of item clicked

                int index = list.locationToIndex(event.getPoint());
                CheckboxListItem item = (CheckboxListItem) list.getModel()
                        .getElementAt(index);

                // Toggle selected state

                item.setSelected(!item.isSelected());

                // Repaint cell

                list.repaint(list.getCellBounds(index, index));
            }
        });

        JScrollPane jsp = new JScrollPane(items);
        jsp.setPreferredSize(new Dimension(400, 500));
        this.add(jsp);
        this.setVisible(true);
    }

    public HRCheckBoxStringList (String[] aux2, CrearPlat crear, int type) {
        this.crear = crear;
        this.type = type;
        view = null;
        selectedItems = new ArrayList<>();
        items = new JList<>();
        CheckboxListItem[] aux = new CheckboxListItem[aux2.length];
        for (int i = 0; i < aux2.length; i++) {
            aux[i] = new CheckboxListItem(aux2[i]);
        }
        items.setListData(aux);
        items.setCellRenderer(new CheckboxListRenderer());
        items.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        items.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent event) {
                JList<CheckboxListItem> list =
                        (JList<CheckboxListItem>) event.getSource();

                // Get index of item clicked

                int index = list.locationToIndex(event.getPoint());
                CheckboxListItem item = (CheckboxListItem) list.getModel()
                        .getElementAt(index);

                // Toggle selected state

                item.setSelected(!item.isSelected());

                // Repaint cell

                list.repaint(list.getCellBounds(index, index));
            }
        });

        JScrollPane jsp = new JScrollPane(items);
        jsp.setPreferredSize(new Dimension(400, 500));
        this.add(jsp);
        this.setVisible(true);
    }

    public void setSelectedItems(String[] alergens, ArrayList<String> selectedItems) {
        CheckboxListItem[] aux = new CheckboxListItem[alergens.length];
        for (int i = 0; i < alergens.length; i++) {
            aux[i] = new CheckboxListItem(alergens[i]);
            if (selectedItems.contains(alergens[i])) {
                aux[i].setSelected(true);
            }
        }
        items.setListData(aux);
    }


    public ArrayList<String> getSelectedItems () {
        return selectedItems;
    }

// Represents items in the list that can be selected

    protected class CheckboxListItem {
        private String label;

        private boolean isSelected = false;

        public CheckboxListItem(String label) {
            this.label = label;
        }

        public boolean isSelected() {
            return isSelected;
        }

        public void setSelected(boolean isSelected) {
            this.isSelected = isSelected;
            if (isSelected) {
                selectedItems.add(label);
                if (crear == null) {
                    view.setDades(label, type);
                } else {

                }

            } else {
                selectedItems.remove(label);
                if (crear == null) {
                    view.deleteDades(label, type);
                } else {

                }

            }
        }

        public String toString() {
            return label;
        }

        public ArrayList getSelected() {
            return selectedItems;
        }
    }

// Handles rendering cells in the list using a check box

    protected class CheckboxListRenderer extends JCheckBox implements ListCellRenderer<CheckboxListItem> {

        @Override
        public Component getListCellRendererComponent(JList<? extends CheckboxListItem> list, CheckboxListItem value,  int index, boolean isSelected, boolean cellHasFocus) {
            setEnabled(list.isEnabled());
            setSelected(value.isSelected());
            setFont(new Font("Arial", Font.PLAIN, 18));
            setBackground(list.getBackground());
            setForeground(list.getForeground());
            setText(value.toString());
            return this;
        }
    }

}
