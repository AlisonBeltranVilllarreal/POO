
import java.util.Scanner;
import java.util.Date;
import java.util.ArrayList;

class TestPersona {
    public static Empleado1 empleado1;
    public static ArrayList<Persona1> personas = new ArrayList<>();
    public static Scanner lector = new Scanner(System.in);

    public static void main(String[] args) {

        Empleado1 empleado1;
        Scanner lector = new Scanner(System.in);

        int dni;
        int op = 0;

        do {
            System.out.println("1.- Agregar Empleado ");
            System.out.println("2.- Eliminar en determinada posicion");
            System.out.println("4.- Eliminar primera ocurrencia");
            System.out.println("5.- Listar Empleados");
            System.out.println("6.- Consultar Empleado");
            System.out.println("7.- Agregar en determinada posicion");
            System.out.println("0.- Salir");
            System.out.println("Selecciona una opcion: ");
            op = lector.nextInt();

            switch (op) {

                case 1:
                    personas.add(leerEmpleado1());
                    break;
                case 2:
                System.out.println("Ingresa la posicion donde deseas eliminar: ");
                    int pos = lector.nextInt();
                    personas.remove(pos);
                    break;
                case 3:
                System.out.println("Se elimino la primera ocurrecia");
                    personas.remove(pos=0);
                    break;
                case 5:
                    listarEmpleados();
                    break;
                case 6:
                 System.out.println("Ingrese DNI para consultar al Empleado: ");
                            dni = lector.nextInt();
                    for (Persona1 p:personas){
                        if(dni ==p.getDni()&& p instanceof Empleado1) {
                        ((Empleado1)p).imprimirDatos();
                        break;
                    }
                }  
                    case 7:
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

    public static void listarEmpleados() {
        for (Persona1 p : personas) {
            p.imprimirDatos();
            System.out.println();
        }
    }

}

