
import java.util.Scanner;
import java.util.Date;
import java.util.ArrayList;

public class TestBanco{
   
    public static ArrayList<CuentaBancaria> cuentasBancarias = new ArrayList<>();
    public static Scanner lector = new Scanner(System.in);

    public static void main(String[] args) {

        Cliente cliente;
        Scanner lector = new Scanner(System.in);

        Date dateAlta;
        double saldo;
        long numeroCuenta;
       
        int op, op2;

        do {
            System.out.println("1.- Dar de Alta una Cuenta Nomina");
            System.out.println("2.- Dar de Alta una Cuenta Inversion");
            System.out.println("3.- Buscar Cuenta por Numero de Cuenta");
            System.out.println("4.- Listar Cuentas de Nomina");
            System.out.println("5.- Listar Cuentas de Inversion");

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
                        if(cuentaBancaria.getTipoDeCuenta().equals("Nomina")){
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
                            System.out.println("Proyeccion es:: "+proyeccion);
                            System.out.println();
                        }
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

        System.out.println("Ingrese los Datos del Cliente");
        System.out.println("Nombre: ");
        nombre = lector.next();
        System.out.println("Apellido: ");
        apellido = lector.next();
        System.out.println("Domicilio:");
        domicilio = lector.next();
        System.out.println("Ciudad:");
        ciudad = lector.next();
        System.out.println("Telefono:");
        telefono = lector.next();
        System.out.println("Crea un Numero de Cuenta:");
        numeroCuenta = lector.nextLong();
        System.out.println("Saldo del Cliente:");
        saldo = lector.nextInt();

        ArrayList<Movimientos> movimientos = new ArrayList<>();
        Cliente cliente = new Cliente(nombre, apellido, domicilio, ciudad, telefono);
        CuentaNomina cuentaNomina = new CuentaNomina(movimientos);
        cuentasBancarias.add(new CuentaBancaria("Nomina", numeroCuenta, saldo, new Date(), cliente, cuentaNomina));
        System.out.println();
    }

    public static void leerCuentaInversion() {
        int plazo, intereses;
        String nombre, apellido, domicilio, ciudad, telefono;
        long numeroCuenta;
        double saldo;

        System.out.println("Ingrese los Datos del Cliente");
        System.out.println("Nombre: ");
        nombre = lector.next();
        System.out.println("Apellido: ");
        apellido = lector.next();
        System.out.println("Domicilio:");
        domicilio = lector.next();
        System.out.println("Ciudad:");
        ciudad = lector.next();
        System.out.println("Telefono:");
        telefono = lector.next();
        System.out.println("Crea un Numero de Cuenta:");
        numeroCuenta = lector.nextLong();
        System.out.println("Saldo del Cliente:");
        saldo = lector.nextInt();
        System.out.println("Plazo:");
        plazo = lector.nextInt();
        System.out.println("Intereses: ");
        intereses = lector.nextInt();

        Cliente cliente = new Cliente(nombre, apellido, domicilio, ciudad, telefono);
        CuentaInversion cuentaInversion = new CuentaInversion(plazo, intereses);
        cuentasBancarias.add(new CuentaBancaria("Inversion", numeroCuenta, saldo, new Date(), cliente, cuentaInversion));
        System.out.println();
    }

    public static void listarCuentasNomina() {
        for (CuentaBancaria item : cuentasBancarias) {
            if (item.getTipoDeCuenta().equals("Nomina")) {
                item.imprimirDatos();
                System.out.println();
            }
        }
        System.out.println();
    }

    public static void listarCuentasInversion() {
        for (CuentaBancaria item : cuentasBancarias) {
            if (item.getTipoDeCuenta().equals("Inversion")) {
                item.imprimirDatos();
                System.out.println();
            }
        }
        System.out.println();
    }

    public static CuentaBancaria buscarCuenta() {
        CuentaBancaria cuentaBancaria = null;
        long numeroCuenta;
        System.out.println("Ingrese No.Cuenta para Consultar: ");
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

        System.out.println("Monto: ");
        monto = lector.nextDouble();
        System.out.println("Saldo Anterior: ");
        saldoAnterior = lector.nextDouble();
        System.out.println("Saldo Actual: ");
        saldoActual = lector.nextDouble();
        Movimientos movimientos = new Movimientos("Deposito", new Date(), monto, saldoAnterior, saldoActual);
        cuentaBancaria.getCuentaNomina().depositar(movimientos);
        System.out.println();
    }

    public static void retirar(CuentaBancaria cuentaBancaria){
        double monto, saldoAnterior, saldoActual;

        System.out.println("Monto: ");
        monto = lector.nextDouble();
        System.out.println("Saldo Anterior: ");
        saldoAnterior = lector.nextDouble();
        System.out.println("Saldo Actual: ");
        saldoActual = lector.nextDouble();
        Movimientos movimientos = new Movimientos("RETIRO", new Date(), monto, saldoAnterior, saldoActual);
        cuentaBancaria.getCuentaNomina().retirar(movimientos);
        System.out.println();
    }

    public static void consultarSaldo(CuentaBancaria cuentaBancaria) {
        double total = 0;
        CuentaNomina cuentaNomina = cuentaBancaria.getCuentaNomina();
        ArrayList<Movimientos> movimientos = cuentaNomina.getMovimientos();
        for (Movimientos item : movimientos){
            if(item.getTipo().equals("Deposito")){
                total += item.getMonto();
            } else {
                total -= item.getMonto();
            }
        }
        System.out.println("Saldo Total: "+total);
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

