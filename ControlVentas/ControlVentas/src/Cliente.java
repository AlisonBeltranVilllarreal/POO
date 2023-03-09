import java.util.ArrayList;
import java.util.Date;

public class Cliente extends Persona{
    private String rfc, domicilio;
    private ArrayList<Factura> facturas;
    

    public Cliente(String nombre, String apellidoPaterno, String apellidoMaterno, Date fechaNacimiento, String rfc, String domicilio, ArrayList<Factura> facturas) {
        super(nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento);
        this.rfc = rfc;
        this.domicilio = domicilio;
        this.facturas = facturas;
        
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

    public ArrayList<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(ArrayList<Factura> facturas) {
        this.facturas = facturas;
    }
}
