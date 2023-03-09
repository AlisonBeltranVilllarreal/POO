import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;

public class TestPersona_v2 {
    public static Empleado empleado;
    public static Scanner lector = new Scanner(System.in);
    public static ArrayList<Persona> personas = new ArrayList<Persona>();
    public static Estudiante estudiante;
    public static EmpleadoComision empleadoComision;


    public static void main(String[] args) {
        int op = 0;
        do {
            System.out.println("1.- Agregar Empleado ");
            System.out.println("2.- Agregar Estudiante");
            System.out.println("3.- Agregar Empleado Comision");
            System.out.println("4.- Buscar Empleado");
            System.out.println("5.- Buscar Estudiante");
            System.out.println("6.- Buscar Empleado Comision");
            System.out.println("7.- Agregar Calificacion Estudiante");
            System.out.println("8.- Agregar Ventas Empleado Comision");
            System.out.println("0.-Salir");
            System.out.println("Seleccione opción: ");
            op = lector.nextInt();
            switch (op) {
                case 1:
                    personas.add(leerEmpleado());
                break;
                case 2:
                    personas.add(leerEstudiante());
                    break;
                case 3:
                    personas.add(leerEmpleadoComision());
                    break;
                case 4:
                    int DNI;
                    System.out.println("Ingrese DNI para consultar al Empleado: ");
                    DNI = lector.nextInt();
                    for (Persona p:personas) {
                        if (DNI == p.getDni() && p instanceof Empleado) {
                            ((Empleado) p).imprimirDatos();
                            break;
                        }
                    }
                    break;
                case 5:
                    System.out.println("Ingrese DNI para consultar estudiante: ");
                    DNI = lector.nextInt();
                    for (Persona p:personas){
                        if(DNI ==p.getDni()&& p instanceof Estudiante) {
                            ((Estudiante)p).imprimirDatos();
                            break;
                        }
                    }
                    break;
                case 6:
                    System.out.println("Ingrese DNI para consultar Empleado Comision: ");
                    DNI = lector.nextInt();
                    for (Persona p:personas){
                        if(DNI ==p.getDni()&& p instanceof EmpleadoComision) {
                            ((EmpleadoComision)p).imprimirDatos();
                            break;
                        }
                    }
                    break;
                case 7:
                    System.out.println("Ingrese DNI de estudiante: ");
                    DNI = lector.nextInt();
                    for (Persona p:personas){
                        if(DNI ==p.getDni()&& p instanceof Estudiante) {
                            ((Estudiante)p).nuevaCalificacion(leerCalificacion());
                            break;
                        }
                    }
                    break;
                case 8:
                    System.out.println("Ingrese DNI del Empleado Comision: ");
                    DNI = lector.nextInt();
                    for (Persona p:personas){
                        if(DNI ==p.getDni()&& p instanceof EmpleadoComision) {
                            ((EmpleadoComision)p).vender(leerVenta());
                            break;
                        }
                    }
                    break;
            }
        } while (op != 0);
    }

    public static Empleado leerEmpleado() {
        String nombre;
        int dni, sueldoBase;
        int dia, mes, anio;
        Date fechaNacimiento = new Date(-1900, -1, 00);
        System.out.println("Nombre: ");
        nombre = lector.next();
        System.out.println("Fecha Nacimiento: ");
        System.out.println("Dia: ");
        dia = lector.nextInt();
        System.out.println("Mes: ");
        mes = lector.nextInt();
        System.out.println("Anio: ");
        anio = lector.nextInt();
        fechaNacimiento = new Date(anio - 1900, mes - 1, dia);
        System.out.println("DNI: ");
        dni = lector.nextInt();
        System.out.println("Sueldo Base: ");
        sueldoBase = lector.nextInt();
        return new Empleado(nombre, fechaNacimiento, dni, sueldoBase);
    }

    public static Estudiante leerEstudiante() {
        int dia, mes, anio;
        String nombre;
        Date fechaNacimiento = new Date(-1900, -1, 00);
        int dni;

        System.out.println("Nombre: ");
        nombre = lector.next();
        System.out.println("Fecha Nacimiento: ");
        System.out.println("Dia: ");
        dia = lector.nextInt();
        System.out.println("Mes: ");
        mes = lector.nextInt();
        System.out.println("Anio: ");
        anio = lector.nextInt();
        fechaNacimiento = new Date(anio - 1900, mes - 1, dia);
        System.out.println("DNI: ");
        dni = lector.nextInt();

        return new Estudiante(nombre, fechaNacimiento, dni);

    }

    public static EmpleadoComision leerEmpleadoComision() {
        double porcentajeComision;
        String nombre;
        int dni, sueldoBase;
        int dia, mes, anio;
        Date fechaNacimiento = new Date(-1900, -1, 00);
        System.out.println("Nombre: ");
        nombre = lector.next();
        System.out.println("Fecha Nacimiento: ");
        System.out.println("Dia: ");
        dia = lector.nextInt();
        System.out.println("Mes: ");
        mes = lector.nextInt();
        System.out.println("Anio: ");
        anio = lector.nextInt();
        fechaNacimiento = new Date(anio - 1900, mes - 1, dia);
        System.out.println("DNI: ");
        dni = lector.nextInt();
        System.out.println("Sueldo Base: ");
        sueldoBase= lector.nextInt();
        System.out.println("Ingresa Porcentaje Comision: ");
        porcentajeComision= lector.nextDouble();
        return new EmpleadoComision(nombre, fechaNacimiento, dni, sueldoBase, porcentajeComision);
    }
    public static int leerCalificacion() {

                System.out.println("Calificacion: ");
                int calificacion = lector.nextInt();
                return calificacion;

    }

    public static int leerVenta() {
        System.out.println("Ventas $: ");
        int venta = lector.nextInt();
        return venta;
    }

}
/*System.out.println("Ingrese DNI de la persona: ");
        int DNI = lector.nextInt();
        if(personas.get(DNI).getDni()==DNI){
        for (Persona p:personas){
        if(DNI ==p.getDni()&& p instanceof Estudiante) {
        ((Estudiante) p).nuevaCalificacion(leerCalificacion());
        }
        else if(DNI==p.getDni()&& p instanceof Empleado){
        ((Empleado)p).imprimirDatos();
        }
        else if(DNI==p.getDni()&& p instanceof  EmpleadoComision){
        ((EmpleadoComision)p).vender(leerVenta());
        }
        }
        }
        break;*/