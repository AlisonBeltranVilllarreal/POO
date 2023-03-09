import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.io.*;

public class Cliente extends Persona {
    private String rfc;
    private String domicilio;
    public static Scanner lector = new Scanner(System.in);
    public ArrayList <Factura> facturas = new ArrayList<>();

    public Cliente(String nombre, String apellidoPaterno, String apellidoMaterno, Date fechaNacimiento, String rfc, String domicilio, ArrayList<Factura> facturas) {
        super(nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento);
        this.domicilio = domicilio;
        this.rfc = rfc;
        this.facturas = facturas;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public void imprimirDatosClientes(){

       
    }

    public void imprimirDatos() {
        System.out.println("Nombre:");
        System.out.println(nombre);
        System.out.println("Apellido Paterno:");
        System.out.println(apellidoPaterno);
        System.out.println("Apellido Materno:");
        System.out.println(apellidoMaterno);
        System.out.println("Fecha de nacimiento:\n" + formatFecha());
        System.out.println("RFC:");
        System.out.println(rfc);
        System.out.println("Domicilio:");
        System.out.println(domicilio);
    }

    //Permite ingresar los datos de un cliente nuevo
    public static Cliente leerCliente() {
        String nombre, apellidoPaterno, apellidoMaterno, rfc, domicilio;
        int anio, mes, dia;
        Date fechaNacimiento;
        System.out.println("Nombre: ");
        nombre = lector.next();
        System.out.println("Apellido Paterno: ");
        apellidoPaterno = lector.next();
        System.out.println("Apellido Materno: ");
        apellidoMaterno = lector.next();
        System.out.println("Fecha Nacimiento: ");
        System.out.println("Dia: ");
        dia = lector.nextInt();
        System.out.println("Mes: ");
        mes = lector.nextInt();
        System.out.println("Anio: ");
        anio = lector.nextInt();
        fechaNacimiento = new Date(anio - 1900, mes - 1, dia);
        System.out.println("RFC");
        rfc = lector.next();
        System.out.println("Domicilio: ");
        domicilio = lector.next();
        return new Cliente(nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento, rfc, domicilio, new ArrayList<Factura>());
    }
}
