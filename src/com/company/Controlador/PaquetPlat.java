package com.company.Controlador;

import com.company.Model.Plat;

/**
 * Created by xavierromacastells on 4/8/17.
 */
public class PaquetPlat {
    private boolean seleccionat;
    private Plat plat;

    public boolean isSeleccionat () {
        return seleccionat;
    }

    public void setSeleccionat (boolean seleccionat) {
        this.seleccionat = seleccionat;
    }

    public Plat getPlat () {
        return plat;
    }

    public void setPlat (Plat plat) {
        this.plat = plat;
    }
}
