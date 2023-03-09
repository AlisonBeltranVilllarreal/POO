import java.util.ArrayList;
import java.util.Scanner;


public class Productos {

    public int id;
    public String descripcion;
    public float precio;
    public static Scanner lector= new Scanner(System.in);

    public  ArrayList<Productos> productoss;

    public Productos(int id, String descripcion, float precio){

        this.id=id;
        this.descripcion=descripcion;
        this.precio=precio;
    }

    public int getId(){
        return this.id;
    }
    public String getDescripcion(){
        return this.descripcion;
    }
    public float getPrecio(){
        return this.precio;
    }
    
    public static Productos agregar(){
        int id;
        String descripcion;
        float precio;
        System.out.println("\n Agregar producto ");
        System.out.println("Agregar su ID: ");
        id=lector.nextInt();
        System.out.println("Agregar descripcion: ");
        descripcion=lector.next();
        System.out.println("Agregar Precio: ");
        precio=lector.nextFloat();
        return new Productos(id,descripcion,precio);
    }

    public void ImprimirDatos(){
        System.out.println("\n Producto Buscado ");
        System.out.println("ID del producto: " +id);
        System.out.println("Descripcion del producto: "+descripcion);
        System.out.println("Precio del producto: " +precio);
    }

}