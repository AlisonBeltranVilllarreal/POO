import java.util.ArrayList;
import java.util.Scanner;

public class Vendedor extends Persona{

    public String area;
    public float porcentajeComision;
    public int sueldoBase;
    public static Scanner lector=new Scanner(System.in);
    public static ArrayList<Vendedor> vendedores;

    public Vendedor(String nombre, String apePaterno, String apeMaterno, Fecha fechaNacimiento,
                    String area, float porcentajeComision, int sueldoBase){

        super(nombre, apePaterno, apeMaterno, fechaNacimiento);
        this.area=area;
        this.porcentajeComision=porcentajeComision;
        this.sueldoBase=sueldoBase;
    }



    public static Vendedor leerVendedor() {

        String nombre, apePaterno, apeMaterno, area;
        Fecha fechadeNacimiento;
        float porcentajeComision;
        int dia, mes, anio;
        int sueldoBase;

        System.out.println("\n----------Agregar Vendedor------------");
        System.out.println("Nombre: ");
        nombre = lector.next();
        System.out.println("Apellido Paterno: ");
        apePaterno = lector.next();
        System.out.println("Apellido Materno: ");
        apeMaterno = lector.next();
        System.out.println("Fecha Nacimiento: ");
        System.out.println("Dia:  ");
        dia = lector.nextInt();
        System.out.println("Mes:  ");
        mes = lector.nextInt();
        System.out.println("Anio:  ");
        anio = lector.nextInt();
        fechadeNacimiento = new Fecha(dia,mes, anio);
        System.out.println("Area: ");
        area=lector.next();
        System.out.println("Porcentaje de Comision: ");
        porcentajeComision=lector.nextInt();
        System.out.println("Sueldo Base: ");
        sueldoBase=lector.nextInt();

        return new Vendedor (nombre, apePaterno, apeMaterno, fechadeNacimiento,area,porcentajeComision,sueldoBase);
    }

    public static void Compras() {

    }

    public void ImprimirVendedor(){
        System.out.println("--------VENDEDOR--------");
        System.out.println("Nombre: "+nombre);
        System.out.println("Apellido Paterno: "+apePaterno);
        System.out.println("Apeliido Materno: "+apeMaterno);
        System.out.println("Fecha de nacimiento: ");
        getFechaNacimiento().imprimir();
        System.out.println("Area: "+area);
        System.out.println("Porcentaje de comision: "+porcentajeComision);
        System.out.println("Sueldo Base: "+sueldoBase);
    }


    public float calcularComision(){

        return calcularComision();
    }

}