import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Cliente extends Persona {
    private String rfc;
    private String domicilio;
    public ArrayList<Factura> compras = new ArrayList<Factura>();

    public Cliente(String nombre, String apellidoPaterno, String apellidoMaterno, Date fechaNacimiento, String rfc, String domicilio) {
        super(nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento);
        this.domicilio = domicilio;
        this.rfc = rfc;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    /*public Compra comprar() {
        compras.add()
    }*/

    public void imprimirDatos() {
        System.out.println("Nombre:");
        System.out.println(nombre);
        System.out.println("Apellido Paterno:");
        System.out.println(apellidoPaterno);
        System.out.println("Apellido Materno:");
        System.out.println(apellidoMaterno);
        System.out.println("Fecha de nacimiento:\n" + formatFecha());
        System.out.println("RFC:");
        System.out.println(rfc);
        System.out.println("Domicilio:");
        System.out.println(domicilio);
    }

   /* @Override
    public int hashCode() {
        return rfc.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        Cliente c = (Cliente) obj;

        return c.getRfc().equals(this.getRfc());

    }*/
}
