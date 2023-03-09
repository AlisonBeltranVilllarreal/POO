import java.text.Format;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;


public class Factura {
    private int id;
    private Cliente cliente;
    private Date fechaFactura;
    private float subTotal, iva, total;
    private ArrayList<Productos> productos;
    private Vendedor vendedor;

    public Factura(int id, Cliente cliente, Date fechaFactura, float subTotal, float iva, float total, ArrayList<Productos> productos, Vendedor vendedor) {
        this.id = id;
        this.cliente = cliente;
        this.fechaFactura = fechaFactura;
        this.subTotal = subTotal;
        this.iva = iva;
        this.total = total;
        this.productos = productos;
        this.vendedor = vendedor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(Date fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public float getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(float subTotal) {
        this.subTotal = subTotal;
    }

    public float getIva() {
        return iva;
    }

    public void setIva(float iva) {
        this.iva = iva;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public ArrayList<Productos> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Productos> productos) {
        this.productos = productos;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public void imprimirDatos() {
        System.out.println("ID: "+ id);
        System.out.println("Fecha: "+ formatFecha());
        System.out.println("Subtotal: "+ subTotal);
        System.out.println("IVA: "+ iva);
        System.out.println("Total: "+ total);
        System.out.println();
        System.out.println("Productos: ");
        for (Productos p : productos){
            p.imprimirDatos();
        }
        System.out.println();
        System.out.println("Vendedor: ");
        vendedor.imprimirDatos();
    }

    public String formatFecha() {
        SimpleDateFormat sfd = new SimpleDateFormat("dd/MM/yyyy");
        String fechaFormat = sfd.format(new Date());
        return fechaFormat;
    }
}
