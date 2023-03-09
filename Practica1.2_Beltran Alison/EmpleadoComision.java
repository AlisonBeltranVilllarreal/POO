
import java.util.Date;

public class EmpleadoComision extends Empleado1 {
    private double porcentajeComision = 0.10;
    private int dineroVentas =0 ;
    private int sueldoBase;

    public EmpleadoComision(String nombre, Date dateNacimiento, int dni,
            int sueldoBase, double porcentajeComision) {
            super(nombre, dateNacimiento, dni, sueldoBase);
            this.porcentajeComision= porcentajeComision;
            this.dineroVentas =0;

    }

    public void vender(int dineroVenta) {
        this.dineroVentas += dineroVenta;
    }

    public void imprimirDatos(){
        System.out.print("DNI: ");
        System.out.println(getDni());
        System.out.println("NOMBRE: " + getNombre());
        System.out.println("FECHA DE NACIMIENTO: " + formatdate());
        System.out.println("Sueldo base:" + getSueldo());
        System.out.println("Comision: ");
        System.out.println((double)this.dineroVentas* this.porcentajeComision/100.0);

    }

    public int getSueldo() {
        return (sueldoBase + (int) (dineroVentas * porcentajeComision / 100.0));
    }
}
