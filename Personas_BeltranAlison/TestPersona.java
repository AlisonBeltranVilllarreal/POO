import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

class TestPersona {
    public static Persona persona;
    public static ArrayList<Persona> personas = new ArrayList<>();
    public static Scanner lector = new Scanner(System.in);

    public static void main(String[] args) {

        Scanner lector = new Scanner(System.in);
        int op = 0;

        do {
            System.out.println("1.- Registrar Persona ");
            System.out.println("2.- Buscar Persona");
            System.out.println("3.- Modificar Persona");
            System.out.println("4.- Eliminar Persona");
            System.out.println("5.- Listar Persona");
            System.out.println("0.- Salir");
            System.out.println("Selecciona una opcion: ");
            op = lector.nextInt();

            switch (op) {

                case 1:
                    personas.add(leerPersona());
                    break;
                case 2:
                    System.out.println("Ingrese nombre para consultar Persona: ");
                    String nom = lector.next();
                    for (Persona p:personas){
                        if(nom.equals(p.getNombre())){
                            p.imprimirDatos();
                        }
                    }
                    break;
                case 3:
                    System.out.println("Ingresa la posicion donde deseas modificar: ");
                    int pos = lector.nextInt();
                    personas.remove(pos);
                    personas.add(pos, leerPersona());
                    break;

                case 4:
                    System.out.println("Ingresa la posicion donde deseas eliminar: ");
                    int posi = lector.nextInt();
                    personas.remove(posi);
                    break;
                case 5:
                    listarPersonas();
                    break;
            }
        }while(op != 0);

        File f=new File("F:\\Persona.txt"); //f-> cargar el archivo
    try{
        FileWriter fw=new FileWriter(f); //fw->crea el flujo hacia f
        fw.close();//se ciera el flujo del archivo
    }
    catch(IOException e){
    System.out.println("error"); //si no se puede acceder al archivo
         }
        ListarMensaje();
    }

    public static Persona leerPersona() {
        String nombre,apellidoPaterno, apellidoMaterno, direccion;
        System.out.println("Nombre: ");
        nombre = lector.next();
        System.out.println("Apellido Paterno: ");
        apellidoPaterno = lector.next();
        System.out.println("Apellido Materno: ");
        apellidoMaterno = lector.next();
        System.out.println("Apellido Direccion: ");
        direccion = lector.next();
        return new Persona(nombre, apellidoPaterno, apellidoMaterno, direccion );
    }

    public static void listarPersonas() {
        for (Persona p : personas) {
            p.imprimirDatos();
            System.out.println();
        }
    }

    public static void ListarMensaje() {
        for (Persona p: personas){
            p.ImprimirMensaje();
            System.out.println();
        }
        
    }

}


