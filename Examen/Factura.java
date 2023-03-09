import java.util.ArrayList;
import java.util.Scanner;


public class Factura {

    public Fecha fechadeNaciemito;
    public float subTotal, iva, total;

    public static Scanner lector= new Scanner(System.in);
    public static ArrayList<Productos> productoss;
    public static ArrayList<Factura> facturas;
    public static ArrayList<TestFactura> testFacturas;

    float subtotal;
    int id2;
    String descripcion2;
    float precio2;


   public Factura (int id2, String descripcion2, float precio2){
       this.id2= id2;
       this.descripcion2= descripcion2;
       this.precio2=precio2;
   }
        public float getSubTotal(){
       return this.subTotal;
    }


    public float subtotal(){

        return subtotal = (float) (precio2+precio2);
        }

       /*float subtotal=0;
        for (Factura p: facturas){
                p.precio2+= subtotal;
                System.out.println(subtotal);

        */

    public void iva(){

    }

    public void total(){

    }


    public static void listarFactura(){
        for (Factura p: facturas){
            p.ImprimirFacturas();
        }
    }

    public void ImprimirFacturas(){
        System.out.println("\n----------------Producto Buscado-------------------");
        System.out.println("ID del producto: " +id2);
        System.out.println("Descripcion del producto: "+descripcion2);
        System.out.println("Precio del producto: " +precio2);
    }

}


