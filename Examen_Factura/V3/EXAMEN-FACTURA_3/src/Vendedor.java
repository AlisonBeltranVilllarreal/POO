import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.io.*;

public class Vendedor extends Persona {
    private String area;
    private float porcentajeComision, dineroVentas;
    private int sueldoBase, dni;
    public static ArrayList<Vendedor> vendedores;
    public static Scanner lector = new Scanner(System.in);

    public Vendedor(String nombre, String apellidoPaterno, String apellidoMaterno, Date fechaNacimiento, String area, float porcentajeComision, int sueldoBase, int dni) {
        super(nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento);
        this.area = area;
        this.porcentajeComision = porcentajeComision;
        this.sueldoBase = sueldoBase;
        this.dni = dni;
    }

   /* public void imprimirDatosClientes(){
    File iDP=new
                File("F:\\Vendedor.txt");
        try{
            FileWriter fw=new FileWriter(iDP,true);
            PrintWriter pw=new PrintWriter(fw);
            {
                pw.println("\nVendedor: " +"\nNombre: "+nombre +"\nApellido Paterno: "+apellidoPaterno+"\nApellido Materno: "+apellidoMaterno+
                        "\nFecha de Nacimiento: "+formatFecha()+
                        "\nArea: "+area+ "\nComision: " +porcentajeComision+ "\nSueldo: "+sueldoBase+ "\n Dni: "+dni);
            }
            fw.close();

        } catch (IOException lol){
            System.out.println("Error");
        }*/


    public int getDni() {
        return dni;
    }

    public int setDni() {
        return dni;
    }

    public String getArea() {
        return area;
    }

    public float getPorcentajeComision() {
        return porcentajeComision;
    }

    public int getSueldoBase() {
        return sueldoBase;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void setPorcentajeComision(float porcentajeComision) {
        this.porcentajeComision = porcentajeComision;
    }

    public void setSueldoBase(int sueldoBase) {
        this.sueldoBase = sueldoBase;
    }

    public void setDineroVentas(float dineroVentas) {
        this.dineroVentas = dineroVentas;
    }
    public float calcularComision() {
        return sueldoBase + ((int) (dineroVentas * porcentajeComision / 100.0));
    }

    public void imprimirDatos(){
        System.out.println("Nombre: ");
        System.out.println(nombre);
        System.out.println("Apellido Paterno: ");
        System.out.println(apellidoPaterno);
        System.out.println("Apellido Materno: ");
        System.out.println(apellidoMaterno);
        System.out.print("Fecha de nacimiento: /n" + formatFecha());
        System.out.println("Area: ");
        System.out.println(area);
        System.out.print("Comision: ");
        System.out.println((double)this.dineroVentas* this.porcentajeComision/100.0);
        System.out.println();
    }

    //Permite ingresar los datos de un Vendedor nuevo
    public static Vendedor leerVendedor() {
        String nombre, apellidoPaterno, apellidoMaterno, area;
        float porcentajeComision;
        int sueldoBase, dni;
        int dia, mes, anio;
        Date fechaNacimiento = new Date(-1900, -1, 00);
        System.out.println("Nombre: ");
        nombre = lector.next();
        System.out.println("Apellido Paterno: ");
        apellidoPaterno = lector.next();
        System.out.println("Apellido Materno: ");
        apellidoMaterno = lector.next();
        System.out.println("DNI: ");
        dni = lector.nextInt();
        System.out.println("Fecha Nacimiento: ");
        System.out.println("Dia: ");
        dia = lector.nextInt();
        System.out.println("Mes: ");
        mes = lector.nextInt();
        System.out.println("Anio: ");
        anio = lector.nextInt();
        fechaNacimiento = new Date(anio - 1900, mes - 1, dia);
        System.out.println("Area: ");
        area = lector.next();
        System.out.println("Porcentaje comision: ");
        porcentajeComision = lector.nextFloat();
        System.out.println("Sueldo base: ");
        sueldoBase = lector.nextInt();
        return new Vendedor(nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento, area, porcentajeComision, sueldoBase, dni);
    }


}
