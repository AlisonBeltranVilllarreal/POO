package com.company.banco;

import java.util.Date;

public class Movimientos{
    private String tipo;
    private Date fecha;
    private double monto;
    private double saldoAnterior;
    private double saldoActual;

    public Movimientos(String tipo, Date fecha, double monto, double saldoAnterior, double saldoActual) {
        this.tipo = tipo;
        this.fecha = fecha;
        this.monto = monto;
        this.saldoAnterior = saldoAnterior;
        this.saldoActual = saldoActual;
    }

    public void imprimirDatos(){
        System.out.println("TIPO: "+tipo);
        System.out.println("FECHA: "+fecha);
        System.out.println("MONTO: "+monto);
        System.out.println("SALDO ANTERIOR: "+saldoAnterior);
        System.out.println("SALDO ACTUAL: "+saldoActual);
    }

    public String getTipo() {
        return tipo;
    }

    public Date getFecha() {
        return fecha;
    }

    public double getMonto() {
        return monto;
    }

    public double getSaldoAnterio() {
        return saldoAnterior;
    }

    public double getSaldoActual() {
        return saldoActual;
    }
}

