package com.company.Controlador;

import com.company.Model.Plat;
import com.company.Model.Vi;

/**
 * Created by xavierromacastells on 4/8/17.
 */
public class PaquetVi {
    private boolean seleccionat;
    private Vi vi;

    public boolean isSeleccionat () {
        return seleccionat;
    }

    public void setSeleccionat (boolean seleccionat) {
        this.seleccionat = seleccionat;
    }

    public Vi getVi () {
        return vi;
    }

    public void setVi (Vi vi) {
        this.vi = vi;
    }
}
