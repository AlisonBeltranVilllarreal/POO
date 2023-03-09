package com.company.banco;

import java.util.Scanner;
import java.util.Date;
import java.util.ArrayList;

public class Main {
    public static ArrayList<CuentaBancaria> cuentasBancarias = new ArrayList<>();
    public static Scanner lector = new Scanner(System.in);

    public static void main(String[] args) {

        int op, op2;

        do {
            System.out.println("1.- DAR DE ALTA UNA CUENTA NOMINA");
            System.out.println("2.- DAR DE ALTA UNA CUENTA INVERSION");
            System.out.println("3.- BUSCAR CUENTA POR No. DE CUENTA");
            System.out.println("4.- LISTAR CUENTAS DE NOMINA");
            System.out.println("5.- LISTAR CUENTAS DE INVERSION");

            op = lector.nextInt();

            switch (op) {

                case 1:
                    leerCuentaNomina();
                    break;
                case 2:
                    leerCuentaInversion();
                    break;
                case 3:
                    CuentaBancaria cuentaBancaria = buscarCuenta();
                    if (cuentaBancaria != null) {
                        if(cuentaBancaria.getTipoDeCuenta().equals("NOMINA")){
                            System.out.println();
                            System.out.println("1.- Depositar");
                            System.out.println("2.- Retirar");
                            System.out.println("3.- Consultar saldo");
                            System.out.println("4.- Imprimir Movimientos");
                            op2 = lector.nextInt();

                            switch (op2) {
                                case 1:
                                    depositar(cuentaBancaria);
                                    break;
                                case 2:
                                    retirar(cuentaBancaria);
                                    break;
                                case 3:
                                    consultarSaldo(cuentaBancaria);
                                    break;
                                case 4:
                                    imprimirMovimientos(cuentaBancaria);
                                    break;
                            }
                        } else {
                            CuentaInversion cuentaInversion = cuentaBancaria.getCuentaInversion();
                            double proyeccion = cuentaInversion.proyectarInversion(cuentaBancaria.getSaldo());
                            System.out.println("LA PROYECCION ES: "+proyeccion);
                            System.out.println();
                        }
                    } else {
                        System.out.println("EL NUMERO DE CUENTA NO EXISTE");
                        System.out.println();
                    }
                    break;
                case 4:
                    listarCuentasNomina();
                    break;
                case 5:
                    listarCuentasInversion();
                    break;
            }

        }
        while (op != 0);

    }

    public static void leerCuentaNomina() {
        String nombre, apellido, domicilio, ciudad, telefono;
        long numeroCuenta;
        double saldo;

        System.out.println("INTRODUCE EL NOMBRE DEL CLIENTE:");
        nombre = lector.next();
        System.out.println("INTRODUCE EL APELLIDO DEL CLIENTE:");
        apellido = lector.next();
        System.out.println("INTRODUCE EL DOMICILIO DEL CLIENTE:");
        domicilio = lector.next();
        System.out.println("INTRODUCE LA CIUDAD DEL CLIENTE:");
        ciudad = lector.next();
        System.out.println("INTRODUCE EL TELEFONO DEL CLIENTE:");
        telefono = lector.next();
        System.out.println("INTRODUCE EL NUMERO DE CUENTA DEL CLIENTE:");
        numeroCuenta = lector.nextLong();
        System.out.println("INTRODUCE EL SALDO DEL CLIENTE:");
        saldo = lector.nextInt();

        ArrayList<Movimientos> movimientos = new ArrayList<>();
        Cliente cliente = new Cliente(nombre, apellido, domicilio, ciudad, telefono);
        CuentaNomina cuentaNomina = new CuentaNomina(movimientos);
        cuentasBancarias.add(new CuentaBancaria("NOMINA", numeroCuenta, saldo, new Date(), cliente, cuentaNomina));
        System.out.println("LA CUENTA SE DIO DE ALTA CORRECTAMENTE");
        System.out.println();
    }

