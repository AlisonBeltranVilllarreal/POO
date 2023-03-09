
import java.util.Scanner;
import java.util.Date;
import java.util.ArrayList;

class TestPersona {
    public static Empleado1 empleado1;
    public static Estudiante estudiante;
    public static ArrayList<Persona1> personas = new ArrayList<>();
    public static Scanner lector = new Scanner(System.in);

    public static void main(String[] args) {

        Empleado1 empleado1;
        Estudiante estudiante;
        EmpleadoComision empleadocomision;
        Scanner lector = new Scanner(System.in);

        String nombre;
        Date dateNacimiento;
        int dni, sueldoBase;
        int op = 0;

        do {
            System.out.println("1.- Agregar Empleado ");
            System.out.println("2.- Agregar Estudiante");
            System.out.println("3.- Agregar Empleado Comision");
            System.out.println("4.- Listar Personas");

            System.out.println("5.- Agregar Calificacion Estudiante");
            System.out.println("6.- Agregar Ventas Empleado Comision");

            System.out.println("7.- Consultar Estudiante");
            System.out.println("8.- Consultar Empleado");
            System.out.println("9.- Consultar Empleado Comision");
            System.out.println("0.- Salir");
            System.out.println("Selecciona una opcion: ");
            op = lector.nextInt();

            switch (op) {

                case 1:
                    personas.add(leerEmpleado1());
                    break;

                case 2:
                    personas.add( leerEstudiante());
                    break;
                case 3:
                    personas.add( leerEmpleadoComision());
                    break;
                case 4:
                    listarEmpleados();
                    break;

                case 5:
                System.out.println("Ingrese DNI de estudiante para agregar calificion: ");
                dni = lector.nextInt();
                for (Persona1 p:personas){
                        if(dni ==p.getDni()&& p instanceof Estudiante) {
                            ((Estudiante)p).nuevaCalificacion(leerCalificacion());
                        }
                }
                break;

                case 6:
                System.out.println("Ingrese DNI del Empleado Comision, para agregar Venta: ");
                 dni = lector.nextInt();
                for (Persona1 p:personas){
                    if(dni ==p.getDni()&& p instanceof EmpleadoComision) {
                    ((EmpleadoComision)p).vender(leerVenta());
                }
            }
            break;
                    case 7:
                    System.out.println("Ingrese DNI para consultar estudiante: ");
                         dni = lector.nextInt();
                    for (Persona1 p:personas){
                        if(dni ==p.getDni()&& p instanceof Estudiante) {
                        ((Estudiante)p).imprimirDatos();
                    }
                }
                break;
                
                case 8:
                System.out.println("Ingrese DNI para consultar al Empleado: ");
                        dni = lector.nextInt();
                for (Persona1 p:personas){
                    if(dni ==p.getDni()&& p instanceof Empleado1) {
                    ((Empleado1)p).imprimirDatos();
                }
            }
            break;
                case 9:
                System.out.println("Ingrese para consultar DNI del Empleado Comision: ");
                     dni = lector.nextInt();
                for (Persona1 p:personas){
                    if(dni ==p.getDni()&& p instanceof EmpleadoComision) {
                    ((EmpleadoComision)p).imprimirDatos();
                }
            }     
            break;
            }
          }while(op != 0);

    }

    public static Empleado1 leerEmpleado1() {
        String nombre;
        Date dateNacimiento = new Date(-1900, -1, 00);
        int dia, mes, anio;
        int dni, sueldoBase;
        System.out.println("Nombre: ");
        nombre = lector.next();
        System.out.println("-Fecha Nacimiento-");
        System.out.println("Dia: ");
        dia = lector.nextInt();
        System.out.println("Mes: ");
        mes = lector.nextInt();
        System.out.println("Anio: ");
        anio = lector.nextInt();
        dateNacimiento = new Date(anio-1900,mes-1,dia);
        System.out.println("DNI: ");
        dni = lector.nextInt();
        System.out.println("Sueldo Base: ");
        sueldoBase = lector.nextInt();
        return new Empleado1(nombre, dateNacimiento, dni, sueldoBase);
    }

    public static Estudiante leerEstudiante() {
        String nombre = " ";
        int dia, mes, anio;
        Date dateNacimiento = new Date(-1900, -1, 00);
        int dni = 0;

        System.out.println("Nombre: ");
        nombre = lector.next();
        System.out.println("-Fecha Nacimiento-");
        System.out.println("Dia: ");
        dia = lector.nextInt();
        System.out.println("Mes: ");
        mes = lector.nextInt();
        System.out.println("Anio: ");
        anio = lector.nextInt();
        dateNacimiento = new Date(anio-1900,mes-1,dia);
        System.out.println("Escribe DNI: ");
        dni = lector.nextInt();

        return new Estudiante(nombre, dateNacimiento, dni);
    }

    public static EmpleadoComision leerEmpleadoComision() {
        String nombre = " ";
        int dia, mes, anio;
        Date dateNacimiento = new Date(-1900, -1, 00);
        int dni = 0;

        System.out.println("Nombre: ");
        nombre = lector.next();
        System.out.println("-Fecha Nacimiento-");
        System.out.println("Dia: ");
        dia = lector.nextInt();
        System.out.println("Mes: ");
        mes = lector.nextInt();
        System.out.println("Anio: ");
        anio = lector.nextInt();
        dateNacimiento = new Date(anio-1900,mes-1,dia);
        System.out.println("Ingresa DNI: ");
        dni = lector.nextInt();
        System.out.println("Ingresa Sueldo Base: ");
        int sueldoBase= lector.nextInt();
        System.out.println("Ingresa Porcentaje Comision: ");
        double porcentajeComision= lector.nextDouble();
        return new EmpleadoComision(nombre, dateNacimiento, dni, sueldoBase, porcentajeComision);
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

    public static void listarEmpleados() {
        for (Persona1 p : personas) {
            p.imprimirDatos();
            System.out.println();
        }
    }

}