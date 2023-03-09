import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.*;

public class Persona{
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String direccion;


    public Persona(String nombre, String apellidoPaterno, String apellidoMaterno,String direccion){
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.direccion = direccion;
    }
    public String getNombre(){ return this.nombre; }
    public String getApellidoPaterno(){ return this.apellidoPaterno; }
    public String getApellidoMaterno(){ return this.apellidoMaterno; }
    public String getDireccion(){ return this.direccion; }

    public void imprimirDatos(){
        System.out.println("Nombre: "+ nombre);
        System.out.println("Apellido Paterno: " + apellidoPaterno);
        System.out.println("Apellido Materno: " + apellidoMaterno);
        System.out.println("Direccion: " + direccion);
    }

    public void ImprimirMensaje(){
    File f=new File("F:\\Persona.txt"); //f-> cargar el archivo
    try{
        FileWriter fw=new FileWriter(f, true); //fw->crea el flujo hacia f
        PrintWriter pw=new PrintWriter(fw); //pw->permite la escritura en el archivo
            pw.println("\nNombre: "+ getNombre() + "\nApellido Paterno: "+ getApellidoPaterno() + "\nApellido Materno: "+ getApellidoMaterno() + "\nDireccion: "+ getDireccion()); //se intoduce el valor en el archivo

        fw.close();//se ciera el flujo del archivo
    }
    catch(IOException e){
    System.out.println("error"); //si no se puede acceder al archivo
         }
    }

}
