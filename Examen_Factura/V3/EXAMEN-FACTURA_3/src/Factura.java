import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.Collections;

public class Factura {
    public static Scanner lector = new Scanner(System.in);
    private Date fechaFactura;
    private float subTotal;
    private float iva = (16 / 100);
    private float total;
    public static ArrayList<Productos> productos = new ArrayList<Productos>();
    private static Vendedor vendedor;
    static Factura factura;

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
    public ArrayList<Productos> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Productos> productos) {
        this.productos = productos;
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

    //Imprime los datos de la factura
    public void imprimirFactura() {
        //System.out.println("ID: " + id);
        System.out.println("Fecha Factura: " + formatFecha());
        System.out.println("Productos: ");
        for (Productos p : productos){
            p.imprimirDatos();
        }
        System.out.println("Subtotal: " + subTotal);
        System.out.println("Iva: " + iva);
        System.out.println("Total: " + total);
    }

    //Permite comenzar una factura
    public static void agregarFactura() {
        int anio, mes, dia;
        Date fechaFactura = new Date(-1900, -1, 00);
        float subTotal = 0, iva = 0, total = 0;
        //Arraylist de productos
        System.out.println("Dia: ");
        dia = lector.nextInt();
        System.out.println("Mes: ");
        mes = lector.nextInt();
        System.out.println("Anio: ");
        anio = lector.nextInt();
        int op = 0, producto, compra;
        System.out.println("Deseas agregar o eliminar un producto? \n Agregar/1  Eliminar/2");
        compra = lector.nextInt();
        switch (compra) {
            case 1:
                do {
                    agregarProductos();
                    System.out.println("Deseas añadir otro articulo? \nSi/1  No/0");
                    op = lector.nextInt();
                } while (op != 0);
                break;
            case 2:
                do {
                    eliminarProductos();
                    System.out.println("Deseas eliminar otro articulo? \nSi/1  No/0");
                    op = lector.nextInt();
                } while (op != 0);
        }
        System.out.println("Subtotal: ");
        System.out.println(subTotal); 
        System.out.println("IVA: ");
        System.out.println(iva);    
        System.out.println(subTotal+iva);
        System.out.println("Total: ");
       
        factura = new Factura(productos, fechaFactura, subTotal, iva, total, vendedor);
    }

    //Agrega Productos a la factura
    public static void agregarProductos() {
        System.out.print("Agregar por ID: ");
        int agregarID = lector.nextInt();
        for (Productos p : productos) {
            if (agregarID == p.getId()) {
               producto = p;
            }
        }
    }

    //Elimina Productos de la factura
    public static void eliminarProductos() {
        System.out.print("ID del producto que deseas eliminar: ");
        int eliminarProducto = lector.nextInt();
        for (Productos p : productosComprados) {
            if (eliminarProducto == p.getId()) {
                productosComprados.remove(p);
            }
        }
    }

    //Obtener el Subtotal
    public double calcularSubTotal() {
        for (Productos p : productosComprados) {
            subTotal += p.getPrecio();
        }
        return subTotal;
    }

    //Obtener el IVA
    public float calcularIVA() {
        for (Productos p : productosComprados) {
            iva += (p.getPrecio()) * .16;
        }
        return iva;
    }
    public String formatFecha() {
        SimpleDateFormat sfd = new SimpleDateFormat("dd/MM/yyyy");
        String fechaFormat = sfd.format(new Date());
        return fechaFormat;
    }

}
