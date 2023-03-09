import java.util.Scanner;
import java.util.ArrayList;


public class Productos {
    private int id;
    private String descripcion;
    private float precio;
    public static Scanner lector = new Scanner(System.in);
    public static ArrayList<Productos> productos = new ArrayList<Productos>();

    public Productos(int id, String descripcion, float precio) {
        this.id = id;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public void imprimirDatos() {
        System.out.println("ID del producto: ");
        System.out.println(id);
        System.out.println("Descripcion del producto: ");
        System.out.println(descripcion);
        System.out.println("Precio del producto");
        System.out.println(precio);
    }

    //Permite ingresar los datos de un producto nuevo
    public static Productos leerProducto() {
        int id;
        String descripcion;
        float precio;
        System.out.println("ID del producto: ");
        id = lector.nextInt();
        System.out.println("Descripcion del Producto: ");
        descripcion = lector.next();
        System.out.println("Precio del producto: ");
        precio = lector.nextInt();
        return new Productos(id, descripcion, precio);
    }
}
