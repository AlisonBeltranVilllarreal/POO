import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

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

    /*Producto++
    Porcentaje+=10%producto*/

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

    public String toString() {
        return  nombre + " " + apellidoPaterno + " " + apellidoMaterno +
                "," + formatFecha() + ", Area: " + area + ", Comisión: " + porcentajeComision + ", Sueldo: " + sueldoBase;
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

    public static Vendedor leerVendedor() {
        String nombre, apellidoPaterno, apellidoMaterno, area;
        Date fechadeNacimiento;
        float porcentajeComision;
        int dia, mes, anio;
        int sueldoBase,dni;

        System.out.println("\n----------Agregar Vendedor------------");
        System.out.println("Dni:");
        dni= lector.nextInt();
        System.out.println("Nombre: ");
        nombre = lector.next();
        System.out.println("Apellido Paterno: ");
        apellidoPaterno = lector.next();
        System.out.println("Apellido Materno: ");
        apellidoMaterno = lector.next();
        System.out.println("Fecha Nacimiento: ");
        System.out.println("Dia:  ");
        dia = lector.nextInt();
        System.out.println("Mes:  ");
        mes = lector.nextInt();
        System.out.println("Anio:  ");
        anio = lector.nextInt();
        fechadeNacimiento = new Date(anio - 1900, mes - 1, dia);
        System.out.println("Area: ");
        area=lector.next();
        System.out.println("Porcentaje de Comision: ");
        porcentajeComision=lector.nextInt();
        System.out.println("Sueldo Base: ");
        sueldoBase=lector.nextInt();

        return new Vendedor (nombre, apellidoPaterno, apellidoMaterno, fechadeNacimiento,area,porcentajeComision,sueldoBase,dni);
    }
    public static void Compras() {

    }
    public static void agregarVendedor(){
        System.out.println("--------AGREGAR VENDEDOR--------");
        System.out.print("Ingresa el nombre del Vendedor: ");
        String agregarVen=lector.next();
        for (Vendedor p:vendedores){
            if (agregarVen.equals(p.nombre)){
                vendedores.add(p);
            }
        }
    }


//Agregar ID

}
