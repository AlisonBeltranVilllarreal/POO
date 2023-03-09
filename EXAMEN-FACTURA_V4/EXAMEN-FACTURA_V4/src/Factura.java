import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Factura {
    public static Scanner lector = new Scanner(System.in);
    private Date fechaFactura;
    private float subTotal;
    private float iva = (16 / 100);
    private float total;
    private static ArrayList<Productos> productos = new ArrayList<Productos>();
    private static ArrayList<Productos> productosComprados = new ArrayList<Productos>();

    private Vendedor vendedor;

    public Factura(ArrayList<Productos> productos, Date fechaFactura, float subTotal,
                   float iva, float total, Vendedor vendedor) {
        this.productos = productos;
        this.fechaFactura = fechaFactura;
        this.subTotal = subTotal;
        this.iva = iva;
        this.total = total;
        this.vendedor = vendedor;
    }

    public Date getFechaFactura() {
        return fechaFactura;
    }

    public float getSubTotal() {
        return subTotal;
    }

    public float getIva() {
        return iva;
    }

    public float getTotal() {
        return total;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }


    public void setFechaFactura(Date fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public void setSubTotal(float subTotal) {
        this.subTotal = subTotal;
    }

    public void setIva(float iva) {
        this.iva = iva;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public void imprimirFactura() {
        System.out.println("Fecha Factura: \n" + formatFecha());
        System.out.println("Productos: ");
        for (Productos p : productos) {
            p.imprimirDatos();
        }
        System.out.println("Subtotal: " + subTotal);
        System.out.println("Iva: " + iva);
        System.out.println("Total: " + total);
    }

    //Agrega Productos a la factura
    public static void agregarProductos() {
        System.out.print("Agregar ID: ");
        int agregarID = lector.nextInt();
        for (Productos p : productos) {
            if (agregarID == p.getId()) {
                productosComprados.add(new Productos(p.getId(), p.getDescripcion(), p.getPrecio()));
            }
        }
    }

    //Elimina Productos de la factura
    public static void eliminarID() {
        System.out.print("Agregar ID: ");
        int eliminarProducto = lector.nextInt();
        productos.remove(eliminarProducto);
    }

    //Obtener el Subtotal
    public double calcularSubTotal() {
        for (Productos p : productosComprados){
            subTotal += p.getPrecio();
        }
        return subTotal;
    }

    public String formatFecha() {
        SimpleDateFormat sfd = new SimpleDateFormat("dd/MM/yyyy");
        String fechaFormat = sfd.format(fechaFactura);
        return fechaFormat;
    }
}
