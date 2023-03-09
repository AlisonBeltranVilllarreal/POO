import java.io.*;
public class Archivos2 {
    public static void main(String[]args){
        File f=new File("d:\\archivos.txt"); //f-> cargar el archivo
        try{
            FileWriter fw=new FileWriter(f,true); //fw->crea el flujo hacia f
            PrintWriter pw=new PrintWriter(fw); //pw->permite la escritura en el archivo
            for(int i=1;i<=20;i++){
                pw.println(i); //se intoduce el valor de i en el archivo
            }
            fw.close();//se ciera el flujo del archivo
    }
    catch(IOException e){
        System.out.println("error"); //si no se puede acceder al archivo
     }
    }
}
