package com.company.banco;

import java.util.ArrayList;

public class CuentaNomina{
    private ArrayList<Movimientos> movimientos = new ArrayList<>();


    public CuentaNomina(ArrayList<Movimientos> movimientos) {
        this.movimientos = movimientos;
    }

    public ArrayList<Movimientos> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(ArrayList<Movimientos> movimientos) {
        this.movimientos = movimientos;
    }

    public void depositar(Movimientos movimientos){
        this.movimientos.add(movimientos);
    }

    public void retirar(Movimientos movimientos){
        this.movimientos.add(movimientos);
    }
}

