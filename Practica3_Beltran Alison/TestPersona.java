
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
        int calificacion;
        String continuar=null;
        int contador=1;
        int op = 0;

        do {
            System.out.println("1.- Agregar Empleado ");
            System.out.println("2.- Agregar Estudiante");
            System.out.println("3.- Agregar Empleado Comision");
            System.out.println("4.- Eliminar en determinada posicion");
            System.out.println("5.- Eliminar primera ocurrencia");
            System.out.println("6.- Contar Empleados");
            System.out.println("7.- Listar Empleados");
            System.out.println("8.- Calificacion Estudiante");
            System.out.println("9.- Ventas Empleado Comision");
            System.out.println("10.- Consultar Estudiante");
            System.out.println("11.- Consultar Empleado");
            System.out.println("12.- Consultar Empleado Comision");
            System.out.println("13.- Agregar en determinada posicion");
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
                System.out.println("Ingresa la posicion donde deseas eliminar: ");
                    int pos = lector.nextInt();
                    personas.remove(pos);
                    break;

                case 5:
                System.out.println("Se elimino la primera ocurrecia");
                    personas.remove(pos=0);
                    break;

                case 6:
                    System.out.println("Cantidad de Empleados Almacenados: " + personas.size());
                    break;

                case 7:
                    listarEmpleados();
                    break;
                case 8:
                System.out.println("Ingrese DNI de estudiante: ");
                dni = lector.nextInt();
                for (Persona1 p:personas){
                        if(dni ==p.getDni()&& p instanceof Estudiante) {
                            ((Estudiante)p).nuevaCalificacion(leerCalificacion());
                    break;
                        }
                }

                case 9:
                System.out.println("Ingrese DNI del Empleado Comision, para agregar Venta: ");
                 dni = lector.nextInt();
                for (Persona1 p:personas){
                    if(dni ==p.getDni()&& p instanceof EmpleadoComision) {
                    ((EmpleadoComision)p).vender(leerVenta());
                    break;
                }
            }
                    case 10:
                    System.out.println("Ingrese DNI para consultar estudiante: ");
                         dni = lector.nextInt();
                    for (Persona1 p:personas){
                        if(dni ==p.getDni()&& p instanceof Estudiante) {
                        ((Estudiante)p).imprimirDatos();
                        break;
                    }
                }
                
                case 11:
                System.out.println("Ingrese DNI para consultar al Empleado: ");
                        dni = lector.nextInt();
                for (Persona1 p:personas){
                    if(dni ==p.getDni()&& p instanceof Empleado1) {
                    ((Empleado1)p).imprimirDatos();
                    break;
                }
            }
                case 12:
                System.out.println("Ingrese para consultar DNI del Empleado Comision: ");
                     dni = lector.nextInt();
                for (Persona1 p:personas){
                    if(dni ==p.getDni()&& p instanceof EmpleadoComision) {
                    ((EmpleadoComision)p).imprimirDatos();
                    break;
                }
            }     
                    case 13:
                    System.out.println("Ingresa la posicion donde deseas agregar: ");
                    pos = lector.nextInt();
                    personas.add(pos, leerEmpleado1());
                    break;
            }
          }while(op != 0);

    }

    public static Empleado1 leerEmpleado1() {
        String nombre;
        Date dateNacimiento;
        int dni, sueldoBase;
        System.out.println("Nombre: ");
        nombre = lector.next();
        // System.out.println("Fecha Nacimiento: ");
        dateNacimiento = new Date();
        System.out.println("DNI: ");
        dni = lector.nextInt();
        System.out.println("Sueldo Base: ");
        sueldoBase = lector.nextInt();
        return new Empleado1(nombre, dateNacimiento, dni, sueldoBase);
    }

    public static Estudiante leerEstudiante() {
        String nombre = " ";
        Date fechaNacimiento = new Date();
        int dni = 0;
        System.out.println("Nombre: ");
        nombre = lector.next();
        System.out.println("Escribe DNI: ");
        dni = lector.nextInt();
        System.out.println("Ingresa Puntuacion Total: ");
       int puntuacionTotal = lector.nextInt();
       System.out.println("Ingresa Calificacion: ");
       int numeroCalificaciones = lector.nextInt();
        return new Estudiante(nombre, fechaNacimiento, dni, puntuacionTotal, numeroCalificaciones);
    }

    public static EmpleadoComision leerEmpleadoComision() {
        String nombre = " ";
        Date fechaNacimiento = new Date();
        int dni = 0;
        System.out.println("Nombre: ");
        nombre = lector.next();
        System.out.println("Ingresa DNI: ");
        dni = lector.nextInt();
        System.out.println("Ingresa Sueldo Base: ");
        int sueldoBase= lector.nextInt();
        System.out.println("Ingresa Porcentaje Comision: ");
        double porcentajeComision= lector.nextDouble();
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

    public static void listarEmpleados() {
        for (Persona1 p : personas) {
            p.imprimirDatos();
            System.out.println();
        }
    }

}
