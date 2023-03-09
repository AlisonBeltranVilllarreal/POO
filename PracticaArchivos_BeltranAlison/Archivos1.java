import java.io.*;
public class Archivos1 {
    
    public static void main(String[] args){
    File f=new File("d:\\archivos.txt"); //f-> cargar el archivo
        try{
            FileReader fr=new FileReader(f); //fr->creaer el flujo hacia f
            BufferedReader br=new BufferedReader(fr);//br-> permite la lectura
            String linea=br.readLine(); //linea toma el valor de la primera linea
            while(linea!=null) //mientras haya datos en el archivo
            {
                System.out.println(linea);
                linea=br.readLine();
            }
            fr.close(); //cierra el archivo
        }
        catch(IOException e){
            System.out.println("error"); //si no se puede acceder al archivo
        }
    }
}