    public static void leerCuentaInversion() {
        int plazo, intereses;
        String nombre, apellido, domicilio, ciudad, telefono;
        long numeroCuenta;
        double saldo;

        System.out.println("INTRODUCE EL NOMBRE DEL CLIENTE:");
        nombre = lector.next();
        System.out.println("INTRODUCE EL APELLIDO DEL CLIENTE:");
        apellido = lector.next();
        System.out.println("INTRODUCE EL DOMICILIO DEL CLIENTE:");
        domicilio = lector.next();
        System.out.println("INTRODUCE LA CIUDAD DEL CLIENTE:");
        ciudad = lector.next();
        System.out.println("INTRODUCE EL TELEFONO DEL CLIENTE:");
        telefono = lector.next();
        System.out.println("INTRODUCE EL NUMERO DE CUENTA DEL CLIENTE:");
        numeroCuenta = lector.nextLong();
        System.out.println("INTRODUCE EL SALDO DEL CLIENTE:");
        saldo = lector.nextInt();
        System.out.println("INTRODUCE EL PLAZO:");
        plazo = lector.nextInt();
        System.out.println("INTRODUCE LOS INTERESES:");
        intereses = lector.nextInt();

        Cliente cliente = new Cliente(nombre, apellido, domicilio, ciudad, telefono);
        CuentaInversion cuentaInversion = new CuentaInversion(plazo, intereses);
        cuentasBancarias.add(new CuentaBancaria("INVERSION", numeroCuenta, saldo, new Date(), cliente, cuentaInversion));
        System.out.println("LA CUENTA SE DIO DE ALTA CORRECTAMENTE");
        System.out.println();
    }

    public static void listarCuentasNomina() {
        for (CuentaBancaria item : cuentasBancarias) {
            if (item.getTipoDeCuenta().equals("NOMINA")) {
                item.imprimirDatos();
                System.out.println();
            }
        }
        System.out.println();
    }

    public static void listarCuentasInversion() {
        for (CuentaBancaria item : cuentasBancarias) {
            if (item.getTipoDeCuenta().equals("INVERSION")) {
                item.imprimirDatos();
                System.out.println();
            }
        }
        System.out.println();
    }

    public static CuentaBancaria buscarCuenta() {
        CuentaBancaria cuentaBancaria = null;
        long numeroCuenta;
        System.out.println("INGRESE No. CUENTA PARA CONSULTAR CUENTA: ");
        numeroCuenta = lector.nextInt();
        for (CuentaBancaria item : cuentasBancarias) {
            if (item.getNumeroCuenta() == numeroCuenta) {
                return item;
            }
        }
        return cuentaBancaria;
    }

    public static void depositar(CuentaBancaria cuentaBancaria){
        double monto, saldoAnterior, saldoActual;

        System.out.println("MONTO: ");
        monto = lector.nextDouble();
        System.out.println("SALDO ANTERIOR: ");
        saldoAnterior = lector.nextDouble();
        System.out.println("SALDO ACTUAL: ");
        saldoActual = lector.nextDouble();
        Movimientos movimientos = new Movimientos("DEPOSITO", new Date(), monto, saldoAnterior, saldoActual);
        cuentaBancaria.getCuentaNomina().depositar(movimientos);
        System.out.println("DEPOSITO EXISTOSO");
        System.out.println();
    }

    public static void retirar(CuentaBancaria cuentaBancaria){
        double monto, saldoAnterior, saldoActual;

        System.out.println("MONTO: ");
        monto = lector.nextDouble();
        System.out.println("SALDO ANTERIOR: ");
        saldoAnterior = lector.nextDouble();
        System.out.println("SALDO ACTUAL: ");
        saldoActual = lector.nextDouble();
        Movimientos movimientos = new Movimientos("RETIRO", new Date(), monto, saldoAnterior, saldoActual);
        cuentaBancaria.getCuentaNomina().retirar(movimientos);
        System.out.println("RETIRO EXISTOSO");
    }

    public static void consultarSaldo(CuentaBancaria cuentaBancaria) {
        double total = 0;
        CuentaNomina cuentaNomina = cuentaBancaria.getCuentaNomina();
        ArrayList<Movimientos> movimientos = cuentaNomina.getMovimientos();
        for (Movimientos item : movimientos){
            if(item.getTipo().equals("DEPOSITO")){
                total += item.getMonto();
            } else {
                total -= item.getMonto();
            }
        }
        System.out.println("EL SALDO TOTAL ES: "+total);
        System.out.println();
    }

    public static void imprimirMovimientos(CuentaBancaria cuentaBancaria) {
        CuentaNomina cuentaNomina = cuentaBancaria.getCuentaNomina();
        ArrayList<Movimientos> movimientos = cuentaNomina.getMovimientos();
        for (Movimientos item : movimientos){
            item.imprimirDatos();
            System.out.println();
        }
    }

}

