import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Factura {
    public static Scanner lector;
    private int id2;
    private String descr;
    private float pre;
    
    private ArrayList<Productos> productos = new ArrayList();
    private Vendedor vendedor;

    public Factura (int id2, String descr, float pre){
       this.id2= id2;
       this.descr= descr;
       this.pre=pre;
   }
}
